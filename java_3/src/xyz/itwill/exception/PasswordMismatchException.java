package xyz.itwill.exception;

public class PasswordMismatchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 public PasswordMismatchException() {
		// TODO Auto-generated constructor stub
	}
	 public PasswordMismatchException(String msg) {
		 //Exception 클래스에는 예외 메세지 저장하기위한 필드 존재 -> super(message)같이 매개변수있는 생성자를 호출 -> 예외메세지를 Exception class 필드에 저장.
		 super(msg); //부모클래스의 생성자 호출
	 }
	 
}
