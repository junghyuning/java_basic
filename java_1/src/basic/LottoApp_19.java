package basic;

//1~45 범위의 정수형 난수를 6개 제공받아 출력하는 프로그램 작성
//=> 난수 중복될 수 있음
//=> 6개의 난수값은 서로 중복 되지 않도록 작성. 
//=> 오름차순 정렬하여 출력 (sort) : 
//=> 정렬 : 값을 차례대로 나열하는 기능 (오름차순:asc / 내림차순:desc)

public class LottoApp_19 {
	public static void main(String[] args) {
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			// 새로운 난수값이 기존의 모든 난수값과 다른 경우 반복문 종료
			while(true) {  
				lotto[i] = (int) (Math.random() * 45 + 1);
				
				//중복상태를 저장하기위한 변수 false : 미중복 / true : 중복
				boolean result = false; 
				
				for(int j=0 ; j<i; j++) {
					if(lotto[i]==lotto[j]) {  // 기존 요소에 저장된 난수값을 표현하기 위한 반복문
						result = true;
						break;  // for문을 벗어나 다시 while문을 돌리게 됨. -> 해당 i에 대한 while문을 다시수행 => lotto[i]값을 다시 받게 됨.
						//break문 수행시, for문의 어디로 되돌아가는지?
					}
				}
				if(!result) break; //if의 조건문이 true 일때 실행 -> 즉, !result == true 일때 result == false => 일때, break문 실행.
			}
		}
		
		
		// 배열의 값을 비교하여 오름차순 정렬 -> 선택 정렬 알고리즘
		for(int i=0;i<=lotto.length;i++) {
			for(int j=i+1;j<lotto.length;j++) { // 피 비교 요소의 첨자를 표현하는 반복문 : 비교 +1 ~ 끝까지
				if(lotto[i]>=lotto[j]) { //비교하는 값이 더 클경우 요소의 값을 서로 바꾸어 저장
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		

		
		// 출력
		System.out.print("행운의 숫자 >> ");
		for (int number : lotto) {
			System.out.print(number +" ");
		}
	}

}
