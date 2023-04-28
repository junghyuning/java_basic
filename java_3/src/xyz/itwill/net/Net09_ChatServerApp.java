package xyz.itwill.net;

import java.awt.TexturePaint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//채팅서버 프로그램 - 다중 스레드 프로그램

public class Net09_ChatServerApp {
	
	private List<SocketThread> clientList;  // 현재 접속중인 클라이언트와 연결되는 소켓스레드를 저장하는  collection List 선언.
	
	public Net09_ChatServerApp() {
		ServerSocket chatServer = null;
		
		try {
			chatServer = new ServerSocket(5000);
			//소켓스레드(클라이언트와 관련됨)를 저장할 수 있는 리스트 생성
			clientList = new ArrayList<>();
			System.out.println("[message] chat Server running...");
			//여러 클라이언트가 접속해도 작동하도록 while문으로 무한루프 돌림 : 하나의 서버는 여러 클라이언트가 접촉할시 여러개의 소켓을 생성하고 보유할 수 있음.
			//if 소켓을 생성한 while문에서 소켓을 활용하여 바로 다른 작업을 할시, 해당 명령이 계속 이어져 while문이 교착상태에 빠질 수 있음
			//=> 메인 스레드에서는 단순하게 소켓을 생성하는 작동만 하도록 해야 함.
			while(true) {
				try{
					Socket socket = chatServer.accept();  //  클라이언트 접속시 클라이언트와 연결된 소켓 객체 생성 및 반환 
					
					System.out.println("[접속로그]"+socket.getInetAddress().getHostAddress()+"의 컴퓨터에서 서버에 접속하였스빈다.");
					
					SocketThread socketThread = new SocketThread(socket);  // 클라이언트가 접속할 때마다, 소켓 스레드 생성
					socketThread.start(); // main()스레드 외의 새로운 독립적 스레드 생성 => run() 호출 => 수행 : 이름을 읽고 List에 저장
					clientList.add(socketThread); // 리스트에 소켓스레드 객체 추가 함.
					
				}catch (IOException e) {
					System.out.println("[error Log] Client got problems");
				}
			}
		}catch (IOException e) {
			System.out.println("[error] server is not Working...");
		}
	}
	
	//서버 실행 - 소켓생성 or 오류
	public static void main(String[] args) {
		new Net09_ChatServerApp();
	}
	
	public void sendMessage(String  message) {
		//List에 저장된 요소(소켓스레드객체)를 차례로 제공받아 반복처리
		//외부클래스는 객체 생성방식을 사용하면, 내부클래스의 접근제한자에 관계없이 접근가능. => 
		for(SocketThread socketThread : clientList) {
			socketThread.out.println(message);
		}
	}
	
	
	// 클라이언트와 연결된 소켓을 이용하여 입출력 기능을 제공하기 위한 클래스
	//=> 독립적인 입출력 기능을 제공하기위해 새로운 스레드를 생성하여 명령을 실행할 수 있도록 Thread 클래스를 상속받아 run() 메서드를 오버라이딩 선언함.
	public class SocketThread extends Thread {
		
		private Socket client;
		
		
		//클라이언트에서 보내온 메세지를 읽기 위한 입력스트림을 저장하는 필드
		private BufferedReader in;
		//클라이언트에게 메세지를 보내기위한 출력 스트림을 저장하는 필드
		private PrintWriter out;
		
		
		public SocketThread(Socket client) {
			this.client = client;
		}
		
		
		//새로운 스레드가 샐행할 명령
		// 클라이언트에 보내는 메세지를 서버로부터 전달받아 모든 클라이언트에게 전달하는 명령을 작성함.
		@Override
		public void run() {
			//클라이언트의 대화명을 저장하기 위한 변수.
			String aliasName ="";
			//소켓의 입력스트림을 제공받아 대량의 문자데이터를 읽을수있는 (buffer) 입력스트림으로 확장하여 필드에 저장
			//소켓의 출력스트림을 제공받아 문자열을 전달할 수 있는 출력스트림으로 확장하여 필드에 저장함.
			try {
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				out = new PrintWriter(client.getOutputStream(),true);//boolean autoFlush => true 일시, 버퍼를 사용하지 않고 무조건 출력스트림으로 데이터를 전달 함.
				//if buffer를 거칠시, buffer가 꽉차야 출력스트림으로 정보를 보내기 때문에 반드시 flush()를 해줘야함. but autoflush  설정시 버퍼 거치지 않고 바로 출력하는것.
				
				//클라이언트에서 보내온 대화명을 반환받아 저장 => 단, 클라이언트가 대화명을 작성할 때까지 스레드가 일시 정지 됨.
				aliasName = in.readLine();
				
				//모든 클라이언트에게 입장 사실을 알림 - 환영 입장 메세지 출력(모두에게 보여야 함.)
				//but out 명령의 경우 1사람에게 못보냄. => 콜렉션 생성해야 함. =>  필드에 List<SocketThread> clientList; 생성함 => List 이용하여 sendMessage 메서드에서 일괄처리
				//모든 클라이언트에게 메세지 전달.
				sendMessage(aliasName+"님이 입장하셨습니다.");
				
				//클라이언트에서 보내온 메세지를 전달받아 모든 클라이언트에게 전달 (until 클라이언트가 접속을 종료하기 전까지 반복 while-true)
				//클라이언트가 종료할 경우 : IOException 발생 => 예외처리 : List 객체 목록에서 삭제 (소켓스레드 객체) + 다른 사용자들에게 퇴장메세지 전달 + 기록: 
				while (true) {
					sendMessage(aliasName +" : " + in.readLine());
					
				}
				
			} catch (IOException e) {
				clientList.remove(this); // 나 자신을 지우라는 명령
				sendMessage(aliasName+"님이 퇴장하셨습니다.");
				System.out.println("[해제로그]"+client.getInetAddress().getHostAddress()+"의 컴퓨터에서 서버에 접속해제 하였스비낟.");
				
			}
		}
	}
	
}
