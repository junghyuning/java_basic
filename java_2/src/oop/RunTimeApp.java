package oop;

import java.io.IOException;

//Runtime 클래스 : java 프로그램에서 운영체제(Operation System) 관련 정보를 제공하는 기능의 메서드가 선언된 클래스.
//=> 생성자가 은닉화 선언되어있는 new 연산자로 객체 생성 불가
//=> Runtime 클래스는 프로그램에 객체를 하나만 제공하기 위한 클래스 = 싱글톤 클래스 中 하나임.
public class RunTimeApp {
	public static void main(String[] args) throws IOException {
		
		// Runtime runtime = new Runtime();  // 생성자가 은닉화 되어있어 오류 생김.\
		Runtime runtime1 = Runtime.getRuntime(); // Runtime 객체를 반환하는 메서드 -> gerRuntime 메서드는 static Runtime getRuntime(); => 즉, 반환타입이 Runtime임.
		Runtime runtime2 = Runtime.getRuntime(); // Runtime 클래스는 싱클톤 클래스이므로 runtime1의 주소와 runtime2의 주소는 같음.
		
		System.out.println(runtime1 + "|||||||" + runtime2);  // 실행시, 주소가 같음 
		//==> 즉, getRuntime()메서드는 객체를 새로 생성해주는 것이 아니라 하나의 동일한 객체를 여러 참조변수에 할당하는 것.
		
		System.out.println((runtime1.totalMemory()-runtime2.freeMemory())+"Byte"); // 전체메모리 - 여유메모리 = 사용중 메모리

		runtime1.gc(); // garbage Collector 실행 = 메모리 정리
		//System.gc();  
		//메모리 정리후 프로그램 메모리
		System.out.println((runtime1.totalMemory()-runtime2.freeMemory())+"Byte");
		
		runtime2.exec("calc.exe");  //  운영체제에 명령을 전달해 실행하는 메서드.
		System.out.println("==================================================================================");
		
	}
}
