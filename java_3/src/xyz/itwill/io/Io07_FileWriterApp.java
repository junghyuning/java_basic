package xyz.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Io07_FileWriterApp {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = new FileWriter("c:/data/char.txt",true);
		
		int readByte;
		while (true) {
			readByte = isr.read();
			if(readByte==-1) break;
			
			fw.write(readByte);
		}
		fw.close();
//		isr.close(); ??
		System.out.println("c:\\data\\char.txt 파일을 확인해 보세요.");
	}
}
