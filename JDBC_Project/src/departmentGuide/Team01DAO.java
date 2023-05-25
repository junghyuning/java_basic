package departmentGuide;

import java.util.List;

//DAO 클래스가 상속받기 위한 인터페이스
//=> 추상메소드를 이용하여 인터페이스를 상속받은 모든 자식클래스(DAO 클래스)가 동일한
//메소드가 선언되도록 메소드의 작성 규칙 제공
//=> 프로그램에서 사용하는 DAO 클래스가 변경돼도 프로그램에 영향을 최소화 하기 위해 인터페이스 선언
public interface Team01DAO {
	
	//중분류의 가게목록을 검색하는 메서드
	List<Team01DTO> selectPstoreList(String product);
	//대분류의 가게목록을 검색하는 메서드
	List<Team01DTO> selectCategoriesList(String categories);

	//모든 점포 정보를 검색하는 메서드
	List<Team01DTO> selectAllStore();

	/**************************************************************************/
	// 카테고리 목록 불러오기
	List<Team01DTO> cList();

	// 카테고리 목록 불러와서 p목록 거르기
	List<Team01DTO> pList(String category);
	
	//상점의 이름을 통해 검색하는 메서드
	List<Team01DTO> searchSNameList(String sName);
	
	List<Team01DTO> pushFButton(String floor);
}