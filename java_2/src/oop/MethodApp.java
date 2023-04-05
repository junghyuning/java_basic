package oop;

import java.util.Scanner;

//실행이 목적인 클래스 - main 메서드 반드시 있어야함.
public class MethodApp {
	//프로그램 시작시, JVM이 자동 호출하는 메서드 -> 메인으로 실행되는 메서드 다른 메서드들을 main으로 참조해와 실행시키는 역할.
	public static void main(String[] args) {

		// new Method()를 통해 Method 객체를 생성 -> 그 주소를 Method 타입의 참조변수 method에 저장
		//=> 다른패키지에 있는 메서드의 경우 package를 작성해줘야 함.
		
		Method method = new Method();  
		System.out.println("method = " + method); // method는 참조변수이므로 출력시, 주소가 출력됨.
		System.out.println("==============================================================================================");
		
		
		//method통해 Method클래스 호출
		method.displayOne();  // 호출시, 해당 메서드로 이동하여 명령 실행 -> 돌아와 그 다음 명령 수행.
		method.displayOne();  // 호출시, 해당 메서드로 이동하여 명령 실행 -> 돌아와 그 다음 명령 수행.
		method.displayTwo();  // 호출시, 해당 메서드로 이동하여 명령 실행 -> 돌아와 그 다음 명령 수행.
		
		System.out.println("==============================================================================================");
		
		method.printOne();
		System.out.println("==============================================================================================");
		
		System.out.print("1~x까지의 정수의 합계를 구하려고 합니다. x의 값을 입력하시오.");
	
		method.printTwo(100);
		System.out.println("==============================================================================================");
		System.out.println("a~b까지의 정수의 합계를 구하려고 합니다.a와 b의 값을 입력하시오.");

		method.printThree(10,30);
		
		//메서드의 반환값을 지속적으로 사용하고자 할경우 반환값을 변수에 저장.
		// 지속적으로 사용하지 않아도될경우 변수에 저장x (필요없는 변수는 메모리 낭비임)
		int result = method.returnTot(10,30);
		System.out.println(result);
		
		System.out.println(method.returnTot(10,30));
		
		
		System.out.print(10+" = ");
		if (method.isOddEven(10)) System.out.print("짝수");
		else System.out.print("홀수");
		System.out.println();
		System.out.println("==============================================================================================");

		//배열의 메모리 주소를 반환하는 메소드를 호출하여 메모리주소를 참조변수에 저장
		//=> 참조변수에 저장된 메모리 주소를 사용하여 배열 참조 가능
		int[] array = method.returnArray();
		for(int num: array) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("==============================================================================================");
		
		System.out.println("합계 = " + method.sumOne(10, 20, 30));
		
		System.out.println("합계 = " + method.sumTwo(new int[]{10,20,30}));
		System.out.println("합계 = " + method.sumThree(10, 20, 30, 40, 50));
		System.out.println("==============================================================================================");

		
		
		
		
	}
}
