package xyz.itwill.util;

import java.util.List;

public class StudentManagerApp {
	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
//		Student s1 = new Student(1,"a");
//		Student s2 = new Student(2,"b");
//		Student s3 = new Student(3,"c");
//		manager.insertStudent(s1);
//		manager.insertStudent(s2);
//		manager.insertStudent(s3);

		manager.insertStudent(new Student(1000, "홍길동"));
		manager.insertStudent(new Student(2000, "임꺽정"));
		manager.insertStudent(new Student(3000, "전우치"));
		manager.insertStudent(new Student(4000, "일지매"));
		manager.insertStudent(new Student(5000, "장길산"));
		System.out.println(manager.selectStudentList());

		if (manager.insertStudent(new Student(5000, "장길산"))) {
			System.out.println("[message] Insert Success");
		} else {
			System.out.println("[message] Insert Fail");
		}
		System.out.println("====================================================================");
		List<Student> studentList = manager.selectStudentList();
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println("====================================================================");
		// 저장매체에 저장된 학생정보 중 학번이 [2000]인 학생정보를 검색하여 반환하는 메소드 호출
		Student searchStudent = manager.selectStudent(2000);
		if (searchStudent != null) {
			System.out.println(searchStudent);
		} else {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}

		System.out.println("====================================================================");
		searchStudent.setName("임걱장");
		if (manager.updateStudent(searchStudent)) {
			System.out.println("[message] Update Success");
		} else {
			System.out.println("[message] Update fail");
		}
		System.out.println("====================================================================");
		if (manager.deleteStudent(4000)) {
			System.out.println("[message] Delete Success");
		} else {
			System.out.println("[message] Delete fail");
		}
		System.out.println("====================================================================");
		List<Student> studentList2 = manager.selectStudentList();

		for (Student student : studentList2) {
			System.out.println(student);// toString() 메소드 자동 호출
		}
	}
}
