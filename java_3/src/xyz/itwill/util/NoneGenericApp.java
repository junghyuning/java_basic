package xyz.itwill.util;

public class NoneGenericApp {
	public static void main(String[] args) {
		NoneGeneric noneGeneric1= new NoneGeneric();
		
		noneGeneric1.setField(100);  // 오토박싱 일어남 => (정수값 -> INTEGER 객체)로
		
		Integer returnObject1= (Integer)noneGeneric1.getField();
		
		System.out.println("field 값 = "+ returnObject1);
		System.out.println("==============================================================");
		NoneGeneric noneGeneric2 = new NoneGeneric();
		noneGeneric2.setField(12.34); // 오토박생 : 실수값 >> Double객체
		//Double객체를 object 클래스의 매개변수로 전달받아 필드값으로 변경
		if(noneGeneric2.getField() instanceof Double) { // 형변환 가능한지 검증 - instanceof (만일 잘못 형변환 시, ClassCastException발생 가능성 있음)
			Double returnObject2 = (Double)noneGeneric2.getField();
			System.out.println("field 값 = "+returnObject2);	
		}
		System.out.println("==============================================================");
		NoneGeneric noneGeneric3 = new NoneGeneric();
		
		noneGeneric3.setField("홍길동");//오토박싱 -> String
		System.out.println("field 값 = "+ noneGeneric3.getField());
		
		
	}
}
