package xyz.itwill.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException{
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream("c:/data/data.txt"));
		
		out.writeInt(100);
		
		out.writeBoolean(true);
		
		out.writeUTF("홍길동");
		
		out.close();
		
		System.out.println("data.txt 파일을 확인해 보시오.");
		
		DataInputStream in = new DataInputStream(new FileInputStream("c:/data/data.txt"));
		
		//입력한 순서대로 출력해야함.
//		int value1 = in.readInt();
//		Boolean value2 = in.readBoolean();
//		String value3 = in.readUTF();

		
		System.out.println(in.readInt());
		System.out.println(in.readBoolean());
		System.out.println(in.readUTF());
		in.close();
	}
}
