package xyz.itwill.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//다른 컴퓨터에서 보내온 메세지를 얻어와 출력하는 UDP프로그램
public class Net08_MessageReceiveApp {
	public static void main(String[] args) throws IOException{
		//데이터를 받는 컴퓨터는 포트를 활성화하기위해 DatagramSocket 클래스의 DatagramSocket(int port) 생성자 사용해 객체 생성.
		
		DatagramSocket socket = new DatagramSocket(4000); //다른 컴퓨터와 연결하기 위한 정보를 저장
		
		//패킷에 의해 전달된 값(메세지)을 저장하기 위한 byte 배열 선언.
		byte[] data = new byte[1024];
		
		//받는 컴퓨터는 DatagramPacket 클래스의 DatagramPacket(data, data.length); 생성자 이용 
		// 누구한테 받는지는 중요하지 않고, 단지 받을 내용만 알면 되므로 내용에관한정보만 있으면 됨.
		DatagramPacket packet = new DatagramPacket(data, data.length);
		
		System.out.println("message recieve");
		
		//DatagramSocket.recieve(DatagramPacket packet) : 연결 컴퓨터에서 보내온 값(패킷)을 얻어와 저장
		//=> 패킷을 받기 전까지는 일시 정지함.
		socket.receive(packet);
		
		//byte 배열에 저장된 값을 제공받아 String 객체를 생성 & 저장 & 출력
		String message = new String(data);
		System.out.println("recieved message >> "+message);
		
	}
}
