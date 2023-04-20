package xyz.itwill.util;

import java.util.ArrayList;
import java.util.List;

//학생정보관리 ( 삽입, 삭제, 변경, 검색 - CRUD)
public class StudentManager {
	//다수의 학생 정보를 저장하기 위한 필드
	private List<Student> studentList = new ArrayList<>();
	
	
	//학번의 중복을 거르기 위한 메서드 -> 검사 후, 같은학번의 학생정보가 저장된 index(고유값) 반환
	//같은 학번의 학생정보가 없는 경우 -1 반환.
	private int getStudentIndex(int num) { //학번을 매개변수로 받아야 함.
		int index = -1;
		for(int i =0; i<studentList.size();i++) {
			if(studentList.get(i).getNum()==num) {
				index = i;
				break;
			}
		}
		return index;
	}
	//학생정보를 전달받아 저장매체에 삽입하고 삽입결과를 논리값으로 변환하는 메서드
	public boolean insertStudent(Student student) { //새로운 학생 정보를 받아옴
//		for(Student stu : studentList) {
//			if(stu.getNum() == student.getNum()) // 매개변수로받은 학생 정보가 기존의 studentList의 학번과 중복될 경우 투입 불가함.
//				return false;
//		} //위의 getIndex()로 대체 가능
		//중복검사
		if(getStudentIndex(student.getNum())!=-1) {  // 같은 학번의 학생이 없다면 index가 -1 => 따라서 -1이 아닌것 = 같은 학번의 학생이 있다는 의미
			return false; // return -> break와 비슷한 역할 -> 따라서 if문이 성립되면 false 저장 후 if문 벗어남
		}
		//
		studentList.add(student); // 중복되는 학번이 없을 경우 학생 추가.
		return true;
	}
	
	// 학번을 받아 삭제하고 삭제 성공 여부를 논리값으로 반환하는 메서드
	public boolean deleteStudent(int num) {
		int index = getStudentIndex(num);
		if(index == -1) {
			return false;
		}
		studentList.remove(index);
		return true;
	}
	
	//학생정보를 받아 update 하고 업뎃 성공여부를 논리값으로 반환한느 메서드.
	public boolean updateStudent(Student student) {
		int index = getStudentIndex(student.getNum()); //매개변수로 학번! 
		if(index == -1) { // 중복 학생x
			return false;
		}
		studentList.set(index, student);
		return true;
	}
	
	//검색 - 매개변수 : 학번 -> 학생정보를 검색하여 반환
	public Student selectStudent(int num) {
		int index = getStudentIndex(num);
		if(index == -1) { //중복이 x -> 존재 x
			return null; //반환할것이 x
		}
		return studentList.get(index);
	}
	
	//저장 매체의 모든 학생 정보를 검색하여 반환
	public List<Student> selectStudentList(){  //학생정보 리스트를 반환하는 것이므로 반환값에 List<Student>
		return studentList;
	}
}
