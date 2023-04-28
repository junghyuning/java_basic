package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Io06_FileInputStreamApp {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("c:/data/byte.txt");
		} catch (FileNotFoundException e) {
			System.out.println("[error] There's no \"c:/data/byte.txt\"");
		}
		System.out.println("[message] c:/data/byte/txt 파일에 저장된 내용입니다.");
		
		int readByte;
		
		while(true) {
			readByte = fis.read();
			
			if(readByte == -1) break;
			
			System.out.write(readByte);
		}
		
		fis.close();
	}
	
}
