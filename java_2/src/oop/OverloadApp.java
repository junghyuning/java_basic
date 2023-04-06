package oop;

public class OverloadApp {
	public static void main(String[] args) {
		Overload overload = new Overload();
		
		overload.displayInt(100);  // 매개변수에 맞지않는 값을 전달할 경우 에러 발생.
		overload.displayBoolean(false);
		overload.displayString("홍길동");
		System.out.println("=========================================================================");
		
//		오버로드 선언된 메소드는 매개변수에 전달되는 값에 따라 메서드를 선택하여 호출
//		=> 메서드 오버로드에 의한 다형성
//		다형성이란? (Polymorphism) : 같은 이름의 메소드를 호출할 경우, 상태에 메소드를 선택 호출되는 기능
//		=> 메서드 오버로드, 오버라이드
		overload.display(200);
		overload.display(true);
		overload.display("임꺽정");
		
		
	}
}
