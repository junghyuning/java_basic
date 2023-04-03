package basic;

//Continue : 반복문 안에서만 사용하는 제어문 -> 반복문을 처음부터 다시 실행하기 위해 사용하는 제어문
// continue 명령 하단의 명령을 수행하지 않고 처음부터 다시 실행 ( 주로 명령을 건너뛰고싶을때 사용함)

public class Continue_14 {
	public static void main(String[] args) {
		
		for(int i=1; i<=5; i++) {
			if(i==3) continue;  // i==3일때 print명령은 수행되지 않고 반복문 다시 실행 -> 1,2, ,4, 5 가 실행됨 (3 print를 생략)
			System.out.print(i+"\t");
		}
		System.out.println("");
		System.out.println("==========================================================");
		//다중for문의 continue
		for(int i =1; i<=5; i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) continue;  // j 반복문에서 수행됨 -> j=3을 건너뜀.
				System.out.println("i="+i+", j="+j);
			}
		}
		System.out.println("==========================================================");
		//loop - continue
		loop:
			for(int i =1; i<=5; i++) {
				for(int j=1;j<=5;j++) {
					if(j==3) continue loop;  // continue loop; 즉, loop으로 돌아가주세요 -> break와 거의 유사함. 
											// j==3일때, loop으로 되돌아가 for(int i =1; i<=5; i++) 부터 수행되게 됨. 결과적으로 j== 4/5는 수행되지 않음.
					System.out.println("i="+i+", j="+j);
				}
			}
		
		System.out.println("==========================================================");
	}
}
