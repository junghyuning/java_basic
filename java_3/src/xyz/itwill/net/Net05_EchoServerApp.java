package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트에서 보내온 메세지를 제공받아 출력하는 서버 프로그램
public class Net05_EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer = null;
		
		try {
			echoServer = new ServerSocket(3000);
			System.out.println("[message] Echo Server Running . . .");
			
			Socket socket = echoServer.accept();
			
			//소켓의 입력스트림을 제공받아 대량의 문자데이터를 얻어올 수 있는 입력스트림을 확장.
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//getInetAddress(): hostname + ip  // getHostAddress : ip만 반환
			System.out.println("["+socket.getInetAddress().getHostAddress()+"]"+in.readLine());
		} catch (IOException e) {
			System.out.println("[error] Server get NetWork Problems.");
		}
	}
}
