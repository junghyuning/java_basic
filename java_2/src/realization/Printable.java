package realization;

public interface Printable {
	//추상메서드 => 반드시 오버라이드 선언 해야함.
	void print();
	
	
	//JDK11 이상에서는 인터페이스에 명령을 작성할 수 있는 기본메서드 선언이 가능
	//기본메서드 : 인터페이스를 상속받은 자식클래스에서 오버라이드를 선언하지 않아도 되는 메서드 -> 오버라이드 선언x시 기본 메서드 호출
	//but, 오버라이드 하지 못하는 것은 아니고 오버라이딩 해도 됨
	//형식)default 반환명 메서드명(자료형 매개변수,...){ 명령; . . .}
	default void scan() {
		System.out.println("[error] 스캔기능을 제공하지 않습니다. ");
	}
}
