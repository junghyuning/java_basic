package inheritance;

// static 제한자 : 클래스(내부클래스), 메서드, 필드에 사용하는 제한자 
//=> 객체가 아닌 클래스로 접근하여 사용하는 제한자. 

//final 제한자 : 클래스, 메소드, 필드에 사용하는 제한자
//1.final 제한자를 필드에 사용하여 선언 - final 필드
//형식) 접근제한자 final 자료형 필드명 = 초기값;
//=> 필드값을 변경하지 못하도록 제한하는 기능 제공 - 필드에 저장된 값을 변경할 경우 에러 발생
//=> 필드를 선언할 때 반드시 초기값을 필드에 저장
//2.final 제한자를 메소드에 사용하여 선언 - final 메소드
//형식) 접근제한자 final 반환형 메소드명(자료형 매개변수명, ...) { }
//=> 자식클래스에 메소드를 오버라이드 선언하지 못하도록 제한하는 기능 제공
//3.final 제한자를 클래스에 사용하여 선언 - final 클래스
//형식) 접근제한자 final class 클래스명 { }
//=> final 클래스를 상속 받지 목하도록 제한하는 기능 제공

//사원정보(사원번호, 이름)를 저장하기 위한 클래스
//=> 모든 사원관련 클래스가 상속받는 부모 클래스
//부모 클래스 : 객체 생성 목적이 아닌 상속 목적으로 만들어진 클래스 -> 추상클래스로 쓰는 것을 권장
//추상클래스 (Abstract Class) : abstract 제한자를 사용하여 선언된 클래스 => 객체 생성 불가
//형식)public abstract class 클래스명 {  }

public abstract class Employee { // 추상 클래스
	private int empNo;
	private String empName;

	// 상수필드(Constant Field) : 프로그램에서 값(리터럴) 대신 사용하기 위한 의미있는 단어로
	// 제공되는 필드값
	// 형식) public static final 자료형 변수명 = 초기값;
	// => 상수명은 대문자로 작성하여 스네이크 표기법을 이용하여 작성하는 것을 권장
	public static final double INCENTIVE_RATE = 1.5;

	// 생성자
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	// getter, setter
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	// 일반메서드의 경우, 상속받는 클래스가 오버라이드 선언하지 않을 시, 부모클래스의 메서드가 호출될 뿐, 컴파일에러 발생x (but 비정상
	// 값)
	/*
	 * public int computePay() { return 0; }
	 */
	// 무조건 오버라이드 해야만 하는 메서드일 시, 추상 메서드로 제공하면 무조건 오버라이딩 해야함.
	public abstract int computePay();

	// 인센티브를 계산하여 반환하는 메소드
	// => 모든 사원에게 급여의 150%를 인센티브로 제공되도록 계산
	// 자식클래스에서 메소드를 오버라이드 선언하면 비정상적인 결과값 반환
	// => 자식클래스에서 메소드를 오버라이드 선언하지 못하도록 final 메소드로 선언
	public final int computeIncentive() {
		// 추상메소드를 호출한 경우 묵시적 객체 형변환에 의해 자식클래스의 메소드 호출
		// return (int)(computePay()*1.5);

		// 값 대신 상수를 사용 - 유지보수의 효율성 증가
		return (int) (computePay() * INCENTIVE_RATE);
	}

}
