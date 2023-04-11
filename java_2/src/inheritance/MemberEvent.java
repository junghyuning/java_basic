package inheritance;

//

//이벤트관련 회원정보를 저장하기 위한 class - ID, Name, E-mail
public class MemberEvent extends Member {  //자손클래스

	private String email;

	public MemberEvent() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * super 키워드 : 자식 클래스의 메소드에서 부모클래스의 객체 메모리 주소를 저장하기위한 키워드. // => 자식클래스의 메소드에서
	 * 부모 클래스 객체의 필드 or 메소드 참조하기위해 사용 // => 자식클래스의 메소드에서 super 키워드를 사용하지 않아도 자식클래스의
	 * 메소드에서는 this 키워드로 참조되는 필드와 메소드가 없을시 자동으로 부모 클래스의 멤버를 참조함.
	 * 
	 * super 키워드를 사용하는 경우 
	 * 1) 자식클래스의 생성자에서 부모클래스의 생성자를 호출하기위해 // 형식) super(값, 값,
	 * ...); // => if super 생략시, 부모클래스의 매개변수가 없는 기본 생성자를 호출하여 객체 생성. // => 생성자에서 다른
	 * 생성자를 호출하는 명령은 반드시 첫번째 명령으로 작성. //
	 * 
	 * 2) 자식클래스의 메서드에서 오버라이드 선언되어 숨겨진 부모클래스의 메서드를 호출할 경우 super 키워드 호출.
	 * 
	 * public MemberEvent(String id, String name, String email) { //alt shift s -> o
	 * -> select super constructor select에서 매개변수가 있는 생성자 선택 super(id, name);
	 * this.email = email; }
	 */
	public MemberEvent(String id, String name, String email) {
		super(id, name);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	/*
	 * 메서드 오버라이딩 : 상속관계에서 부모클래스의 메소드를 자식클래스에서 재선언 => 부모클래스의 메소드를 자식클래스의 객체가 사용하기
	 * 부적절한 경우, 부모클래스의 메서드를 자식클래스에서 재선언하여 사용하는 방법 부모클래스의 메서든느 숨겨지고, 자식클래스의 메서드만
	 * 접근가능. 메서드 오버라이딩 작성규칙 1. 접근제한자, 반환형, 메서드명, 매개변수, 예외전달을 사용하여 메서드 작성.
	 * 
	 * 
	 * 
	 * 
	 * @Override : 오버라이드 선언된 메서드 표현하기위한 어노테이션 어노테이션(Annotation) API 문서에서 특별한 설명을
	 * 제공하기 위한 기능의 자료형(인터페이스) =>현재는 Java Source 작성에 필요한 특별한 기능을 제공하기 위해 사용되는 어노테이션
	 * =>@Override, @Deprecated, @SuppressWarnings
	 */
	
	@Override
	public void display() {
//		System.out.println("id : " + super.getId());
//		System.out.println("name : " + super.getName());
		super.display();
		System.out.println("E-mail : " + email);
	}

}
