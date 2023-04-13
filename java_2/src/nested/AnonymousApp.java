package nested;

public class AnonymousApp {
	public static void main(String[] args) {
		//인터페이스를 상속받은 이름없는 자식클래스를 선언 -> 인터페이스의 멤서드를 오버라이드 선언하여 객체 생성 가능 -> 익명 내부클래스
		//엄밀히 말하면 지역클래스임. (Anonymous InnerClass) : 인터페이스 or 추상클래스를 상속받은 이름이 없는 자식클래스.
		//객체를 단하나만 만들때 사용 => 이벤트처리 할때 사용
		//익명클래스 선언 : 조상클래스 변수명 = 
		//익명클래스 객체 생성 : new 조상클래스명() { // 멤버선언 + 구현부메서드 오버라이딩 };
		
		Anonymous anonymous = new Anonymous() {  //컴파일시, 외부클래스명$숫자.class => 형식으로class 파일이 형성됨. 
			@Override
			public void display() {
				// TODO Auto-generated method stub
				System.out.println("익명의 내부클래스의 오버라이드메서드 호출");
			}
		};
		
		anonymous.display();
	}
}
