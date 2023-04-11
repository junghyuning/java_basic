package inheritance;

import java.util.jar.Attributes.Name;

public class CarApp {
	public static void main(String[] args) {
		Car car = new Car("싼타페", "홍길동");

		System.out.println("모델명 =" + car.getModelName());
		System.out.println("소유자 =" + car.getUserName());

		System.out.println("===========================Object.toString()==========================");
		// 참조변수에 저장된 객체를 참조하여 "클래스명@메모리주소"형식의 문자열로 변환하여 변환하는 메서드.

		// Object클래스의 toString()이 아닌 car클래스의 toString() 메서드 자동으로 호출 함.
		System.out.println("car.toString() : " + car.toString());
		System.out.println("car = " + car);  // 결과동일
		System.out.println("===========================string.toString()==========================");
		String name = "홍길동";
		//String 클래스에 오버라이드 선언된 toString()메서드 호출
		//=> String.toString() : String 객체에 저장된 문자열을 반환하는 메서드.
		//String 클래스의 참조변수를 출력할 경우, 자동으로 String 클래스의 toString()메서드 호출.
		System.out.println("name = "+ name.toString());
		System.out.println("name = "+ name);  // 결과 동일
		
		
	}

}
