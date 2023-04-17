package xyz.itwill.exception;

//예외 : 사용자에 의해 프로그램이 잘못 실행 or 잘못개발 -> 오류발생 = 예외
//예외발생시, 예외발생지점에서 강제종료됨 => 이것을 방지하거나, 종료된 이유를 알기위해 예외처리(ExceptionHandle) 필드 필요
//Java에서는 예외를 처리하기 위해 다양한 예외클래스를 제공
//예외클래스 = 예외관련 정보를 저장하기 위한 클래스
//=> 모든 예외관련 클래스의 부모클래스
//Throwable 클래스 : 프로그램에서 발생되는 모든 오류정보를 저장하기 위한 부모 class => 자식클래스 : Error 클래스, Exception클래스

public class ExceptionHandleApp {
	public static void main(String[] args) {
		int[] array = { 10, 20, 30, 40, 50 };

		// 배열 요소의 첨자가 사용범위를 벗어난 경우 ArrayIndexOutOfBoundsException 발생
		try { // 예외객체 생성
			for (int i = 0; i <= array.length; i++) {
				System.out.println("array[" + i + "]" + array[i]);// 예외발생 - 예외객체 생성 => 해당 catch 블럭으로 이동함.
			}
			System.out.println("[메세제]프로그램이 정상적으로 실행 되었습니다.");
		} catch (ArrayIndexOutOfBoundsException e) { // 예외객체 전달받음 -> 참조변수에 저장
			// TODO: handle exception
			System.out.println("[error] 프로그램에 예기치 못한 오류가 발생되었습니다."); //예외발생시, 실행 -> 고치는것x 알려주는 것.
			System.out.println("[error]"+ e.getMessage());  // 프로그램작성자에게 어떤 문제가 생겼는지 알려줌
			//[error]Index 5 out of bounds for length 5 : index 5가 범위를 벗어난 사실을 알려 줌.
			e.printStackTrace(); //예외발생경로 역추적 : 연결돼있는 여러개의 클래스에서 여러 에러가 발생됐을 경우 역순으로 에러경로를 추척해줌
			e.getStackTrace(); // 보통은 print하지않고 이렇게 역추적 결과를 기록함.
		} finally {
			System.out.println("[message]:예외발생과 상관없이 무조건 실행될 명령. 예외가 없어도 실행됨");
		}
		System.out.println("========================================");
	}
}
