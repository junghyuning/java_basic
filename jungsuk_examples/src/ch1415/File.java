package ch1415;

import java.io.*;

public class File {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
		FileInputStream fileInputStream = new FileInputStream(args[0]);
		int data =0;
		
		while((data = fileInputStream.read())!=-1) {
			char c = (char) data;
			System.out.print(c);
		}
	}
}
