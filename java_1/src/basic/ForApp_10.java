package basic;

//for : 조건에 의해 명령을 반복 실행

public class ForApp_10 {

	public static void main(String[] args) {
		//"Java Programming"을 화면에 출력
		System.out.println("Java Programming");
		for(int i=1; i<=5 ; i++) { //i++는 단항연산자이기때문에 ++i여도 상관x
			System.out.print(i);	//실행순서 조건식만족 -> 명령어 수행 -> 증감연산 따라서 증감연산자가 선수행인지 후수행인지 노상관임
		}
		
		System.out.println("");
		for(int i=5; i>=1 ; i--) {
			System.out.print(i);			
		}
		System.out.println("");
		
		for(int i=1; i<=10 ; i+=2) { //2씩 증가시킬수도 있음.
			System.out.print(i);			
		}
		System.out.println("");
		
		for(int i=1; i<=5 ; i++) { //i++는 단항연산자이기때문에 ++i여도 상관x
			System.out.print(i+"\t");	//실행순서 조건식만족 -> 명령어 수행 -> 증감연산 따라서 증감연산자가 선수행인지 후수행인지 노상관임
		}
		
		System.out.println("");
		//짝수출력예제
		for(int i=2; i<=10; i+=2) {
			System.out.print(i+"\t");	
		}
		
		System.out.println("");
		
		for(int i=1; i<=10 ; i++) { 
			if(i%2 == 0)
			System.out.print(i+"\t");			
		}
		System.out.println("");
		
		//1-100범위 정수 합계
		int tot = 0 ;
		
		for(int i=1;i<=100;i++) {
			tot += i; // tot = tot +i
		}
		System.out.println(tot);
		System.out.println("");

		//시작 값이 종료값보다 큰경우 두 변수에 저장된 값을 서로 바꾸어 저장
		//변수에 저장된 정수들의 범위 합계를 계산하여 출력
		int begin =80, end=20;
		if(begin>end) {
			int temp = begin;
			begin = end;
			end = temp;
		}
		int sum = 0;
		for(int i=begin; i<end; i++) {
			sum+=i;
		}
		System.out.println(begin+"~"+end+"범위의 정수들의 합계 ="+sum);
		System.out.println("");
		
		
		//초기식 생략 (이미 인스턴스 변수가 존재하는 경우)
		int i = 1;
		for(;i<=4;++i) {  //세미콜론은 써줘야함.
			System.out.print(i+"\t");
		}
		System.out.println("");
		for(;i>=1;i--) {  //위 for문 수행결과 -> i=5 
			System.out.print(i+"\t");
		}
		
		//for(;;){}  -> 초기식, 조건식, 증감식이 모두 생략된 무한루프의 for문
		

		
	}

}

