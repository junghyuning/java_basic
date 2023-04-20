package xyz.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListApp {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//List.add : 추가
		list.add("홍길동");
		list.add("임꺽정");
		list.add("전우치");
		list.add("일지매");
		
		//List.toString() : 문자열반환
		//System.out.println("list.toString = "+ list.toString );
		System.out.println("list = "+ list);
		System.out.println("=====================================================");
		//중복저장 가능 -> 순서가 있으니까
		list.add("임꺽정");
		System.out.println("list = "+ list);
		System.out.println("=====================================================");
//		단점 : 검색속도 저하.
		System.out.println(list.size());
		System.out.println("=====================================================");
		System.out.println(list.get(3));
		System.out.println("=====================================================");
		list.remove("임꺽정");  //앞에 있는 것 부터 작세 (FIFO)
		System.out.println(list);
		System.out.println("=====================================================");
		for(int i=0; i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		//Iterator 활용
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		//more 간단화 - iterator 필요x
		for(String string : list) {
			System.out.print(string+" ");
		}
		System.out.println();
		System.out.println("=====================================================");
		//Collections.sort(List list) : 매개변수로 전달받은 List 객체의 요소를 정렬하는 메서드
		Collections.sort(list);  // 리스트 정렬
		System.out.println(list);
		System.out.println("=====================================================");
		list.clear();
		System.out.println(list.isEmpty());
		System.out.println("=====================================================");
		List<Integer> numberList = Arrays.asList(10,20,30,40,50);
		System.out.println(numberList);
		System.out.println("=====================================================");
		
	
	}
}
