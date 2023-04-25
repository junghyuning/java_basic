package xyz.itwill.io;

import java.io.IOException;

//키보드로 원시데이터 입력받아 모니터에 전달하여 출력함.
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[message] Press the KeyBoard. [exit : Ctrl + z]");
		// 입력값을 저장할 변수
		int readByte;

		while (true) {
			// System.in
			readByte = System.in.read();
//			EOF(Ctrl+z) 전달시, 반복문이 종료 됨.
			if (readByte == -1)
				break;
			System.out.write(readByte); // 모니터에 출력. printStream
		}
	}
}
