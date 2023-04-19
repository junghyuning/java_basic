package xyz.itwill.util;

import java.util.Random;
import java.util.Scanner;

import javax.naming.LinkLoopException;

//난수값(0~9) 3개 제공받음 : 0으로 시작 불가능
//키보드로 입력받아 맞춤 : 키보드 입력값이 맞지 않는 경우 재입력되도록 작성.
//난수값과 입력값 비교 -> 동일한 정수값이 존재하는 경우 위치가 같으면 strike
//동일 정수값이 존재하지만 다른 위치일 경우 ball 
//strike가 3개면 -> 성공메세지 출력 -> 프로그램 종료 
//실패시, strike & ball의 갯수 출력
//키보드로 정수값을 입력할 수 있는 기회는 15번 제공 -> 기회를 모두 소진한 경우 난수값 출력.

public class BaseballGameApp {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		//난수값 저장 배열
		int[] dap = new int[3]; // 난수값 저장 배열
		while(true) {
			for (int i = 0; i<dap.length;i++) {
				dap[i]=random.nextInt(10);
			}
			if (dap[0] != 0 && dap[0] != dap[1] && dap[1] != dap[2]&& dap[0] != dap[2]) break;  //난수의 형식 검증
		}
		Scanner scanner = new Scanner(System.in);
		int[] num = new int[3];  // 입력받을 배열
		boolean result =false;
		
		//키보드로 정수값 입력받아 비교 기회를 제공하는 반복문(15회)
		for(int cnt=1; cnt<=15; cnt++) {
			int strike =0, ball=0;
			loop:
			while (true) {
				System.out.print(cnt + "번째 입력 >>");
				String input = scanner.nextLine();
				if(input.length()!=3) {
					System.out.print("[error] 3자리의 숫자를 입력해 주세요.");
					continue;
				}
				
				//입력받은 값을 숫자 배열에 저장
				for(int i = 0; i<num.length ; i++) {
					//문자코드 '0'(48) ~'9'(57)
					//int 보다 작은 자료형의 연산은 프로그램이 자동으로 int로 변환하므로 -> char -'0' -> 문자 크기 그대로 int 로변환됨
					num[i] = input.charAt(i)-'0';
					if(num[i]<0||num[i]>9) {
						System.out.print("[error]비정상 값이 입력되었습니다. 3자리 숫자를 입력해 주세요.");
						continue loop;
					}
				}
				
				if (num[0] != 0 && num[0] != num[1] && num[1] != num[2]&& num[0] != num[2]) break;  // 입력받은 값의 형식 검증
				System.out.println("[error] 0으로 시작되거나 중복된 숫자가 존재합니다.");  
			}
			
			//난수값과 입력값을 비교하여 스트라이크와 볼을 구분하여 계산
			// => 난수값이 저장된 배열의 요소값과 입력값이 저장된 배열의 요소값을 교차 비교
			for(int i=0;i<dap.length;i++) {//난수값이 저장된 배열 요소를 처리하기 위한 반복문
				for(int j=0;j<num.length;j++) {//입력값이 저장된 배열 요소를 처리하기 위한 반복문
					if(dap[i] == num[j]) {//요소값이 같은 경우
						if(i == j) {//요소값이 저장된 위치(Index)가 같은 경우
							strike++;//스트라이크 증가
						} else {
							ball++;//볼 증가
						}
					}
				}
			}
			if(strike == 3) {
				result = true;
				System.out.print("[정답!]"+cnt+"번만에 맞췄습니다.");
				break;
			}	
			System.out.println("[결과]"+strike+"스트라이크, " + ball + "볼");
		}
		if(!result) System.out.println("[실패] 정답을 맞추지 못했습니다.");
	}
}
