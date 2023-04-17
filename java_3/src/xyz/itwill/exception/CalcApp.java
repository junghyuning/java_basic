package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;



//키보드로 정수값 2개를 입력받아 첫번째 정수값으로 두번째 정수값을 나눈 몫을 계산하여 출력
public class CalcApp {
	public CalcApp() throws InputMismatchException, ArithmeticException {
//					thorws Exception  => 가능은 하지만, 권장하지 않음... (Exception은 모든 예외들의 부모라 컴파일오류는 발생하지 않음)
		// TODO Auto-generated constructor stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 정수값 >> ");
		//
		int num1 = scanner.nextInt();
		System.out.print("두번째 정수값 >> ");
		int num2 = scanner.nextInt();
//		double num3 = scanner.nextDouble();
		System.out.println("[result]"+num1 + " / " + num2 + " = " +(int)(num1/num2));
		//문제 1 : 0으로 나누었을때 오류 발생 => ArithmeticException: / by zero
		//문제 2 : 정수가 아닌값을 입력했을 때. => InputMismatchException
		
		scanner.close();
	}
	public static void main(String[] args) {
		//new 연산자로 클래스의 생성자를 호출하여 객체 생성 -> 생성자에 작성된 명령 실행.
		//=> 생성자호출 -> 예외 전달 => 예외처리 필요
		try {
			new CalcApp();
		} catch(InputMismatchException | ArithmeticException e) {  // 문법상 어긋나지 않으나 명확하게 어떤 예외인지 알 수 없으므로 아래의 주석처리된 형식 이 더 좋음.
			System.out.println("[error] 형식에 맞는 값을 입력해 주세요.");
		} catch (Exception e) {  //모든 예외를 전달받아 처리하는 예외 => 예기치 못한 예외를 처리해줌 -> 반드시 마지막에 작성해줘야 함.
			System.out.println("[error] 프로그램에 예기치 못한 오류가 발생하였습니다.");
			// TODO: handle exception
		}
		
//		catch (InputMismatchException e) {
//			// TODO: handle exception
//			System.out.println("[error] 정수값만 입력 가능합니다.");
//		} catch (ArithmeticException e) {
//			// TODO: handle exception
//			System.out.println("[error] 0으로 나눌 수 없습니다.");
//		} 
//		
		
		
		
	}
}
