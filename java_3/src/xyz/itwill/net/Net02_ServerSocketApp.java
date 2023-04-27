package xyz.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;


//서버소켓 클래스 사용 -> 사용 가능한 포트번호 검색하는 프로그램 작성.
public class Net02_ServerSocketApp {
	public static void main(String[] args) {
		for(int i = 2000; i<=9000;i+=1000) {  // 1~2000은 well Known port 이므로 사용해서는 안됨
			try {
			/*ServerSocket 클래스 : 서버 프로그램을 작성하기 위해 사용하는 클래스
			=> ServerSocket 클래스의 ServerSocket(int port)  생성자를 이용하여 매개변수로 전달받은 포트번호를 활성화하여 ServerSocket 객체 생성
			=> ServerSocket 객체를 생성하여 클라이언트가 접속할 수 있는 환경 제공
			=> 매개변수로 전달받은 포트번호를 이미 다른 네트워크 프로그램에 사용중인 경우 IOException 발생
			*/
				ServerSocket serverSocket = new ServerSocket(i);
				System.out.println(i+"번 포트는 네트워크프로그램에서 사용 가능합니다.");
				
				serverSocket.close();
			}catch (IOException e) {
				
				System.out.println(i+"번 포트는 다른 네트워크프로그램에서 사용 중입니다.");
				e.getStackTrace();
			}
		}
	}
}
