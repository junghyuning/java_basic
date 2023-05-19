package student;

import java.util.List;

//앞으로 연결에 DAO를 주 연결수단으로 사용할것, -> 중요
//DAO 클래스가 상속받기 위한 인터페이스 
//=> 추상 메서드를 이용하여 인터페이스를 상속받은 모든 자식클래스(DAO클래스)가 동일한 메서드가 선언되도록 메서드의 작성규칙 제공
//=> 프로그램에서 사용하는 DAO 클래스가 변경돼도 프로그램에 영향을 최소화하기 위해 인터페이스
public interface StudentDAO {
	// 단일행 => studentDTO 객체 or 값 반환하면됨
	//1. 학생정보                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
//	int insertStudent(int no, String name, String phone, String address, String birthday);
	int insertStudent(StudentDTO student); // DTO 객체를 사용할 경우 이렇게 간략화 가능
	
	
	//2. 학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메서드
	int updateStudent(StudentDTO student);
	
	//3. 학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메서드
	int deleteStudent(int no);
	
	//4. 학번을 전달 -> STUDENT 테이블에 저장된 학생정보를 검색하여 반환하는 메소드 
	StudentDTO selectStudent(int no);
	
	//다중행 => 무조건 List(or set, map..) 객체 반환.
	//5. 이름 전달 -> 학생정보 검색 및 반환
	List<StudentDTO> selectNameStudentList(String name);
	
	//STUDENT 테이블에 저장된! 모든 학생정보를 검색하여 반환하는
	List<StudentDTO> selectAllStudentList();
}
