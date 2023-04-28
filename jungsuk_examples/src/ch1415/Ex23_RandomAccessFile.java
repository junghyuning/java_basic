package ch1415;

import java.io.IOException;
import java.io.RandomAccessFile;

//InputStream이나 Outstream으로부터 상속받은 것이 아니라 
// datainput과 dataoutput을 모두 구현했기 때문에 java에서 유일하게 입출력을 모두 할 수 있음.
//dataInputStream 메서드 역시 dataInput 클래스를 구현한 클래스이므로, RandomAccessFile 클래스의 경우 dataInputStream 클래스와 비슷한 기능을 할 수 있다고 볼 수 있다. 
public class Ex23_RandomAccessFile {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf=new RandomAccessFile("test.dat", "rw");//읽기쓰기 가능한 모드
			System.out.println("파일 포인터의 위치: "+raf.getFilePointer()); 
			raf.writeInt(100);
			System.out.println("파일 포인터의 위치: "+raf.getFilePointer());//int - 4byte
			raf.writeLong(100L);
			System.out.println("파일 포인터의 위치: "+raf.getFilePointer());//long - 8Byte
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
