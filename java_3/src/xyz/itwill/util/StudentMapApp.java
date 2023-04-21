package xyz.itwill.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapApp {
	public static void main(String[] args) {
		List<Student> studentListOne = new ArrayList<>();
		studentListOne.add(new Student(1000,"홍길동"));
		studentListOne.add(new Student(2000,"임꺽정"));
		studentListOne.add(new Student(3000,"전우치"));
		studentListOne.add(new Student(4000,"일지매"));
		studentListOne.add(new Student(5000,"장길산"));
		
		List<Student> studentListTwo = new ArrayList<>();
		studentListTwo.add(new Student(6000,"유재석"));
		studentListTwo.add(new Student(7000,"강호동"));
		studentListTwo.add(new Student(8000,"신동엽"));
		studentListTwo.add(new Student(9000,"김용만"));
		
		Map<Integer, List<Student>> studentListMap =new HashMap<>();  //Map의 value 값으로 List 객체를 저장하는 것. (key값은 Integer로 해당 클래스에서는 반을 넣음)
		
		studentListMap.put(1, studentListOne);
		studentListMap.put(2, studentListTwo);
		
		for(Integer ban : studentListMap.keySet()) { //sutentListMap의 키값을 ban에 저장함 
			System.out.println("반의 학생정보 >> ");
			List<Student> studentList = studentListMap.get(ban);  // studentListMap의 키값이 ban인 value(즉, List<Student>의 객체)를 반환하여 studentList에 저장
			for(Student student : studentList) { //studentList의 값을 향상된 for문을 통해 출력.
				System.out.println(student);
			}
			System.out.println();
		}
	}
}
