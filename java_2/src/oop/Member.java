package oop;


//회원정보를 저장하기 위한 클래스
// VO(Value Object) : 특정 대상의 값을 저장할 목적의 객체를 생성하기위한 클래스

public class Member {
	
	private String id;
	private String name;
	private String email;
	//생성자 선언 : 객체를 생성하기위한 특별한 형태의 메서드 (for 상속)
	// => 생성자를 선언하지 않으면 기본생성자(매개변수가없는)를 제공함
	//	기본 생성자 : public Member() {}
	//	생성자를 선언하면 매개변수가 없는 기본 생성자 제공
	//	형식) 접근제한자 클래스명(자료형 변수명, 자료형 변수명, ...) { 명령; 명령; ...}
	//	반환형을 작성하지 않고 생성자의 이름은 반드시 클래스 이름과 동일하게 작성
	//	메소드 오버로드를 사용해 생성자를 여러개 선언 가능
	//	일반적으로 생성자에서는 필드에 필요한 초기값을 저장하기 위한 명령 작성 -> 초기화 작업
	
	//매개변수가 없는 생성자 선언 - 기본 생성자(default Constructor) - ctrl + space :
	// -> 초기화 작업 미구현 - 객체 필드에 기본값이 초기값으로 저장.
	 public Member() { //ctrl + space -> enter
		// TODO Auto-generated constructor stub
		 
	}
	
//	 매개변수가 있는 생성자 -> 매개변수에 전달되어 저장된 값을 필드의 초기값으로 저장 : Alt + Shift + S >> O >> 필드선택 >> generate
	 public Member(String id, String name, String email) {
		 this.id = id;
		 this.name = name;
		 this.email = email;
	 }


	 
	//메소드 선언
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

//	필드값을 확인하기 위해 필드값을 출력하는 메서드
	public void display() {
		System.out.println("ID = " +id);
		System.out.println("NAME = " +name);
		System.out.println("E-MAIL = " +email);
	}
	
	
	
	
	
	
	
}
