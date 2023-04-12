package basic;


// java 자료형 : 원시형 + 참조형
// 원시형 : 값을 표현하기 위한 자료형 (8가지): byte short int long char float double boolean
// 참조형 : 배열/ 클래스/ 인터페이스 / 나열형(배열)

//기본형 변수 : 원시형으로 생성된 변수 - 갑저장 목적
//참조형 변수 : 참조형으로 만들어진 변수 - 특정 대상의 메모리 주소값을 저장하기 위한 변수 
// => 힙영역에 생성된 배열 or 객체의 메모리 주소를 저장하여 접근하기 위해 사용
// => 비교연산자를 사용해 비교할 경우 메모리 주소 비교 -> 참조변수를 가지고 값이 같다 같지않다 비교하지 않음
// => 참조변수에 배열 or 객체를 저장하지 않을경우 초기 값으로 null 저장.

// 배열
public class ArrayApp_18 {
	public static void main(String[] args) {
		
		//배열의 요소에는 기본값이 자동 저장 -> 초기화 x 시, -> 숫자형 : 0 / 논리형 : false / 참조형 : null
		int[] num = new int[3];  // index는 "0"부터 시작
		
		System.out.println("System.out.println(num) = "+num);  //결과 : [I@6a5fc7f7  //[ : 배열이라는 뜻, I : integer
		
		System.out.println("System.out.println(num[1]); = " + num[1]); // 값 저장 x -> 0 출력됨.
		
		System.out.println("num.length = " + num.length);
		
		int index = 0;
		num[index]=10; // 첨자에 변수 or 연산식 사용가능
		num[index+1] = 20;
		num[index+2] = 30;
		
		for(int i=0 ; i<(num.length); i++) {
			System.out.println("num["+i+"] = "+ num[i]);
		}
		
		int[] su = new int[] { 10, 20, 30}; // heap 영역에 만들어지는 배열
		int[] su1 = {10, 20, 30}; // 메서드 영역에 만들어지는 배열 -> 정확히는 상수(constant)영역에 만들어짐.
		//su와 su1은 거의 같은 배열을 생성함. 배열이 생성되는 위치만 조금 다른 정도
		for(int i=0 ; i<(su.length); i++) {
			System.out.println("su["+i+"] = "+ su[i]);
		}
		
		//java는 배열을 일괄처리하기 위한 for문 제공
		// for(자료형 변수명 : 참조변수) { //명령문 1,2,3 ...}  // 참조변수에서 더이상 가지고올 값이 없을 때까지 반복됨.
		//참조변수에 저장된 배열의 요소값을 커서(cursur)를 사용하여 차례대로 하나씩 제공받아 변수에 저장하여 일관처리하는 반복문
		//=> 계산, 출력에 대한 일괄처리에 사용

	
		for(int temp : su1) {
			System.out.println(temp +"\t");  // 즉, 해당 구문을 사용하면 temp에 su1[] 저장하게 됨.
		}
		System.out.println("==============================================================================");
		
		
		int[] array = {54, 70, 64, 87, 96, 21, 65, 76, 11, 34, 56, 41, 77, 80};
		//배열의 모든 요소값에 대한 합계를 계산하여 출력하는 프로그램 작성
		
		int tot =0;
		for(int i : array) {
			tot += i;
		}
		System.out.println("합계 : "+tot);
		System.out.println("==============================================================================");
		int count = 0;
		for(int element : array) {
			if(element>=30 && element<=60) {
				count++;
			}
		}
		System.out.println("30~60 범위의 요소 갯수 : "+count);
		System.out.println("==============================================================================");
		
		
		
		
		
	}
}
