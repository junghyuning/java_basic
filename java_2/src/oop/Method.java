package oop;


//함수(function) : 매개변수로 값을 제공받아 연산(계산)하여 결과를 반환하는 명령의 모임. - 기능 => JavaScript에서 사용
//메소드(Method) : 클래스 내부에 선언된 함수 - 멤버함수 // 매개변수로 값을 제공받지 않아도 ㄱㅊ
//=> 필드(멤버변수)를 이용하여 필요한 기능을 제공하기 위한 명령의 모임

//메소드 선언법
//형식) 자료형(리턴타입) 메소드명(자료형 변수명, 자료형 변수명, ....) {
//					명령1; 명령2; ,,, }
//=> 반환형(ReturnType) : 메서드의 결과값에 대한 자료형
//=> void 자료형(무반환형) : 메소드를 호출하여 얻을 수 있는 결과값이 없는 경우 사용하는 자료형
//메서드의 ()기호에는 변수를 나열하여 선언 이를 매개변수라고 함.
//=> 메서드에 작성된 명령을 실행하기 위해 필요한 값을 메소드 호출시 전달받아 사용하기 위한 변수
//=> 메서드에 작성된 명령을 실행하기위해 값이 필요x 일 시, -> 매개변수도 필요x

//메서드 호출(Method Invoke) : 에서드에 작성된 명령들을 실행하여 필요한 기능을 제공함.
//=> 형식 : 참조변수(객체).메서드명(값, 값)
//메서드 호출시 매개변수에 차례대로 값을 전달하여 메서드 호출
//if 매개변수에 값이 정상적으로 전달되지 않으면 error
//=> 즉, 매개변수의 개수 및 매개변수의 자료형을 일치해야 함. (다를시, 사실상 다른 메서드라고 볼 수 있음)

//return 키워드 : 메소드를 강제로 종료하기 위한 키워드
//형식-1) if(조건식) return;  
//=> 메소드의 반환형을 [void]로 작성
//형식-2) return 반환값;
//=> 메소드를 종료하면서 반환값(변수 또는 연산식)을 메소드를 호출하는 명령에게 제공
//=> 메소드의 반환형을 대상의 자료형과 반드시 같도록 작성

//객체 생성(참조)이 목적인 클래스 - main 메소드 미작성
public class Method {

	void displayOne() {
		System.out.println("Method클래스의 displayOne() 메서드 호출");
	}

	void displayTwo() {
		System.out.println("Method클래스의 displayTwo() 메서드 호출");
	}

	void printOne() {
		int tot = 0;
		for(int i=1; i<=100; i++) {
			tot += i;
		}
		System.out.println("1~100 범위의 정수들의 합계 = "+tot);
	}
	
	void printTwo (int num) {
		//매개변수에 저장된 값에 대한 검증 추가해보기
		if(num<=0) {
			System.out.println("[error] 매개변수에는 0보다 큰값을 전달해야 합니다."); 
			return;  // 메소드 종료.(main 메서드로 돌아가시오)
		}
		int tot = 0;
		for(int i=1;i<=num;i++) {
			tot += i;
		}
		
		System.out.println("1~"+num+"범위의 정수들의 합계 = "+ tot);
	}
	
	void printThree (int begin, int end) {
		int tot = 0;
		if(begin > end) {
			int temp = begin;
			begin = end;
			end = temp;
		}
		
		for(int i=begin;i<=end;i++) {
			tot += i;
		}
		
		System.out.println(begin+ "~"+end+"범위의 정수들의 합계 = "+ tot);
	}
	
	int returnTot(int begin, int end) {
		int tot = 0;
		if(begin > end) {
			int temp = begin;
			begin = end;
			end = temp;
		}
		for(int i=begin;i<=end;i++) {
			tot += i;
		}
		return tot;
	}
	
	//매개변수로 정수값을 전달받아 홀수와 짝수를 구분하여 반환하는 메서드
	//=> false 반환 시, 홀수반환  /  true 반환 시, 짝수 반환.
	
	boolean isOddEven(int num) {
		
		if(num%2 != 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	// 배열을 반환하는 메소드
	int[] returnArray() {
		int[] array = {10,20,30,40,50};
		return array;  // 배열의 메모리주소 반환하는 것. = 배열을 반환하는 것.
		}
	
	// 다른표현법
	int[] returnArray2() {
		return new int[]{10,20,30,40,50};  // 배열의 메모리주소 반환하는 것. = 배열을 반환하는 것.
		}
	
	// 매개변수 3개에 전달된 정수들의 합계를 계산하여 반환하는 메서드
	int sumOne(int a, int b, int c) {
		return a+b+c;
	}
	
	int sumTwo(int[] array) {
		int tot=0;
		for(int num : array) {
			tot += num;
		}
		return tot;
	}
	
	//매개변수로 배열 넣기 귀찮아서 생긴 것.
	int sumThree(int... array) { 
		// ... = 매개변수 생략 기호 => main 메서드에서 호출시, 매개변수를 생략하여 
		// 값을 0개 이상 전달받아 배열처럼 사용 가능. => 가변배열처럼 원하는 만큼 쓸 수있음.
		int tot =0;
		for(int num : array) {
			tot += num;
		}
		return tot;
	}
	
}
