package oop;

//this 키워드 : 메서드 내부에 숨겨져있는 키워드
//=> 메서드를 호출한 객체의 메모리 주소(hashcode)를 자동으로 전달받아 저장하는 키워드
//=> 메서드 내부의 명령에서 객체의 필드 or 메서드를 사용하기 위해 this 키워드 사용
//this는 각 객체의 주소를 저장해주는 참조변수임 -> 하지만, 객체를 생성해도 객체는 멤버변수를 초기화하는 것이고 메서드에는 관여하지 않음. 
//따라서 메서드를 사용하고자 할때는 참조변수를 통해 메서드에 접근해서 사용하므로 메서드가 해당 객체의 변수를 정확히 사용할 수있도록 메서드 내부의 매개변수는 사실상 모두 this.변수로 각 객체의 변수 주소를 참조할수있도록 해야함.
//그러나 너무 당연하기때문에 생략이 되어있는 것임.

//=> 메서드에 this 키워드 존재하는 이유 : 
//=> 필드는 객체마다 메모리로 독립적으로 생성되지만, 메서드는 객체와 상관없이 메모리에 하나만 형성됨(프로토타입 클래스)
//=> 메소드에서 필드를 사용할 시, this 키워드로 객체를 명확히 구분하여 필드에 접근할수있도록 사용됨.

//this 키워드를 사용하는 경우
//1. 메서드에서 매개변수의 이름을 필드의 이름과동일하게 작성한 경우 필드를 표현(setter)
//2. 다른 생성자를 호출할 때 (맨윗줄에 써야함)



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
		 //사용하는 이유 : 초기화 코드가 항상 중복되므로 더 간략히 한 것.
		 // 다른명령보다 먼저 실행되도록 작성 - 다른 명령이 먼저 실행될 경우 error 발생
		 this("NoId", "Noname", "Noemail");
		 
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
