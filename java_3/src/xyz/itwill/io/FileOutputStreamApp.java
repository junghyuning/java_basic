package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[message] press the keyBoard [ exit : ctrl + x ]");
		
		// 매개변수로 전달받은 파일 경로의 파일이 없는 경우 FileNotFoundException 발생.
		//=> 예외처리: 매개변수로 받은 파일 경로의 파일을 자동으로 생성 -> 출력스트림 제공
		//파일이 존재하는 경우 : 새로운 내용이 파일에 저장 됨. (덮어쓰기-override)
		FileOutputStream fos = new FileOutputStream("c:/data/byte.txt",true);
		int readByte;
		
		while(true) {
			readByte = System.in.read();
			
			if(readByte==-1) break;
			
			fos.write(readByte); // 파일 출력스트림으로 원시데이터를 전달하여 저장.(save)
		}
		
		fos.close(); //파일 출력스트림을 제거하는 메서드
	}
}
