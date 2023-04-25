package ch1415;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;


// input 배열 -> input.read(배열) : 배열에 input 배열 저장. -> 
public class tempStr {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		byte[] temp = new byte[4];

		ByteArrayInputStream inputStream = null;
		ByteArrayOutputStream outputStream = null;

		inputStream = new ByteArrayInputStream(inSrc);
		outputStream = new ByteArrayOutputStream();

		try {
			while (inputStream.available() > 0) {
				int length = inputStream.read(temp); // 반환값이 정수일 경우, temp에 stream의 값을 저장한 후, 불러온 만큼의 길이만 반환함.
//				inputStream.read(temp);
//				outputStream.write(temp);
				outputStream.write(temp, 0, length);
//				System.out.println("temp = "+ Arrays.toString(temp));
				
				outSrc = outputStream.toByteArray();
				printArrays(temp,outSrc);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void printArrays(byte[] temp, byte[] outSrc) {
		// TODO Auto-generated method stub
		System.out.println("tempout = " + Arrays.toString(temp));
		System.out.println("output = " + Arrays.toString(outSrc));
		
		
	}
}
