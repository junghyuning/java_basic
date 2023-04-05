package basic;



//가위 바위 보
public class MathRandom_16  {
	public static void main(String[] args) {
		//Math 클래스 : 수학관련 기능 제공
		//Math.random() : 0.0보다 크거나 같고 1.0보다 작은 실수 난수값을 반환하는 메서드
		for(int i=1; i<=5; i++) {
			System.out.println(i+"번째 실수 난수값 = "+Math.random());
		}
		System.out.println("====================================================");
		//0~99 (*100)
		for(int i=1; i<=5; i++) { 
			System.out.println(i+"번째 정수 난수값 = "+(int)(Math.random()*100));
		}
		System.out.println("====================================================");
		//0~45 (*45 +1)
		for(int i=1; i<=5; i++) { 
			System.out.println(i+"번째 정수 난수값 = "+(int)(Math.random()*45+1));
		}
		System.out.println("====================================================");
		
	}
}
