package ch1415;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		ByteArrayInputStream input = new ByteArrayInputStream(inSrc); // inSrc에 대한 입력 스트림 생성
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data= 0;
//		data = input.read();
//		output.write(data);
//		outSrc = output.toByteArray();
//		System.out.println(Arrays.toString(outSrc));
		while((data = input.read())!=-1) {  // 스트림의 내용을 1바이트씩 읽어옴. 읽어올 내용이 없으면 -1 반환
			output.write(data); //주어진 배열 b의 내용을 모두 출력소스에 씀 
		}
		outSrc = output.toByteArray(); //outSrc 배열에 output Stream의 내용 반환
		
		System.out.println(Arrays.toString(outSrc));
	}

}
