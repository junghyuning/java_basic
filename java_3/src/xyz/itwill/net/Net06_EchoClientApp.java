package xyz.itwill.net;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Net06_EchoClientApp {
	public static void main(String[] args) throws IOException {
		
		//키보드 입력 스트림을 대량의 문자데이터를 얻어올수 있는 입력스트림을 확장함.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("전달 메세지 입력 >> ");
		String message = in.readLine();
		
		try {
			Socket socket = new Socket("192.168.13.1",3000);
			/*  Buffered Writer 사용 방법
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//서버의 소켓과 연결된 출력스트림을 이용 -> 문자열(메세지) 전달
			out.write(message);
			//버퍼이므로 반드시 flush() 필요함
			out.flush();
			*/
			
			//소켓의 출력 스트림을 제공받아 모든 자료형의 값을 문자열로 변환하여 전달하는 기능의 출력 스트림으로 확장도 가능함.
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			// 매개변수로 전달받은 모든 값을 문자열로 변환하여 전달하는 메서드.
			out.println(message);
			out.flush();
			
			socket.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("error) 서버에 접속할 수 없습니다.");
		}
	}
}
