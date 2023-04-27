package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//UDP프로그램 : 연결x DatagramPacket 클래스를 이용하여 작성함.
//=> 값을 전달하는 컴퓨터와 값을 전달받는 컴퓨터로 구분하여 처리
//=> 누구한테 보내는지 상관없는 단방향 프로그램.

//키보드로 메세지를 입력받아 다른 컴퓨터에게 전달하는 UDP 프로그램 작성.
public class Net07_MessageSendApp {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("전달메세지 >> ");
		String message = in.readLine();
		
		//DatagramSocket class : 다른 컴퓨터와 연결하기 위한 정보를 저장하기 위한 클래스
		DatagramSocket socket = new DatagramSocket();
		
		//연결할 컴퓨터의 네트워크 식별자가 저장된 InetAdress 객체를 반환받아 저장
		InetAddress address = InetAddress.getByName("192.168.13.2");
		
		byte[] data = message.getBytes();
		
		//DatagramPacket 클래스 : 연결 컴퓨터에게 "보낼" 패킷정보를 저장하기 위한 클래스
		//=> DatagramPacket 클래스의 DatagramPacket(byte[] data, data.length, InetAddress,int port) 생성자를 사용
				
		DatagramPacket packet = new DatagramPacket(data, data.length, address, 4000);  // 송장 역할. 누구에게 무엇을 보낼지.
		
		//DatagramSocket.send(DatagramPacket packet) : 매개변수로 전달받은 DatagramPacket 객체의 패킷 정보를 이용하여 데이터(패킷)을 정달하는 메서드
		socket.send(packet);
		//데이타그램소켓 객체를 제거함.
		socket.close();
		
		System.out.println("[result] 연결 컴퓨터에게 메세지를 보냈습니다.");
		
		
	}
}
