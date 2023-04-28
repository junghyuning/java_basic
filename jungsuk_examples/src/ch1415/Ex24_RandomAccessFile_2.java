package ch1415;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

//국어점수의 합계만 피룡함
public class Ex24_RandomAccessFile_2 {
	public static void main(String[] args) {
		int sum=0;
		try {
			RandomAccessFile raf=new RandomAccessFile("score2.dat", "r");
			int i = 4;
			while(true) {
				raf.seek(i);
				sum += raf.readInt();
				i+=16; //한학생의 데이터가 번호와 3과목의 점수 -> 모두 4개의 int값으로 되어있음. -> 포인터의 값을 16씩 증가시킴.
				//이미 국어 점수를 읽어 포인터가 영어 앞으로 옮겨 갔더라도 i는 애초에 포인터의 위치가 아니라 임의의 정수이므로 값은 여전히 4인채로 남아있다. 
				//따라서 다음 학생의 점수를 읽어오기 위해서는 16을 더하는것이 맞음
			}
		} catch (EOFException e) {
			System.out.println("sum : "+sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
