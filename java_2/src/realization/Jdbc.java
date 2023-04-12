package realization;


//학생관리 클래스가 반드시 상속받아야 하는 인터페이스
//
public interface Jdbc {

	void insert();

	void update();

	void delete();

	void select();

}