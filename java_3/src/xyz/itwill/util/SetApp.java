package xyz.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Collection Class : 자료구조를 사용해 객체를 효율적으로
//Set -> 저장 순서를 저장하지 않으며, 중복을 허용하지 않는다. => 저장 순서에 의미가 없으므로 동일값은 동일하게 취급하는 것.

public class SetApp {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("홍길동");
		set.add("임꺽정");
		set.add("전우치");
		
		System.out.println("set = "+set);
		System.out.println("===================================================");
		set.add("홍길동"); //string 클래스의 특성상 같은 문자열은 1번만 생성되는 상수와 같으므로 위에 추가한 홍길동과 주소도 같고 
//		애초에 같은 값이면 저장 순서는 관계없으므로 결과적으로 중복 저장되지 않음
		System.out.println("set = "+set); // 위의 출력값과 결과가 같음.
		System.out.println("===================================================");
		Set<Integer> setInt = new HashSet<Integer>(); // 정수일때도 중복허용x
		setInt.add(1);
		setInt.add(1);
		setInt.add(1);
		System.out.print("setInt = "+setInt);
		System.out.println("===================================================");
		
		System.out.println(set.size()); // 저장된 data의 개수
		System.out.println("===================================================");
//		set.remove("임꺽정");
		System.out.println("set = "+set); // 위의 출력값과 결과가 같음.
		System.out.println("===================================================");
		
		//Set에는 순서가 없으므로 안의 내용을 순차적으로 꺼낼 수 있는 방법도 없음 
		//Set의 값을 꺼내기 위해서는 Set객체에 저장된 요소를 반복 처리 가능한 Iterator 객체를 반환하는 
		//Iterator 객체 : 콜렉션 클래스의 객체 요소의 반복 처리를 위한 기능을 제공하는 객체
		//=> 반복 지시자 라고도 부름 : 커서를 사용해 컬렉션 객체의 요소를 반복 처리함.
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String string = iterator.next();
			System.out.print(string+" ");
		}
		System.out.println("");
		System.out.println("====================================================");
		//향상된 for문 사용 
		for(String string : set)
			System.out.print(string+" ");
		System.out.println("");
		System.out.println("====================================================");
	}
}
