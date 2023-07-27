package xyz.itwill05.di;

import java.util.List;

//DAO클래스 : 저장매체(File, DBMS 등)에 행에 대한 삽입, 변경, 삭제, 검색 기능을 제공하는 클래스
//=> 저장매체의 종류 or 방법에따라 DAO 클래스는 변경 가능
public class StudentJdbcDAO implements StudentDAO {
	
	public StudentJdbcDAO() {
		System.out.println("#### StudentJdbcDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("#### StudentJdbcDAO 클래스의 insertStudent() 호출 ###");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("#### StudentJdbcDAO 클래스의 updateStudent() 호출 ###");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("#### StudentJdbcDAO 클래스의 deleteStudent() 호출 ###");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("#### StudentJdbcDAO 클래스의 selectStudent() 호출 ###");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("#### StudentJdbcDAO 클래스의 selectStudentList() 호출 ###");
		return null;
	}
	
}
