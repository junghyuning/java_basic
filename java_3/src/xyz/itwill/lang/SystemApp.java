package xyz.itwill.lang;

import java.util.Scanner;

//Java API = Application Programming Interface => 자바 프로그램 개발에 프로그램 기능을 제공하기위한 도구.
//=> 라이브러리를 통해 배포된 Java 자료형(클래스, 인터페이스, 열거형)

//java.lang 패키지 - java 프로그램 개발에 필요한 기본 자료형을 제공

//Object 클래스 : 모든 java클래스가 반드시 상속받는 부모 클래스 => 모든 java 클래스를 대신하여 사용할수 있는 대표class
//Class class : 메모리(메소드영역)에 저장된 클래스를 관련 정보를 저장하기 위한 클래스 = 클래즈라고 부름(클래스와 구분하기위함)

//System 클래스 : 표준 입출력 스트림을 제공하거나 시스템 기능을 메서드로 제공하는 클래스
public class SystemApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  // System.in : 자바에서 제공되는 표준 입력장치에 대한 입력 스트림.
		System.out.println("정수값 입력 >> ");  //System.out : 자바에서 제공하는 표준 출력장치
		int num = scanner.nextInt();
		
		if(num == 0) {
			System.out.println("[message] turn off the program.");
			//system.exit(int status) : 프로그램 강제종료
			System.exit(0);
		}
		
//		System.currentTimeMillis() : 시스템의 현재 날짜와 시간에 대한 타임스템프를 반환하는
//		타임스템프(TimeStamp) : 날짜와 시간을 정수값으로 표현하기위해 만들어진 시간값
//		1970-01-01 기준 1/1000초(1ms)당 1씩 증가된 정수값.
//		날짜와 시간을 정수값으로 표현하여 연산(-)하기 위한 사용.
		long startTime = System.currentTimeMillis();
//		System.out.println(startTime);  
		
		for(int i=1 ; i<=num; i++) {
			System.out.println(i+"번째 실행되는 명령");
		}
		
		long endTime=System.currentTimeMillis();
		System.out.println("실행시간 = "+ (endTime-startTime)+"ms");
		
		//System.gc() : 메모리를 청소하는 프로그램(Garbage Collector)를 실행하는 메서드
		System.gc();
		
		scanner.close();
	}
}
