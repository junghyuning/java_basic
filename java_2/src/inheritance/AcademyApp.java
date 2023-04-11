package inheritance;

//모든 java 클래스는 무조건 object 클래스 상속받음
// Object 클래스 : 모든 Java 클래스의 최선조클래스
// 다중상속은 불가하지만, 상속의 상속의 상속 같은 개념은 가능하다(Like Tree구조)
//학원 인적자원(강사, 학생, 직원) 관리 프로그램.  => 각각의 클래스 필요
public class AcademyApp {
	public static void main(String[] args) {
		
		 /* AcademyStudent[] students = new AcademyStudent[300]; // 학생정보를 저장할 수 있는 배열.
		 * AcademyInstructor[] instructors = new AcademyInstructor[50]; // 학생정보를 저장할 수
		 * 있는 배열. AcademyStaff[] staffs = new AcademyStaff[100]; // 학생정보를 저장할 수 있는 배열.*/
		
		 		
		AcademyPerson[] persons = new AcademyPerson[5];  //부모이므로 학생, 선생, 직원의 객체 모두 저장 가능.
		persons[0] = new AcademyStudent(1000, "홍길동", "웹개발자 과정");
		persons[1] = new AcademyInstructor(2000, "임꺽정", "Java 과목");
		persons[2] = new AcademyStaff(3000, "전우치", "운영관리팀");
		persons[3] = new AcademyStudent(4000, "일지매", "웹디자인과정");
		persons[4] = new AcademyStaff(5000, "장길산", "경영회계팀");
		
		for(AcademyPerson p : persons) {
			System.out.println("<<향상된for문>>");
			if (p != null)
			p.display();  // 부모클래스의 메서드를 호출해도 저장된 객체의 오버라이딩된 메서드 호출됨(묵시적 형변환)
			else continue;
			
		}
		
		System.out.println("===============================수정=================================");
		
		persons[0].setName("홍홍");
		AcademyStudent s = (AcademyStudent) persons[0];
		s.setCourse("HTML");
		
		s = (AcademyStudent) persons[3];
		s.setName("이지매");
		s.setCourse("웹프론트과정");

		
		
		for(AcademyPerson p : persons) {
			//오버라이딩 하지 않아 묵시적 형변환이 일어나지 않았지만, 자손객체의 메서드를 사용하고 싶은경우
			//=> "명시적" 객체 형변환을 이용하여 참조변수에 자식클래스의 객체를 일시적으로 저장 -> 자식클래스의 메소드 호출 가능.
			//ex) (AcademyStudent)p.getCourse;  => 문제점 : 상속관계가 아닌 class로 명시적 객체 형변환 시, ClassCastException 예외 발생.
			//ex) (AcademyStudent)p.getDept;
			//=> 해결법 "instanceof" -> 형변환 검증하는 명령어
			System.out.println("<<향상된for문>>");
			if(p instanceof AcademyStudent) {
				System.out.println(((AcademyStudent)p).getCourse()+"의 학생정보 >> ");
			} else if(p instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor)p).getCourse()+"의 강사정보 >>");
			} else if(p instanceof AcademyStaff) {
				System.out.println(((AcademyStaff)p).getDepart()+"의 사원정보 >>");
			}
			p.display();
			
		}
		System.out.println("===============================수정=================================");

		
		
		
	}
}
