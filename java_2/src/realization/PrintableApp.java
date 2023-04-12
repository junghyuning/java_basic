package realization;

public class PrintableApp {
	public static void main(String[] args) {
		//기본메서드 사용 위해 참조변수를 인터페이스로 선언
		Printable printOne = new PrintSingle();
		
		printOne.print();
		printOne.scan();  // 인터페이스의 기본 메서드 호출
		System.out.println("=======================================================");
		
		Printable printTwo = new PrintMulti();
		
		printTwo.print();
		printTwo.scan();  // 디폴트메서드라도 자식이 오버라이딩한경우 오버라이딩 된 메서드 호출
		System.out.println("=======================================================");
	}
}
