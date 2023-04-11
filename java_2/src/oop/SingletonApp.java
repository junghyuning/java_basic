package oop;

public class SingletonApp {
	public static void main(String[] args) {
		
		//생성자 은닉화 -> 아래 코드 실행 불가 (new 연산자로 생성자 호출하여 객체 생성 불가
		//Singleton singleton1 = new Singleton();
		//Singleton singleton2 = new Singleton();
		
		//대신, "정적메서드 호출"하여, 객체를 반환받아 사용할것.
		
		Singleton singleton1 = Singleton.getInstance();  // 생성자가 은닉화 되어있기 때문에 class에 접근해 getter static 메서드를 사용하여 객체를 반환받음.
		Singleton singleton2 = Singleton.getInstance();
		singleton1.display();;
		System.out.println(singleton1);
		singleton2.display();  
		System.out.println(singleton2);// 두 객체의 주소는 같음 => 왜?? 객체 1개밖에 생성 못하므로 같은 객체의 주소를 반환하게됨.
		System.out.println("==========================================================================================================");
		//프로그램 작성시, 변수의 수는 적을 수록 좋음
		//변수 사용의 목적은 값을 잊어버릴까봐임 -> 따라서 하나밖에 존재하지않는 싱글톤은 참조변수를 사용할 필요x
		//따라서 별도의 참조변수 없이 다음과같이 사용하면 됨.
		Singleton.getInstance().display();
		
		
		
	}

}
