package realization;  //구현?


//인터페이스(Interface) : 현실에 존재하는 대상을 클래스보다 추상적으로 표현하기 위한 자료형(참조형)
//=> 상수필드(Constant Field)와 추상메서드(Abstract Method)만 선언가능
//=> 정적메서드(Static Method)와 기본메서드(Default Method)도 선언 가능
//형식) [public] interface 인터페이스명 {
// 					(public static final) 자료형 필드명 = 값;  //제한자 생략가능 - 당연하므로
//					.....
//					(public abstract) 반환형 메서드명 (자료형 매개변수, ...); // 생략가능 - 인터페이스의 메서드는 모두 추상메서드 이므로
//			}
//=> 인터페이스는 파스칼 표기법을 사용하여 작성하는 것을 권장

//인터페이스는 클래스가 상속받아 사용하기 위한 자료형 -> 다중상속 가능
//형식) public class 클래스명 implements 인터페이스명, 인터페이스명, ... {}
//ㅇ인터페이스를 상속받은 클래스는 무조건 상속받은 인터페이스의 모든 추상메서드를 오버라이드(의무임)
//ㅇ인터페이스로 객체 생성은 불가능하지만, 참조변수를 생성하여 인터페이스를 상속받은 자식class
//클래스로 객체를 생성하여 저장 가능 - 참조변수에 자식클래스의 메소드 호출(묵시적 객체 형변환)


//인터페이스는 다른 인터페이스를 상속받아 사용 가능 - 다중 상속 가능
//형식) public interface 인터페이스명 extends 인터페이스명, 인터페이스명, ... { }


//인터페이스를 선언하여 클래스가 상속받아 사용하는 이유
//1.클래스의 단일 상속 관련 문제를 일부 보완하기 위해 인터페이스 사용
//ex) public class 늑대인간 extends 인간, 늑대  => 불가능
//  public class 늑대인간 extends 인간 implements 늑대  => 가능
//  public class 흡혈늑대인간 extends 인간 implements 늑대, 흡혈귀  => 가능
//2. 클래스에 대한 작업지시서의 역할을 제공하기 위해 인터페이스 사용 
//ex Tv or Radio or SmartPhone >> 볼륨 증가, 감소, -> 공통기능 인터페이스 사용하여 만듦
//=>인터페이스를 상속받은 모든 자식클래스에 동일한 형태의 메서드가 선언되도록 규칙 제공
//=> 클래스간의 결합도를 낮추어 시스템 변경에 따른 유지 보수에 효율성 증가


public class WolfHumanApp {
	public static void main(String[] args) {
		WolfHuman wolfHuman = new WolfHuman();
		
		wolfHuman.speak();
		wolfHuman.walk();
		wolfHuman.smile();
		wolfHuman.change();
		wolfHuman.fastWalk();
		wolfHuman.cryLoudly();
		System.out.println("=============================================================");
		//부모클래스로 참조변수를 생성 -> 자식클래스의 객체 저장
		//=> 참조변수는 기본적으로 부모클래스의 메소드만 호출 가능함.
		Human human = new WolfHuman();
		human.speak();
		human.walk();
		human.smile();
		
		
		// 객체 형변환시, 자식클래스의 메서드도 호출 가능해짐
		System.out.println("===================명시적 객체형변환=====================");
//		WolfHuman wolfHuman2 = (WolfHuman)human;
//		wolfHuman.change(); // human타입의 참조변수로 wolfhuman의 메서드 사용 가능해짐. but 그렇다고해서 저장된 객체가 아예 바뀌는 것은 아님.
		((WolfHuman)human).change();
		
		//자식 클래스가 같은 부모클래스와 인터페이스는 명시적 객체 형변환을 이용하면 자식클래스의 객체를 공유하여 사용 가능. 
		Wolf  wolf = (Wolf)human;  //Wolf = 인터페이스 / Human = 상속부모class -> 서로 형변환 가능 즉, 같은 자손클래스의 주소 공유 가능
		
		wolf.fastWalk();
		wolf.cryLoudly();
		
	}
}
