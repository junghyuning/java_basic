package basic;



//while문 -> 0~n회 실행
//do-while문 :while문의 변형 -> do를 무조건 1회는 수행하고 조건을 검색함 -> 1~n회 수행
public class WhileApp_12 {
	public static void main(String[] args) {
		
		//5회출력
		int i = 1;
		while(i<=5) {
			System.out.println("java programming");
			i++;
		}
		System.out.println("=========================================================");
		
		
		//1-100범위 정수의 합계
		int j =1, tot=0;
		do {
			tot +=j;
			j++;
		}while(j<=100);
		System.out.println("1~100범위의 정수들의 합계 = "+tot);
		System.out.println("=========================================================");
		
		//A4용지를 반으로 계속 접어 펼쳤을 경우 사격형 모양의 갯수가 500개 이상이 만들어 지려면 몇번 접어야 하나?
		
		int a4 = 1, cnt=0;
		do {
			a4 *= 2;
			cnt++;
	
		}while(a4<500);
		
		System.out.println("A4를 접은 횟수 = "+cnt);
		System.out.println("=========================================================");
		
		//while문 사용하여 해보기
		a4=1;
		cnt=0;
		while(a4<500) {
			a4 *=2;
			cnt++;
		}
		System.out.println("A4를 접은 횟수 = "+cnt);
		System.out.println("=========================================================");

		// 1~x 범위의 정수들의 합계가 300이상이 만들어지려면 x가 얼마인지 계산해서 출력하는 프로그램.
		
		
		int x =0;
		tot =0;
		while(tot<300) {  
			
			tot += ++x; // x++일 경우 total이 이미 300이상인데 x++를 수행하게됨
			
		}
		System.out.println(x);
		
		System.out.println("=========================================================");
		System.out.println("=========================================================");
		
	}
	
}
