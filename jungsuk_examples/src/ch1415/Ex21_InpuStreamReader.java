package ch1415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex21_InpuStreamReader {
	public static void main(String[] args) {
		System.out.print("입력하세요>>");
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			String line = "";
			for(int i=1;(line=br.readLine())!=null;i++) {
				if(line.indexOf(";")!=-1)
					System.out.println(i+":"+line);
			}
			br.close();
		} catch (IOException e) {
			
		}
	}
}
