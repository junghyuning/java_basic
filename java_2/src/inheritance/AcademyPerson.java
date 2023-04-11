package inheritance;


//공통내역 : 번호, 이름
public class AcademyPerson {
	private int num;
	private String name;

	//생성자
	public AcademyPerson() {
		// TODO Auto-generated constructor stub
	}
	
	public AcademyPerson(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	
	//getter, setter
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
	}

}
