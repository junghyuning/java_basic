package xyz.itwill.util;

import java.util.Calendar;

//현재 년월에 대한 달력을 출력하는 프로그램 작성
public class CurrentCalendarApp {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		//Calendar 객체에 날짜와 시간 중 [n일]을 [1일]로 변경
		cal.set(Calendar.DATE, 1);
		
		int week = cal.get(Calendar.DAY_OF_WEEK); //2023/04/01 -> 요일
		System.out.println(week);  //1=일요일, 2=월요일, 3= 화요일, ... , 7 = 토요일
		
		System.out.println();
		System.out.println("	       "+ cal.get(Calendar.YEAR)+"년 "+cal.get(Calendar.MONTH)+"월");
		System.out.println("==============================================");
		System.out.println("    일    월    화    수    목    금    토   ");
		System.out.println("==============================================");
		
		//1일 출력 전까지 요일을 공백으로 출력
		for(int i=1; i<week ; i++) {
			System.out.print("      ");
		}
		
		//1일 -31일 출력 // 날짜 출력 -> 자릿수맞춤
		for(int i =1 ; i<=31; i++) {
			if(i<=9) {
				System.out.print("     "+i);
			} else {
				System.out.print("    "+i);
			}
			week++;
			if(week%7 ==1) { // 다음 출력값이 일요일인 경우
				System.out.println();
			}
		}
	}
}
