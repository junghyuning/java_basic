package xyz.itwill.app;


import java.util.Scanner;
import java.util.Date;

//키보드로 이름과 태어난 년도를 입력받아 나이를 계산하여 이름과 나이를 출력하는 프로그램 작성
//ex) 이름 >> 홍길동
//	연도 >> 2000
//	[결과] 홍길동님의 나이는 >> 24
public class CalcAgeApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 입력 >> ");
		String name = scanner.nextLine();
		
		System.out.print("태어난 연도 >>");
		int birthYear = scanner.nextInt();
		
		Date now = new Date(); //java.util클래스 //현재의 날짜 및 시간정보 저장돼있음.
		
		
		//@suppressWarning 어노테이션 : 경고 제거
		//=> value 속성을 사용하여 경고관련 속성값을 설정함.
		@SuppressWarnings("deprecation")
		int currentYear = now.getYear() + 1900; //1900년 기준으로 1년에 1씩 증가된 정수값으로 반환.
		
		System.out.print("나이 >> ");
		int age =  currentYear - birthYear+1;
	
		System.out.println("[결과]"+ name + "님의 나이는 " + age + "살입니다.");
		
		scanner.close();
		
	}
}
