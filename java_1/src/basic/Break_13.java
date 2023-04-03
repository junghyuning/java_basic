package basic;

//break : switch 구문 또는 반복문을 강제로 종료하기 위한 명령
public class Break_13 {
	
	public static void main(String[] args) {
		//기본적으로 조건식의 결과가 거짓인 경우 반복문을 종료
		for(int i=1;i<=5;i++) {
			if(i==3) break; //if구문의 조건이 참인경우 break문을 이용하여 반복문 종료 
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("=======================================================================");
		
		for(int i =1; i<=5; i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) break;  // 해당 반복문 1개만 break; 즉, j 루프 1개만 빠져나가는 것.
				System.out.println("i="+i+", j="+j);
			}
		}
		System.out.println("=======================================================================");

		//이름이 붙은 반복문 -> loop , cycle 등 원하는 이름 붙이면됨(식별자임)
		loop:
		for(int i =1; i<=5; i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) break loop;  // break loop; 즉, loop에 해당되는 반복문을 모두 벗어나는것.
				System.out.println("i="+i+", j="+j);
			}
		}
		
		
	}

}
