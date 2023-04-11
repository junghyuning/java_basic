package inheritance;

//상속 Inheritance : 클래스를 물려받아 사용하는 기능
//=> 기존 클래스를 확장 & 재활용
//=> 코드의 중복성 최소화 ->생산성 및 유지보수 효율성 up
//
//부모클래스 = 선조클래스 = 기본클래스 = 슈퍼클래스
//자식클래스 = 후손클래스 = 파생클래스 = 서브클래스

//상속시에도 생성자는 물려받지x // 부모클래스가 은닉화돼있다면, 상속관계이더라도 접근 불가.
//자식클래스의 생성자로 객체를 생성할 경우 부모클래스의 생성자가 먼저 호출됨 -> 부모클래스 객체 생성 -> 자식클래스 객체 생성
public class MemberEventApp {
	public MemberEventApp(String string) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MemberEvent member1 = new MemberEvent();
		
		member1.setId("abc123");  // 부모 객체(Member 객체) 참조. 
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz"); // 자식객체 참조(MemberEvent의 객체)
		
		member1.display();
		System.out.println("====================================================");
		
		
		MemberEvent member2 = new MemberEvent("xyz789", "임꺽정","xyz789@itwill.xyz");//
		member2.display();
		System.out.println("====================================================");
		
		
	}

}
