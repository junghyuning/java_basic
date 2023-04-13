package xyz.itwill.exception;

//예외 : 사용자에 의해 프로그램이 잘못 실행 or 잘못개발 -> 오류발생 = 예외
//예외발생시, 예외발생지점에서 강제종료됨 => 이것을 방지하거나, 종료된 이유를 알기위해 예외처리(ExceptionHandle) 필드 필요
//Java에서는 예외를 처리하기 위해 다양한 예외클래스를 제공
//예외클래스 = 예외관련 정보를 저장하기 위한 클래스
//=> 모든 예외관련 클래스의 부모클래스
//Throwable 클래스 : 프로그램에서 발생되는 모든 오류정보를 저장하기 위한 부모 class => 자식클래스 : Error 클래스, Exception클래스

public class ExceptionHandleApp {
	public static void main(String[] args) {
		int[] array = {10,20,30,40,50};
		
		//배열 요소의 첨자가 사용범위를 벗어난 경우 ArrayIndexOutOfBoundsException 발생
		for(int i=0; i<array.length;i++) {
			System.out.println("array["+i+"]"+ array[i]);
		}
		System.out.println("========================================");
		System.out.println("[메세제]프로그램이 정상적으로 실행 되었습니다.");
	}
}
