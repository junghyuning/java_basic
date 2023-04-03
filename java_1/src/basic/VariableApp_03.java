package basic;

public class VariableApp_03 {

	public static void main(String[] args) {
		int su; // 변수선언(생성)
		su = 100; // (변수 = 저장값) = 입력
		System.out.print("초기값 = ");
		System.out.println(su);

		su = 200;
		System.out.print("변경값 = ");
		System.out.println(su);
		System.out.println("===========================");

		int num = 100;
		System.out.println("num = " + num);
		System.out.println("올해는 " + 2 + 0 + 2 + 3 + "년입니다."); // 문자열과의 결합으로 문자열이 되었으므로 연산의 결과가 수연산이 아니라 단순 문자열의 나열로 나옴.
		System.out.println(2 + 0 + 2 + 3 + "년은 토끼띠해입니다."); // 잘못된결과 -> 실행오류(러닝에러)
		System.out.println("" + 2 + 0 + 2 + 3 + "년은 토끼띠해입니다."); // "" + "2" -> "2" + "0" -> ... -> "2023년은 토끼띠해입니다."
		System.out.println("===========================");

		int num1 = 100, num2 = 200;
		System.out.println("연산결과 = " + num1+num2);
		System.out.println("연산결과 = " + (num1+num2));  // 100+200이 우선 연산됨.
		
		System.out.println("연산결과 = " + num1*num2);	  // *연산이 +연산자보다 우선연산되어 정상값 출력.
		System.out.println("연산결과 = " + (num1*num2));  // ()은 최우선 연산자 속도 높음-> 결과는 같아도 이 방법 사용이 나음 (가독성 이라고도 함.)
		System.out.println("===========================");
		
		int kor = 88, eng =90;
		int total = kor + eng;
		System.out.println("점수 합계 = " + total);  
		System.out.println("===========================");
		
		//변수의 값이 저장되어있지 ㅏㄶ은 상태에서 변수를 사용할 경우 에러 발생.
		//int count;
		//System.out.println("count = " + count);
		
		// 10.0은 int 자료형에 저장할수없는 실수타입이므로 에러 발생. 
		//int count = 10.0;
		//System.out.println("count = " + count);
		
		
		
	}
}
