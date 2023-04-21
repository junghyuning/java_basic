package xyz.itwill.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//순서 저장x // key: 중복x , value : 중복 가능  
//Key를 통한 검색 속도가 point !!   
//삽입 : put(key,value) // 검색 및 추출 : get(Key) => key의 객체인 value 반환
public class MapApp {
	public static void main(String[] args) {
		
		// Map<key, Value>
		Map<String, String> map = new HashMap<>();
		
		//Map.put(key k,value v>
		map.put("1000","홍길동");
		map.put("2000","임꺽정");
		map.put("3000","전우치");
		map.put("4000","일지매");
		map.put("5000","장길산");
		
		
		System.out.println(map);//=map.toString()
		
		map.put("2000", "임걱정"); //key값이 중복되는 값을 put 할 경우 해당 key의 value을 수정는 방식으로 수행됨
		System.out.println(map);
		map.remove("4000");
		System.out.println(map);
		System.out.println("======================================================");
		String name = map.get("1000"); // Key가 가진 Value객체를 반환하는 것.
		System.out.println(name);
		System.out.println("======================================================");
		Iterator<String> iteratorKey= map.keySet().iterator();//모든 엔트리의 key값만 뽑아서 set객체에 저장하는 것. // 즉, 키값만 읽어올 것.
		while (iteratorKey.hasNext()) {
			String key = iteratorKey.next(); //iterator 통해 키값만 출력가능
			String value = map.get(key); // iterator 통해 저장된 키값을통해 value 검색
			System.out.println(key+"="+value); //key+value 출력
		}
		
		for(String key : map.keySet()) {
			System.out.println(key+"="+map.get(key));
		}
		System.out.println("====================================================");
		
		Iterator<String> iteratorValue = map.values().iterator();  //value값만 읽어옴.
		
		while(iteratorValue.hasNext()) {
			String value = iteratorValue.next();
			System.out.println(value);
		}
		System.out.println("====================================================");
		for(String value : map.values()) {
			System.out.println(value);
		}
		
	}
}
