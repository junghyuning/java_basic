package inheritance;

// static 제한자 : 클래스(내부클래스), 메서드, 필드에 사용하는 제한자 
//=> 객체가 아닌 클래스로 접근하여 사용하는 제한자. 



//사원정보(사원번호, 이름)를 저장하기 위한 클래스
//=> 모든 사원관련 클래스가 상속받는 부모 클래스
//부모 클래스 : 객체 생성 목적이 아닌 상속 목적으로 만들어진 클래스 -> 추상클래스로 쓰는 것을 권장
//추상클래스 (Abstract Class) : abstract 제한자를 사용하여 선언된 클래스 => 객체 생성 불가
//형식)public abstract class 클래스명 {  }

public abstract class Employee {  //추상 클래스
	private int empNo;
	private String empName;

	//생성자
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}
	

	//getter, setter
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
	
	//일반메서드의 경우, 상속받는 클래스가 오버라이드 선언하지 않을 시, 부모클래스의 메서드가 호출될 뿐, 컴파일에러 발생x (but 비정상 값)
	/*
	 * public int computePay() { return 0; }
	 */
	//무조건 오버라이드 해야만 하는 메서드일 시, 추상 메서드로 제공하면 무조건 오버라이딩 해야함.
	public abstract int computePay();

}
