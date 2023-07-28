package xyz.itwill06.oop;

public class OopOne {
	//횡단관심 코드 - JSP의 IncludeDirective 
	/*
	 * public void beforeLog() {
	 * System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
	 * 
	 * }
	 */
	
	private OopLogger logger = new OopLogger();
	
	public void display1() {
		//횡단관심코드
		//System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
		//핵심관심코드
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display1() 호출");
	}                           
	public void display2() {    
//		System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
//		beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display2() 호출");
	}                           
	public void display3() {    
//		System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
//		beforeLog();		
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display3() 호출");
	}
}
