package inheritance;

//계약직사원 : 번호, 이름, 계약급여(1달)
public class EmployeeContract extends Employee {
	private int contractPay;

	public EmployeeContract() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeContract(int empNo, String empName, int contractPay) {
		super(empNo, empName);
		this.contractPay = contractPay;
	}

	public int getContractPay() {
		return contractPay;
	}

	public void setContractPay(int contractPay) {
		this.contractPay = contractPay;
	}

	@Override
	public int computePay() {
		return contractPay;
	}

}
