package example;

import java.util.Scanner;

//키보드로 정수값을 입력받아 1~9 범위의 정수값을 곱한 결과를 출력하는 프로그램을 작성하세요.
//단,키보드로 입력된 정수값은 2~9 범위의 정수값만 허용하면 범위를 벗어난 정수값을 입력한 경우
//에러 메세지 출력 후 재입력하도록 프로그램 작성
//ex) 단 입력[2~9] >> 7
//    7 * 1 = 7
//    ...
//    7 * 9 = 63
public class GuGuDanExample {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int i;
		while(true) {
			System.out.println("2~9사이의 정수값을 입력하시오.");
			i = scanner.nextInt();
			if(i<=9 && i>=2) break;
			System.out.println("[에러] 잘못입력하셨습니다.");
		}

		for(int j = 1; j<=9; j++) {
			System.out.println(i+"*"+j+"="+(i*j));
		}
		
	}
}




