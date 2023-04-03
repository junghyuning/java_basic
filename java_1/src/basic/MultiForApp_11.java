package basic;

public class MultiForApp_11 {

	public static void main(String[] args) {
		int cnt = 0; // 이동 방법의 갯수를 저장하기 위한 변수

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 4; j++) {
				cnt++;
			}
		}
		System.out.println("이동방법의 갯수 = " + cnt);
		System.out.println("=================================================================");

		// ★★★★★★★출력
		for (int i = 1; i <= 9; i++) { // 행
			for (int j = 1; j <= 8; j++) { // 열
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=================================================================");

		for (int i = 1; i <= 9; i++) { // 행
			for (int j = 2; j <= 9; j++) { // 열
				System.out.print(j + "*" + i + "=" + (i * j) + "\t");
			}
			System.out.println();
		}
		System.out.println("=================================================================");

		// ★ 5행 5열 출력
		for (int i = 1; i <= 5; i++) { // 행
			for (int j = 1; j <= 5; j++) { // 열
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=================================================================");

		// 계단형
		for (int i = 1; i <= 5; i++) { // 행
			for (int j = 1; j <= i; j++) { // 열
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=================================================================");

		// 역계단
		for (int i = 1; i <= 5; i++) { // 행
			for (int j = 5; j >= i; j--) { // 열
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=================================================================");
/*☆☆☆☆★
*☆☆☆★★
*☆☆★★★
*☆★★★★
*★★★★★ */

		for (int i = 1; i <= 5; i++) { // 행
			for (int j = 1; j <= (5 - i); j++) { //현재 for문은 실제 배열에 값을 넣는 것이 아니라 단순히 for로 반복문을 돌리는 용도이므로 
				// 흰별을 5-i번 먼저 print
				System.out.print("☆");
			}
			for (int j = 1; j <= i; j++) { //검은별을 i번 print 하여 총 5개의 별을 print하는 구문임. 
				System.out.print("★");
			}
			System.out.println(""); //5개의 별을 print 한 이후 줄을 바꾸어줌
		}
		System.out.println("=================================================================");

		for (int i = 1; i <= 5; i++) { // 행
			for (int j = 1; j <= 5; j++) { // 열
				if (j > 5 - i) //if(i+j<6){System.out.print("☆");}
					System.out.print("★");
				else
					System.out.print("☆");
			}
			System.out.println("");

		}

	}
}
