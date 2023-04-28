package ch1415;

import java.io.IOException;

public class Ex21_StandardIO {
	public static void main(String[] args) {
		try {
			int input = 0;
			
			while ((input = System.in.read())!=-1) {
				System.out.println("input:"+input+",(char)input : "+(char)input);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
