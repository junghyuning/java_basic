package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PasswordMatchApp {
	public static void main(String args[]) {
//		int password = 123456;
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("비밀번호 입력 >> ");
//		int key = scanner.nextInt();
//		
//		if(key == password)
//			System.out.println("비밀번호가 맞습니다.");
//		else System.out.println("비밀번호가 맞지않습니다.");
//		
//		//문제 1 : 정수값이 아닌 값 입력
//		scanner.close();

		// 다른방식
		int password = 123456;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("비밀번호 입력 >> ");
			int key = scanner.nextInt();

			if (key != password) { // 비밀번호가 틀렸을시, 프로그램을 종료시키기 위해 예외를 의도적으로 발생시켜보자
//				throw new Exception();//이것에 대한 예외 처리를 하지 않으면 심각한 예외 -> catch문으로 예외 처리 해주기 => but 이것 대신 사용자정의 예외 클래스 작성도 가능함.
				throw new PasswordMismatchException("[결과] 입력된 비밀번호가 틀립니다."); // 사용자정의 예외처리
				//=> 사용자정의 예외도 예외처리 하지 않을시 에러 발생함.
			}
			System.out.println("[결과] 입력된 비밀번호가 맞습니다.");
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력 가능합니다.");
		} catch(PasswordMismatchException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("[error]예기치못한 오류가 발생되었습니다.");
		} finally {  //예외가 발생해도 무조건 실행되는 블럭이므로 scanner.close() 처럼 무조건 실행돼야하는 명령은 여기에 넣음.
			scanner.close();
		}

		// 문제 1 : 정수값이 아닌 값 입력

	}
}
