package xyz.itwill06.oop;

public class OopTwo {
	/*
	 * public void beforeLog() {
	 * System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
	 * 
	 * }
	 */
	
	private OopLogger logger = new OopLogger();
	
	
	public void display1() {
//		System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display1() 호출");
	}                           
	public void display2() {    
//		System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display2() 호출");
	}                           
	public void display3() {    
//		System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display3() 호출");
	}
}
