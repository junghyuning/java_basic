package ch1415;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(args[0]);
			FileOutputStream fos = new FileOutputStream(args[1]);
			
			int data = 0;
			
			while((data=fis.read())!=-1) {  // read()메서드 : 읽어온 값 (1byte 값을 int로 변환하여 0~255 사이의 값 반환) or -1(없을시,) 반환
				fos.write(data); //읽어온 값(int 정수)를 fos에 저장
				System.out.println(data);
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
