package example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
// => 1~100 범위의 정수 난수값을 제공받도록 작성
// => 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
// => 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
// => 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
// => 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
// => 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성
public class UpAndDownExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1. 1~100범위의 정수 난수값을 제공받아 변수에 저장
		int num = (int) (Math.random() * 100 + 1);
		int count = 0;
		boolean quiz = false; // 맞췄을시, true / 못맞췄을 시, false //boolean의 디폴트값은 false
		
		//난수값을 입력받아 맞추는 기회를 10번 제공하기 위한 반복문
		for (int i = 0; i < 10; i++) {
			int u_num; //입력받을 값
			count++;
			while (true) {
				System.out.println(count+"번째 정수값 입력 [1~100]");
				u_num = scanner.nextInt();
				if (u_num >= 1 && u_num <= 100)  //정상적인 값 입력된 경우 반복문 종료 -> while문 벗어남. => if 문으로 이동
					break;
				//else -> 정상 값일 경우 if 문에서 이미 break하므로 굳이 else 쓸 필요 없음
					System.out.println("[에러] 잘못된 값을 입력했습니다.");
					System.out.println();
			}

			if (u_num < num) {
				System.out.println("[up!]");
				System.out.println();
			} else if (u_num > num) {
				System.out.println("[down!]");
				System.out.println();
			} else {
				quiz = true;
				System.out.println();
				break;
			}
		}
		if (quiz) { //if(quiz==true) 와 같음.
			System.out.println("[Success:)] " + count + "번 만에 맞췄습니다.");
		} else {
			System.out.println("[Game Over:(] 정답은 = " + num);
		}
		scanner.close(); //스캐너 종료해주기.

	}
}
