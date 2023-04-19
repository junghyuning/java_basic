package xyz.itwill.util;

import java.util.Random;

//Random 클래스 : 난수값 관련 기능을 메서드로 제공받기 위한 클래스
public class RandomApp {
	public static void main(String[] args) {
		Random random = new Random();
		
		//Random.nextInt(int bound) : 0~bound-1 범위의 정수 난수값을 반환하는 메서드
		for(int i=1; i<=5; i++) {
			System.out.println(i + "번째 난수값 >> " + random.nextInt(100)); // 0~99
		}
	}
	
}
