package oop;

// 클래스로 객체 생성하는 법
// 형식 ) 클래슴명 참조변수 = new 클래스명();
//  => new 연산자로 클래스의 생성자를 호출 -> 객체생성 -> 객체의 메모리 주소를 참조변수에 저장하는 것. 
// => 참조변수에 저장된 객체는 . 연산자를 사용해 필드 or 메서드에 이용해 프로그램 작성함.


public class CarApp_04 {
	public static void main(String[] args) {
		// 객체 생성 - 하나의 클래스로 여러개의 객체 생성 가능.
		// class는 객체를 생성하기위한 틀(Template)
		// 객체 생성시, 객체의 필드에는 기본값(0, false, null)이 저장됨.
		Car_04 carOne = new Car_04();
		Car_04 carTwo = new Car_04();
		Car_04 carThree = new Car_04();
		
		//결과값 모두 다름 => 객체가 동일한 클래스에서 만들어졌다고하더라도 각각이 서로 다른 장소에 각각 존재하고있음을 알 수 있음
		System.out.println("car1 = " + carOne);
		System.out.println("car2 = " + carTwo);
		System.out.println("car3 = " + carThree);
		System.out.println("====================================================================");
//		참조변수.필드명 : 참조변수에 저장된 객체가 . 연산자를 사용하여 필드에 접근
//		멤버변수는 지역변수가 아니므로 객체가 살아있는 한, 사라지지 않음.
//		문제점) 직접 접근 허용시, 필드에 비정상적인 값 저장 가능
//		해결법 : 클래스 선언시, 필드를 은닉화 처리하여 선언 => data hiding (데이터 은닉화) : 값을 숨겨 보호하기 위한 기능
		
		System.out.println("car1의 모델명 : "+carOne.getModelName());  // 필드에 아무값도 저장하지 않았을 시, string의 디폴트 값인 null 출력됨.
		carOne.startEngine();
		
		carOne.speedUp(60);
		carOne.speedDown(20);
		carOne.stopEngine();
		System.out.println();
		
		carTwo.setModelName("2");  // 참조변수를 통해 carTwo 객체의 필드에 접근 -> madelName에 sonata 저장.
		carTwo.getCurrentSpeed(); //연산에 사용되는 변수도 초기값 저장 가능.
		carTwo.startEngine();
		carTwo.speedUp(100);
		carTwo.speedDown(50);
		carTwo.stopEngine();
		System.out.println();
		
		carThree.setModelName("sonata");
		carThree.speedUp(20);
		carThree.startEngine();
		carThree.speedDown(20);
		carThree.stopEngine();
		System.out.println("====================================================================");
		
		
	
	}

}
