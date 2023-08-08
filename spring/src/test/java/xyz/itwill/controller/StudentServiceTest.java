package xyz.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Slf4j
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testAddStudent() {
//		Student student = new Student();
//		student.setNo(7000);
//		student.setName("로빈훗");
//		student.setPhone("010-1111-1111");
//		student.setAddress("서울시 도봉구");
//		student.setBirthday("2000-09-10");
		
		//Student 클래스의 StudentBuilder 클래스로 Student 객체를 생성하여 반환받아 생성
		Student student = Student.builder()
				.no(7000)
				.name("로빈훗")
				.phone("010-7841-3454")
				.address("서울시 중랑구")
				.birthday("2000-10-09")
				.build();
		
		studentService.addStudent(student);
	}
	
	@Test
	public void testGetStudentList() {
		List<Student> studentList = studentService.getStudentList();
		
		for(Student student : studentList) {
			log.info(student.toString());
		}
		
	}

}
