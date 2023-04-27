package xyz.itwill.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Net04_TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			
			/*
			  socket클래스 : TCP 프로그램에서 타겟(다른)컴퓨터와의 연결을 위한 정보를 저장하기위한 클래스 => 다른컴퓨터의 소켓과 연결되어 값 송수신 간으한 입출력 스트림을 제공
			  ->Socket 클래스의 Socket(String host, int port) 생성자를 이용 
			  -> 매개변수에 (접속할 컴퓨터의)서버의 네트워크 식별자(host 이름 or ip 주소)와 활성화된 포트번호를 전달하여 socket 객체를 생성 -> 접속.
			  => UnKnownHostException 및 IOException 발생 -> 일반예외이므로 반드시 예외처리 해줘야 함.  
			 */
			Socket socket = new Socket("127.0.0.1",2000);
			
//			System.out.println("socket = "+socket);
			
			InputStream stream = socket.getInputStream();
			
			ObjectInputStream in = new ObjectInputStream(stream);
			
			Date date = (Date)in.readObject();// object타입이므로 형변환필요
			
			
			//원하는 형식의 문자열로 변환하여 출력
			System.out.println("[result] 서버에서 보내온 날짜와 시간 = " + new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(date) );
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("[error] 서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("[error] 서버에 접속할 수 없습니다.");
		} 
	}
}
