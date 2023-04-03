package basic;

import java.util.Scanner; // 자바 유틸 패키지의 스캐너클래스 멤버를 사용하겠음
// 사용자로부터 키보드로 이름과 나이를 입력받아 화면에 출력하는 프로그램 작성
// System.out : 출력 스트림을 사용하여 값을 화면에 전달하는 기능을 제공하는 객체
// System.in : 키보드로부터 전달된 값을 입력스트림을 이용하여 프로그램에 전달하는 기능을 제공하는 객체
public class ScannerApp {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //import 자동완성 = ctrl+space
		
		System.out.println("이름입력 >>");
		String name = scanner.nextLine();  //입력스트림에 전달된 값을 문자열로 변환하여 반환하는 메서드

		System.out.println("나이 입력>>");
		int age = scanner.nextInt(); // 입력값을 정수값으로 변환하여 반환하는 메서드
		
		System.out.println("[결과]" + name +"님의 나이는"+age+"입니다." );
		
		scanner.close();  // 객체가 사용한 입력 스트림을 제거하는 메소드
		
	}
}
