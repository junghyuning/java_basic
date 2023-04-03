package basic;


//지역변수(Local Variable) : 특정 구문에서 선언된 변수 - 블럭({}) 내부에서 선언
//선언된 구문에서만 사용 가능 -> 즉, 특정 메서드 내에서 선언된 변수.
//지역변수가 선언된 구문이 종료되면 지역변수 자동 소멸
//멤버변수(인스턴스변수) : class 범위에 선언된 변수
//전역변수 : 특정 영역 바깥에서 만들어진 변수 but java에는 class 밖에서 변수선언 불가하므로 전역변수는 생성할 수 없다.
//캡슐화 : 모든것이 class 단위로 하나의 캡슐로 존재해야 함.
public class LocalVariableApp_09 {

	public static void main(String[] args) {
		int num1 = 100;
		//임의블럭
		{
			int num2 = 200;
			System.out.println("=================임의블럭내부================");
			System.out.println("num1 = " + num1);
			System.out.println("num2 = " + num2);
		}
		System.out.println("num1 = " + num1);
		//지역변수이므로 임의블럭 종료시 자동소멸 -> 즉, num2는 존재x인 값
		// System.out.println("num2 = " + num2); 

	}

}
