package inheritance;

//시간제 사원 : 번호, 이름, 시급, 시간
public class EmployeePartTime extends Employee {

	private int moneyPerHour, workedHour;
	public EmployeePartTime() {
		// TODO Auto-generated constructor stub
	}

	public EmployeePartTime(int empNo, String empName, int moneyPerHour, int workedHour) {
		super(empNo, empName);
		this.moneyPerHour = moneyPerHour;
		this.workedHour = workedHour;
	}
	public int getMoneyPerHour() {
		return moneyPerHour;
	}
	public void setMoneyPerHour(int moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}
	public int getWorkedHour() {
		return workedHour;
	}
	public void setWorkedHour(int workedHour) {
		this.workedHour = workedHour;
	}
	
	@Override
	public int computePay() {
		return moneyPerHour*workedHour;
	}
}
