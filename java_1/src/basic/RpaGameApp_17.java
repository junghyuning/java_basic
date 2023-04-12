package basic;

import java.util.Scanner;

//가위바위보
//컴 : 난수값 vs 사용자 : 키보드 입력값
//사용자가 이길경우 대결 반복실행 -> 질경우 대결 종료
//대결 종료 후 사용자 승리 횟수 출력

public class RpaGameApp_17 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		while (true) {
			int com, user;
			com = (int) (Math.random() * 3 + 1);
			while (true) {
				System.out.print("[가위 =1], [바위 =2], [보 =3]을 입력하세요. ");
				user = scanner.nextInt();
				if (user >= 1 && user <= 3)
					break;
				else {
					System.out.println("[에러]잘못입력하셨습니다.");
				}

			}
			System.out.print("computer : ");
			switch (com) {
			case 1:
				System.out.print("가위");
				break;
			case 2:
				System.out.print("바위");
				break;
			case 3:
				System.out.print("보");
				break;
			}
			System.out.print("/ user : ");
			switch (user) {
			case 1:
				System.out.println("가위");
				break;
			case 2:
				System.out.println("바위");
				break;
			case 3:
				System.out.println("보");
				break;
			}
			// 승부판별
			if (com == user) {
				System.out.println("비겼습니다.");
			} else if ((com == 1 && user == 2) || (com == 2 && user == 3) || (com == 3 && user == 1)) {
				count ++;
				System.out.println("사용자가 이겼습니다.");
			} else {
				System.out.println("사용자가 졌습니다."); 
				break;
			}

		}
		if(count == 0) {
			System.out.println("[메세지] 사용자가 컴퓨터에게 한번도 이기지 못했습니다.");
		}
		else System.out.println("[메세지] 사용자가 컴퓨터에게 "+count+"번 이겼습니다.");
		scanner.close();
	}
}
