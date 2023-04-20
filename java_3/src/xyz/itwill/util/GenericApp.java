package xyz.itwill.util;

public class GenericApp {
	public static void main(String[] args) {
		Generic<Integer> generic1= new Generic<Integer>();
		
		generic1.setField(100);
//		generic1.setField(12.3);//Integer 제네릭타입에 double형 값을 저장 했으므로 error
		
		Integer returnObject1=generic1.getField();
		
		System.out.println("필드값 = " + returnObject1);
		System.out.println("====================================================================");
		
		Generic<Double> generic2 = new Generic<Double>();
		generic2.setField(12.34);
		Double returnObject2 = generic2.getField();
		System.out.println("필드값 = " + returnObject2);
		System.out.println("====================================================================");

//		Generic<String> generic3 = new Generic<>(); // Generic(T extends Number) 이므로 String은 Number의 자손이 아니므로 에러 발생
//		generic3.setField("홍길동");
//		String returnObject3 = generic3.getField();
//		
//		System.out.println("필드값 = " + returnObject3);
		
//		Generic<Boolean> generic3 = new Generic<>();

	}
}
