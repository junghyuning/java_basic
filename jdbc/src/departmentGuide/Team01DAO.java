package departmentGuide;

import java.util.List;

//DAO 클래스가 상속받기 위한 인터페이스
//=> 추상메소드를 이용하여 인터페이스를 상속받은 모든 자식클래스(DAO 클래스)가 동일한
//메소드가 선언되도록 메소드의 작성 규칙 제공
//=> 프로그램에서 사용하는 DAO 클래스가 변경돼도 프로그램에 영향을 최소화 하기 위해 인터페이스 선언
public interface Team01DAO {
 //학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
 //int insertStudent(StudentDTO student);
 
 //학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
 //int updateStudent(StudentDTO student);
 
 //학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
 //int deleteStudent(int no);
 
 //학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드
 // => 단일행은 값 또는 DTO 객체 반환
 Team01DTO selectStore(String storeName);
 
 //이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환하는 메소드
 // => 다중행은 List 객체 반환

  List<Team01DTO> selectPstoreList(String product);
  List<Team01DTO> selectCategoriesList(String categories);
    
 //STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
 List<Team01DTO> selectAllStore();
 

 
}