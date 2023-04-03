package basic;

public class DataTypeApp_04 {

	public static void main(String[] args) {
		System.out.println("<<정수형(IntegerType)>>");
		System.out.println("정수형(10진수 100) = " + 100); // 리터럴을 출력한것. 100 =! 변수
		// println은 정수값을 무조건 10진수로 변환하여 출력함.
		System.out.println("정수형(8진수 100) = " + 0100); // 0+숫자값 = 8진수 리터럴
		System.out.println("정수형(16진수 100) = " + 0x100); // 0x숫자값 = 16진수 리터럴

		System.out.println("정수형(10진수 100) = " + 100L); // long 타입 리터럴 (정수리터럴 中 1) - 4비이트로 표현 불가한 정수값 표현하기 위함.
		System.out.println("정수형(10진수 100) = " + 2147483648L); // 21억 이상일때 L 써야함.

		// 4Byte로 표현 가능한 정수값 : -2147483648~2147483647
		// => 4Byte로 표현 불가능한 정수값을 사용한 경우 에러 발생
		// System.out.println("정수값 = "+2147483648);
		// 4Byte로 표현 불가능한 정수값은 정수값 뒤에 [L]를 붙여 8Byte의 LongType의 정수값으로 작성하여 사용
		System.out.println("정수값 = " + 2147483648L);

		// 정수값을 표현하기 위한 자료형(키워드) - byte(1Byte), short(2Byte), int(4Byte), long(8Byte)
		byte a1 = 127;// 1Byte : -128~127
		short a2 = 32767;// 2Byte : -32768~32767
		int a3 = 2147483647;// 4Byte : -2147483648~2147483647
		long a4 = 2147483648L;// 8Byte

		System.out.println("a1 = " + a1);
		System.out.println("a2 = " + a2);
		System.out.println("a3 = " + a3);
		System.out.println("a4 = " + a4);

		long a5 = 100;
		System.out.println("a5 =" + a5);
		System.out.println("===============================================================");
		
		System.out.println("<<실수형(DoubleType)>>");
		System.out.println("실수값(4byte) = " + 12.3F);
		System.out.println("실수값(8byte) = " + 12.3);
		// println() 메서드는 실수값이 아주 작거나 큰경우, 지수형태로 변환하여 출력.
		System.out.println("실수값(8byte) = " + 0.000000000123);
		System.out.println("실수값(8byte) = " + 1.23E+10); // 여기서는 우선연산자 없는데 어떻게 수연산부터 가능한지?

		// float: 4byte / double : 8byte
		float b1 = 1.23456789F; // 가수부 표현 크기(정밀도) : 7자리
		double b2 = 1.23456789; // 가수부 표현 크기(정밀도) : 15자리
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);
		System.out.println("===============================================================");

		//문자형 리터럴 : 문자를 ' ' 안에 1개만, 표현 (char) (!= 문자열(" ") 리터럴)
		System.out.println("<<문자형(CharacterType)>>");
		System.out.println("문자값(2Byte) = " + '가');
		System.out.println("문자값(2Byte) = " + 'A');
		System.out.println("문자값(2Byte) = " + '\''); // 회피문자
		System.out.println("문자값(2Byte) = " + '\\'); // 회피문자
		
		//문자값표현 위한 자료형 char
		char c1 = 'A';
		char c2 = 65;  // 유니코드? ASCII코드? 입력한것.
		char c3 = 'a';
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		
		char c4 = 45000;
		System.out.println("c4 = " + c4);
		System.out.println("===============================================================");
		
		//논리형(BooleanType) 리터럴 : false(거짓) 0 , true(참) 1 // 기본적으로 1Byte
		System.out.println("<<논리형(BooleanType)>>");
		System.out.println("논리값(1Byte) = " + false);
		System.out.println("논리값(1Byte) = " + true);
		
		//관계연산자(비교연산자)를 이용한 연산식의 결과값으로 논리형 리터럴 제공
		System.out.println("논리값(1Byte) = " + (20<10));
		System.out.println("논리값(1Byte) = " + (20>10));
		System.out.println("===============================================================");
		
		boolean d1 = false;
		boolean d2 = 20>10;
		System.out.println("d1 = " + d1);
		System.out.println("d1 = " + d2 );
		System.out.println("===============================================================");
		
		//문자열 리터럴★★★★★ "문자"
		System.out.println("<<문자열(StringType)>>");
		System.out.println("문자열 = " + "홍길동");
		System.out.println("문자열 = " + "유관순 열사가 대한독립 만세를 외쳤습니다. "); //문자열 중간에 "" 들어갈 시 에러 발생
		System.out.println("문자열 = " + "유관순 열사가 \"대한독립 만세\"를 외쳤습니다. "); //문자열 중간에 "" 사용하기 위해서는 회피문자 사용해야 함.
		
		//문자열을 표현하기 위한 자료형 : String 클래스
		String name = "임꺽정";  //사실 name은 string class의 객체임.
		System.out.println("이름 = " + name);
		System.out.println("===============================================================");
		
		
		
		

	}

}
