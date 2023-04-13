package inheritance;



//사원 급여관리 프로그램
public class EmployeeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Employee e = new Employee(); // Employee는 추상클래스이므로 객체 생성시, error!
		
		Employee employee1 = new EmployeeRegular();
		Employee employee2 = new EmployeePartTime();
//		Employee employee3 = new EmployeeContract();
		
		Employee[] empArray = new Employee[5];  // 배열은 상관x
		
		empArray[0] = new EmployeeRegular(1000, "홍길동", 96000000);
		empArray[1] = new EmployeePartTime(2000, "임꺽정", 50000, 150);
		empArray[2] = new EmployeeContract(3000, "전우치", 7000000);
		empArray[3] = new EmployeePartTime(4000, "일지매", 20000, 100);
		empArray[4] = new EmployeeRegular(5000, "장길산", 60000000);
		
		for(Employee employee : empArray) {
			System.out.println("<<향상for문>>");
			System.out.println("사원번호 = "+ employee.getEmpNo());
			System.out.println("사원이름 = "+ employee.getEmpName());
			//자식클래스에서 부모클래스의 메소드를 오버라이드 선언하면 묵시적 객체 형변환에
			//의해 자동으로 참조변수가 자식클래스로 형변환되어 자식클래스의 메소드 호출 가능
			System.out.println("급여 = " + employee.computePay());
			//사원의 인센티브를 반환받아 출력
			System.out.println("인센티브 = "+employee.computeIncentive());
			/* 아래의 식은, 추상메서드를 활용하지 않고 각각 계산 메서드를 따로 두었을 경우 -> 추상메서드 생성하면 위의 employee.computePay 처럼 간단하게 쓸수 있음.
			 *
			 * //오버라이딩 하지않은 자식클래스의 메서드 사용하고 싶을 시, 형변환 해줘야 함. 
			 * if(employee instanceof EmployeeRegular){
			 *   System.out.println("급여 = " + ((EmployeeRegular)employee).computeSalary()); 
			 *   }else if(employee instanceof EmployeePartTime) {
			 *  System.out.println("급여 = " +
			 * ((EmployeePartTime)employee).computeTimePay());
			 * } else if(employee instanceof EmployeeContract) {
			 *  System.out.println("급여 = " +((EmployeeContract)employee).computeContract());
			 * }
			 */
		}
		
		if(employee1.equals(employee2)) System.out.println(true);
		else System.out.println(false);
		
		System.out.println("==========================================================================");
	}

}
