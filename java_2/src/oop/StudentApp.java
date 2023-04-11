package oop;

public class StudentApp {
	public static void main(String[] args) {

//		Student student1 = new Student(1000,"홍길동", 90, 90);//초기화 완fy -> 값저장완료
//		Student student2 = new Student(2000,"임꺽정", 94, 98);
//		Student student3 = new Student(3000,"전우치", 91, 80);
//		Student student4 = new Student(4000,"일지매", 76, 82);
//		Student student5 = new Student(5000,"장길산", 84, 86);	

		Student[] student = { new Student(1000, "홍길동", 90, 90), new Student(2000, "임꺽정", 94, 98),
				new Student(3000, "전우치", 91, 80), new Student(4000, "일지매", 76, 82), new Student(5000, "장길산", 84, 86) };

		for (Student student1 : student) { // 새로운 빈 참조변수를 하나 만들어 student 클래스의 메서드를 참조하게하는 방식?
			student1.display();
			//getTotal() + student1.getTot() -> setTotal()을 통해 Total에 저장 => getTotal로 기존 합계 소환 + 다음 학생의 tot값 불러옴. -> setTotal로 이번 합계 Total에 저장.
			Student.setTotal(Student.getTotal()+student1.getTot());  // 클래스변수는 클래스명.클래스변수 			
		}
		
		System.out.println("향상된for문 이용한 총합계 = "+Student.getTotal());
		System.out.print("총합계 = "); // 위처럼 클래스변수 사용하여 표현하는것이 좋음
		int tot = 0;
		for(Student student1 : student) {
			tot += student1.getTot();
		}
		System.out.println(tot);

		System.out.println("===================================================================");
		Student[] students = new Student[5];
		students[0] = new Student(1000, "홍길동", 90, 90);// 초기화 완려 -> 값저장완료
		students[1] = new Student(2000, "임꺽정", 94, 98);
		students [2] = new Student(3000,"전우치", 91, 90);
		students[3] = new Student(4000, "일지매", 76, 82);
		students[4] = new Student(5000, "장길산", 84, 86);

		/*for (int i = 0; i < students.length; i++) { // if 빈 배열이 존재시, student[2] == null -> student[2].display() 호출 불가
													// NullPointException 발생.-> 예외가 발생한 지점에서 프로그램이 종료 됨.
			// if(student[i]!= null) //해결 : null이 아닐때만 실행되도록
			students[i].display();
		}
		*/
		System.out.println("===================================================================");
		
		Student.setTotal(0);
		for (Student student1 : students) { // 새로운 빈 참조변수를 하나 만들어 메서드를 참조하게하는 방식?
			student1.display();
			//getTotal() + student1.getTot() -> setTotal()을 통해 Total에 저장 => getTotal로 기존 합계 소환 + 다음 학생의 tot값 불러옴. -> setTotal로 이번 합계 Total에 저장.
			Student.setTotal(Student.getTotal()+student1.getTot());  // 클래스변수는 클래스명.클래스변수 			
		}
		System.out.println("향상된for문 이용한 총합계 = "+Student.getTotal());
		
	}
}
