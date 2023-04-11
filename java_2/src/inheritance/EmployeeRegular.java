package inheritance;

//정규직 사원관련 class : 번호, 이름, 연봉 저장.
public class EmployeeRegular extends Employee {
	private int annualSalary;

	public EmployeeRegular() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeRegular(int empNo, String empName, int annalSalary) {
		super(empNo, empName);
		this.annualSalary = annalSalary;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annalSalary) {
		this.annualSalary = annalSalary;
	}

	// 급여 반환하는 메서드
	@Override
	public int computePay() {
		return annualSalary/12;
	}

	/*
	//부모클래스의 final 메소드를 오버라이드 선언하여 에러 발생
	 * final은 오버라이딩 불가!
	@Override
	public int computeIncentive() {
		return 100000000;
	}
	*/
	
	

}
