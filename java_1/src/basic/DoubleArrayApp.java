package basic;

public class DoubleArrayApp {
	public static void main(String[] args) {
		int[][] num = new int[2][3];

		System.out.println("num =" + num);
		System.out.println("num[0] = " + num[0]);
		System.out.println("num[1] = " + num[1]);

		System.out.println("============================================================");
		System.out.println("num[0][0] = " + num[0][0]);
		System.out.println("num[0][1] = " + num[0][1]);
		System.out.println("num[0][2] = " + num[0][2]);
		System.out.println("============================================================");
		System.out.println("num[1][0] = " + num[1][0]);
		System.out.println("num[1][1] = " + num[1][1]);
		System.out.println("num[1][2] = " + num[1][2]);
		System.out.println("============================================================");
		System.out.println("num.length = " + num.length);
		System.out.println("num[0].length = " + num[0].length);
		System.out.println("num[1].length = " + num[1].length);
		System.out.println("============================================================");
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				System.out.print(num[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("============================================================");
		int[][] su = new int[][] { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };

		for (int[] arr : su) {
			for (int temp : arr) { // 2차원 배열 무조건 for문 2번 돌아가야 함.
				System.out.print(temp + "\t");
			}
			System.out.println();
		}

		System.out.println("============================================================");
		// 1차원 배열의 요소의 갯수가 정해져있지 않은 2차원 배열 선언
		// => 1차원 배열의 메모리 주소를 저장하는 참조요소만 생성되고, 1차원 배열은 미생성.
		// => 2차원 배열의 참조요소는 null 저장
		int[][] value = new int[3][];
		System.out.println("value =" + value);
		System.out.println("value[0] = " + value[0]);
		System.out.println("value[1] = " + value[1]);
		System.out.println("value[2] = " + value[2]);
		System.out.println("============================================================");
		// 가변배열 : 정사각형 배열이 아님. 열의 갯수가 다름. 
		value[0] = new int[3];
		value[1] = new int[1];
		value[2] = new int[2];
		
		for(int[] arr : value) {
			for(int temp : arr) {
				System.out.print(temp+"\t");
			}
			System.out.println();
		}
		
		// 직접 가변배열 생성하는 법.
		int[][] array = {{10,20,30}, {40,50},{60,70,80,90}};
		for(int[] arr : array) {
			for(int temp : arr) {
				System.out.print(temp+"\t");
			}
			System.out.println();
		}

	}
}
