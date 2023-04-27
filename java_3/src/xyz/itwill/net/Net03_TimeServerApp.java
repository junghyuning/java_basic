package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


//접속된 클라이언트에게 서버 컴퓨터의 현재 날짜와 시간을 전달하는 서버 프로그램을 작성함.
//=>NTP(Network Time Protocol) Server : 날짜와 시간을 제공하는 서버 컴퓨터
public class Net03_TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer = null;
		
		try {
			ntpServer = new ServerSocket(2000);  //2000번 서버포트를 열어준 것.(포트 활성화 -> 클라이언트 접속가능 환경 제공)
			
			//ServerSocket.toString() : server socket 객체에 저장된 접속관련 정보를 문자열로 반환하는 메서드
			System.out.println("ntpServer = "+ntpServer);
			
			System.out.println("[message] NTP Server is Running");
			
			//서버 프로그램에 다수의 클라이언트 접속을 허용하도록 무한루프를 돌림 (접속 될때까지)
			//ServerSocket. accept() : 클라이언트가 접속되면 클라이언트와 값을 주고받을수 있는 Socket 객체를 반환하는 메서드.
			//=> 클라이언트가 접속되기 전까지 일시정지 상태로 대기 - 클라이언트가 접속되면 클라이언트의 소켓과 연결될 소켓을 생성 -> 반환 하고 스레드를 재실행함.
			while (true) {
				
				//연결요청이 들어왔을시, 클라이언트와 값을 주고받을수 있는 Socket 객체를 반환하는 메서드. ServerScoket.accept() => 해당 객체를 Socket 타입의 참조변수로 가리킴.
				Socket socket = ntpServer.accept();
				/**
				//Socket.getOutputStream() : Socket 객체의 출력스트림을 반환하는 메서드
				OutputStream stream = socket.getOutputStream(); 
				//객체를 전달받아 객체를 전달하고 싶기 때문에 ObjectOutputStream으로 확장시켜줘야 함.
				ObjectOutputStream output = new ObjectOutputStream(stream);
				
				
				//wirte() 출력 스트림을 이용해 세스템에 Date 객체를 생성-전달 함. (즉, 클라이언트에게 날짜와 시간을 전송함)
				output.writeObject(new Date());
				**/
				//=> 위의 주석처리한 부분을 별도의 변수선언 없이 한줄로도 수행할 수 잇음.
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//로그처리 = 기록
				System.out.println("[정보]클라이언트["+socket.getInetAddress().getHostAddress()+"]에게 날짜와 시간을 제공하였음.");
				
				//클라이언트와의 접속 해재 -> 더이상 주고받을 정보가 없으므로 꺼도 됨.
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[error] 서버 네트워크에 문제 발생.");
		} 
	}
}
