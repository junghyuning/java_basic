package inheritance;

//직원 : 직원번호, 이름, 부서
public class AcademyStaff extends AcademyPerson {
	private String depart;

	public AcademyStaff() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStaff(int num, String name, String depart) {
		super(num, name);
		this.depart = depart;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	public void display() {
		super.display();
		System.out.println("수강과목 : "+ depart);
	}
}
