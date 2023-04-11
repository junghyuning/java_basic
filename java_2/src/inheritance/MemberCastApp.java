package inheritance;

public class MemberCastApp {
	public static void main(String[] args) {
		
		/* 부모클래스 참조변수 new 부모클래스(); 부모클래스의 생성자로 객체 생성 
		 * => 부모클래스 참조변수에 저장 - 가능
		 */
		Member member1 = new Member();
		
		//참조변수에 저장된 부모클래스의 객체를 사용하여 부모클래스의 메서드 호출
		member1.setId("abc123");
		member1.setName("홍길동");
		member1.display();
		System.out.println("===============================================================");
		// 자식클래스 참조변수 = new 자식클래스();
		//=> 부모클래스의 생성자로 부모클래스 객체를 생성한 후, 자식클래스의 생성자로 자식객체를 생성 -> 참조변수에는 자식클래스의 객체를 저장.
		//=> 이렇게 할 경우, 참조변수에 저장된 객체는 자식클래스일지라도 자식클래스가 부모클래스를 참조할 수 있으므로
		//=> 결론적으로 부모클래스까지 호출 가능해짐.\
		
		MemberEvent member2 = new MemberEvent();
		member2.setId("xyz789");
		member2.setName("임꺽정");
		member2.setEmail("xyz@itwill.xyz");
		member2.display();
		System.out.println("===============================================================");
		
		//부모클래스 참조변수 = new 자식클래스();
		// 자식클래스 객체 생성시, 부모클래스를 먼저 생성하므로, 부모클래스와 자식클래스 모두 생성된 것이므로 사용가능.
		// 부모클래스의 참조변수에는 결국 부모객체를 저장함.
		Member member4 = new MemberEvent();
		
		member4.setId("opq456");
		member4.setName("전우치");
		//member4.setEmail("-------");  // 부모클래스의 멤버만 사용가능
		
		// 객체 형변환 사용시, 부모클래스의 참조변수로 자식 클래스의 메서드 호출 가능해짐.
		// => 명시적 객체형변환 & 묵시적 객체 형변환(자동형변환) << 상속관계의 클래스에서만 객체 형변환 가능.
		
		//#1 명시적 객체형변환 : Cast 연산자 사용 -> 부모클래스 참조변수 자료형을 "일시적"으로 자식클래스로 변경하면, 참조변수는 자식클래스의 객체를 저장함.
		
		MemberEvent event = (MemberEvent)member4;  // 자식객체의 참조변수에 자식객체 저장.
		event.setEmail("opq@itwill.xyz");
		event.display();
		//but 그냥 member4.display(); 해도 결과 같음... 왜? => 묵시적 형변환 때문.
		//오버라이딩된 메서드의 경우, 오버라이딩된 자식 메서드의 것만 사용하도록 정해져있음 (부모메서드는 숨겨져있어 자식메서드 사용함)
		// 
		System.out.println("===============================================================");
		//=> 필드를 쓰지않고 간단화. 단, .연산자가 우선 연산되므로 형변환을 ()로 묶어 우선연산해줘야함. 
		
		((MemberEvent)member4).setEmail("opa@itwill.xyz");
		((MemberEvent)member4).display();
		
		
	}

}
