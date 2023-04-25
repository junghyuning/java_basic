package ch1415;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOutputStreamEx1 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			
			BufferedOutputStream bos = new BufferedOutputStream(fos,5);
			
			for(int i = '1'; i<='9' ;i++) {
				bos.write(i);//버퍼는 가득 찼을 대만, fos에 저장할 것임.
			}
			bos.close(); // close()메서드를 호출하면 -> bos.flush() 호출 -> 모든 buffer내 데이터 write(); -> 기반스트림.close();
//			fos.close();  // 어차피 bufferedOutputStream 클래스는 FileOutputStream의 자손으로, bos.close() 호출 시, bos.flusch() 이후, fos.close() 호출함 -> 따라서 따로 닫아줄 필요가 x
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
