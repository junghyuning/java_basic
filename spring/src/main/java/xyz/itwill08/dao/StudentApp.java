package xyz.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("08_dao.xml");
		StudentService service = context.getBean("studentService",StudentService.class);
		System.out.println("=========================================================");
/*		Student newStudent = new Student();
		newStudent.setNo(6002);
		newStudent.setName("홍경래");
		newStudent.setPhone("010-3189-9622");
		newStudent.setAddress("서울시 도봉구");
		newStudent.setBirthday("1995-05-05");
		service.addStudent(newStudent);  */
		
		
		List<Student> studentList = service.getStudentList();
		for(Student student : studentList) {
			System.out.println("학번 = "+student.getNo());
			System.out.println("이름 = "+student.getName());
			System.out.println("번호 = "+student.getPhone());
			System.out.println("주소 = "+student.getAddress());
			System.out.println("생일 = "+student.getBirthday());
		System.out.println("===========================================================");
		}
		((ClassPathXmlApplicationContext)context).close();
	}

}
