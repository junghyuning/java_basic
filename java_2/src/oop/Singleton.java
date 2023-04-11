package oop;


//싱글톤 디자인패턴을 적용하여 작성된 클래스 -> 싱글톤 클래스
// 프로그램에 객체를 하나만 제공하기 위한 목적의 클래스를 작성하기 위해 사용 -> data를 처리하는 클래스의 경우 객체가 여러개일 필요x
//프로그램에 불필요한 객체가 생성되는 것을 방지하기 위한 디자인 패턴
public class Singleton {
	//클래스의 객체(메모리주소)를 저장하기위한 필드 선언
	//=> static 제한자를 사용하여 정적필드 선언
	//시스템 필드 -> 시스템 내부에서만 사용하는 필드로 외부와의 대화를 위한 메서드인 setter getter 작성x
	//일반적 필드와 구분하기위해 필등명을 _로 시작되도록 작성하는 것을 권장.
	private static Singleton _instance;
	
	private Singleton() {  // 생성자 은닉화! //싱글톤클래스의 특징 -> 따라서 상속도 불가함. 클래스 내부에서만 사용하는것.
							// 클래스 외부에서 추가적인 객체를 생성하는 것을 방지하는 것. 
							// 따라서 클래스 내부에서 객체를 1개 생성함(static영역에 작성함으로써 1번만 생성 가능 - class가 메모리에 로드 될 때 1번만 실행됨)
	}
	
//static block : 클래스를 읽어 메모리에 저장된 후 자동으로 실행될 명령을 작성하기위한 영역
//	=> 프로그램에서 한번만 실행 됨.
//	=> 정적 필드 or 메서드만 사용 가능함.
	
	static {
		//클래스로 객체 생성 -> 시스템필드에 저장
		// 프로그램에서 객체를 1개만 생성하여 필드 저장.
		_instance = new Singleton();
	}
	
	//시스템필드에 저장된 객체를 반환하는 메서드
	public static Singleton getInstance() {
		return _instance;
	}
	
	//인스턴스 메서드
	public void display() {
		System.out.println("Singleton 클래스의 인스턴스 메서드 호출.");
	}
	
	
}
