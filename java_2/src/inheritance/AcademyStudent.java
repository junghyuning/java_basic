package inheritance;


// 학생정보(학생번호, 이름, 수강과목) 저장하기위한 클래스
public class AcademyStudent extends AcademyPerson{
	
	private String course;
	
	public AcademyStudent() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStudent(int num, String name, String course) {
		super(num, name);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public void display() {
		super.display();
		System.out.println("수강과목 : "+ course);
	}
	
	
	
}
