package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

//키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램 작성.  // Calendar 클래스 활용
public class WantCalendarApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		System.out.println("출력할 연도와 월을 입력하세요.");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		calendar.set(year, month-1 ,1);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		scanner.close();

		System.out.println("	       "+ calendar.get(Calendar.YEAR)+"년 "+(calendar.get(Calendar.MONTH)+1)+"월");

		System.out.println("==============================================");
		System.out.println("    일    월    화    수    목    금    토   ");
		System.out.println("==============================================");
		
		for (int i = 1; i<week; i++ ) {
			System.out.print("      ");
		}
		
		for(int i = 1; i<=calendar.getActualMaximum(Calendar.DAY_OF_MONTH) ;i++) {
			if(i<=9) {
				System.out.print("     "+i);
			} else System.out.print("    "+i);
			if(week%7 == 0) System.out.println();
			week++;
		}
		
	}
}