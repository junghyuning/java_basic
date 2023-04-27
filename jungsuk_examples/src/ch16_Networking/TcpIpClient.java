package ch16_Networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

//TCP-IP 통신은 양방향 통신..!
public class TcpIpClient {
	public static void main(String[] args) {
		try {
			String serverIP = "127.0.0.1";  // 소통할 서버의 ip 
			
			System.out.println("서버에 연결중입니다. 서버IP" + serverIP);
			//클라이언트의 소켓을 생성해서 연결을 요청할것..!
			Socket socket = new Socket(serverIP, 7777); // 서버의 정보를 가진 소켓 생성(서버소켓의 포트에 연결)
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			
			System.out.println("서버로부터 받은 메세지 : "+ dataInputStream.readUTF());
			System.out.println("연결을 종료합니다.");
			
			dataInputStream.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
		} catch (ConnectException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
