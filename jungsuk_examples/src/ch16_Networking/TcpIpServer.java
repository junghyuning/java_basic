package ch16_Networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			
			System.out.println(getTime() +"서버가 준비되었습니다.");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	static String getTime() {
		// TODO Auto-generated method stub
		SimpleDateFormat time = new SimpleDateFormat("[hh:mm:ss]");
		return time.format(new Date());
	}
}
