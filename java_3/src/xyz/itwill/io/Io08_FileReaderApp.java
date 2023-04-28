package xyz.itwill.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Io08_FileReaderApp {
		public static void main(String[] args) throws IOException {
			FileReader fr = null;
			
			try {
				fr = new FileReader("c:/data/char.txt");
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				System.out.println("[error] c:/data/char.txt 파일이 존재하지 않습니다.");
				System.exit(0);
			}
//			//OutputStreamWriter out=new OutputStreamWriter(System.out);
			PrintWriter pw = new PrintWriter(System.out);
			System.out.println("[메세지]c:\\data\\char.txt 파일에 저장된 내용입니다.");
			int readByte;
			while (true) {
				readByte = fr.read();
				
				if(readByte==-1) break;
				
				pw.write(readByte);
				pw.flush();
			}
			fr.close();
		}
}
