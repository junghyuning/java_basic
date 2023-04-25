package ch1415;

import java.io.*;

//보조 스트림 : 버퍼, 데이터, 푸시백 스트림 
//그 자체로는 입출력 기능이 없고, 스트림의 기능을 보조하기 위한 클래스임.
public class DataOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		fos = new FileOutputStream("sample.dat");  // 예외처리시 없는 파일은 자동으로 생성됨. // 이름만 선언시, 프로젝트 파일 아래에 형성됨
		dos = new DataOutputStream(fos);
		dos.writeInt(10);
		dos.writeFloat(20.0f);
		dos.writeBoolean(true);
	
		dos.close();
		
		FileInputStream fis = new FileInputStream("sample.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println(dis.readInt());
		System.out.println(dis.readFloat());
		System.out.println(dis.readBoolean());
		
	}
}
