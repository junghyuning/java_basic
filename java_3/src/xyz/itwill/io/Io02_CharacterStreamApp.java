package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Io02_CharacterStreamApp {
	public static void main(String[] args) throws IOException{
		System.out.println("[message] press the keyboard [exit: ctrl+z]");
		
		InputStreamReader in = new InputStreamReader(System.in);
//		OutputStreamWriter out = new OutputStreamWriter(System.out);
		PrintWriter out = new PrintWriter(System.out); // PrintWriter의 경우가 outputStreamWriter보다 많은 출력 메서드를 제공함.
		int readByte;
		
		while (true) {
			readByte = in.read();
			if(readByte==-1) {
				break;
			}
			out.write(readByte);
			
			out.flush();
		}
		System.out.println("[message] program ended");
	}
}
