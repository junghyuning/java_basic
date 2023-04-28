package ch16_Networking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(2222);
			
			System.out.println(getTime() +"서버가 준비되었습니다.");
		} catch (IOException e) {
			System.out.println("sever socket error");
		}
		
		while(true) {
			try {
				System.out.println(getTime()+"연결요청을 기다립니다.");
				Socket socket = serverSocket.accept();  //클라이언트의 소켓과 통신가능한 소켓객체를 생성하여 반환함(요청한 클라이언트의 정보를 가진 맞춤 소켓객체를 생서하는 것.)
				//socket.getInetAddress()
				System.out.println(getTime()+socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
				
				
				System.out.println("getport(): " + socket.getPort() + " / getLocalPort() : "+socket.getLocalPort());
				//소켓의 출력스트림을 얻는 것.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] Test Message1 from Server.");
				
				System.out.println(getTime()+" 데이터를 연결했습니다.");
				dos.close();
				socket.close();
			} catch (IOException e) {
				System.out.println("error");
			}
		}
	}

	static String getTime() {
		// TODO Auto-generated method stub
		SimpleDateFormat time = new SimpleDateFormat("[hh:mm:ss]");
		return time.format(new Date());
	}
}
