package xyz.itwill.exception;

public class ExceptionThrowsApp {  //예외를 직접 처리하지 않고 메서드를 호출한 명령으로 예외를 전가할수있음. => 해당명령은 명령을 호출한 jvm에게 전가할수도 있음.
								//웬만하면 main 이전범위에서 예외 처리해주는것이 좋음(정확히 말하면 호출한 명령에서는 처리해주는것이 바람직함)
//형식) 접근제환자 반환형 메서드명(자료형 매개변수,...) throws 예외클래스1,2,3, ...{}
	public static void display() throws ArrayIndexOutOfBoundsException {  //배열 범위 예외를 전가하겠음
		
		int[] array = {10,20,30,40,50};
		
		for(int i=0;i<=array.length;i++) {
			System.out.println("array["+i+"} = "+array[i]);
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			ExceptionThrowsApp.display(); // 정적메서드 -> 클래스로 호출
//			display(); //같은 클래스의 정적메서드는 클래스 표현없이 그냥 메서드명으로 호출가능.
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
	}
}
