package xyz.itwill.lang;

import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

//키보드로 사칙 연산식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20 + 10 -> 입력받은 숫자를 '20' /'+' /'10' => 각각 피연산자, 연산자, 피연산자로 분류하는것이 중요.(substring)
//  [결과]30
//=> 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)만 허용
//=> 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 종료
//=> 입력 연산식에 공백 입력이 가능하도록 처리
public class ConsoleCalculateApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("연산식 입력 >> ");
		String operation = scanner.nextLine().replace(" ", "");
		scanner.close();
		// 연산식에서 검색할 연산자가 저장된 문자열 배열 선언
		String[] operatorArray = { "*", "/", "+", "-" };

		// 연산식에서 연산식 검색 -> 연산자의 시작위치(Index) 반환 받아 저장
		int index = -1; // 연산자의 시작 위치 저장위한 변수
		for (String operator : operatorArray) {
//			index = operation.indexOf(operator); // 음수계산이 안되는 문자 발생. -50 +20 -> -50을 빼기로 인식함. // 찾을 수 없을 시, -1 반환
			index = operation.lastIndexOf(operator);

			if (index != -1)
				break; // 연산자를 찾으면, 더 이상 반복문을 돌리지 않고 break

		} //for문종료 : 연산자를 찾은경우 or 아예 찾지못해 끝까지 돌아감.
		
		if (index <=0 || index>=operation.length()-1) { // 연산자가 없거나, 맨 앞에있거나, 맨 마지막에 있을 시
			System.out.print("[error] 연산식을 잘못 입력했습니다.");
			System.exit(0); // 시스템 종료
		}
		
		//Integer.parseInt(String str) 메서드 호출 시, NumberFormarException 발생 가능
		try {
			int num1 = Integer.parseInt(operation.substring(0, index));
			String operator = operation.substring(index,index+1);
			int num2 = Integer.parseInt(operation.substring(index+1));
			
			int result = 0;
			switch (operator) {
			case "*" : result = num1*num2; break;
			case "/" : result = num1/num2; break;
			case "+" : result = num1+num2; break;
			case "-" : result = num1-num2; break;
			}
			System.out.print("[결과] >> " + result);
			
		} catch (NumberFormatException e) {
			System.out.println("[error] 연산식에 숫자가 아닌 값이 입력되었습니다.");
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("[error] 0으로 나눌 수 없습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[error] 프로그램에 예기치 못한 오류가 발생하였습니다.");
		}
	
	}
}
