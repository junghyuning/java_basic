package inheritance;

//강사정보 : 강사번호, 이름, 강의과목
public class AcademyInstructor extends AcademyPerson {
	private String course;

	public AcademyInstructor() {
		// TODO Auto-generated constructor stub
	}

	public AcademyInstructor(int num, String name, String course) {
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
		System.out.println("담당과목 : "+ course);
	}

}
