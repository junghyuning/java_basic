package xyz.itwill06.oop;

//횡단관심코드로 작성된 메서드가 선언된 클래스

public class AopLogger {
	public void beforeLog() {
		System.out.println("### 메서드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
	}
}
