package ch1415;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex23_RandomAccessFile_1 {
	public static void main(String[] args) {
		int[] score = {1,100,90,90,
					   2,70,90,100,
					   3,100,100,100,
					   4,70,60,80,
					   5,70,90,100};
		
		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw"); //read&write
			for(int i = 0; i<score.length;i++) {
				raf.writeInt(score[i]);  //write 명령을 수행하느라 포인터의 위치가 마지막으로 이동하였음
			}
			raf.seek(0);//포인터위치를 처음으로 보내줌.
			while (true) {
				System.out.println(raf.readInt());
			}
		}catch (EOFException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
}
