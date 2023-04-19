package xyz.itwill.util;

import java.util.Date;

public class DateApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println("now = "+ now);
		System.out.println("now.toString() = "+now.toString());
		System.out.println("now = "+now);
		
		
		@SuppressWarnings("unused")
		String[] day = {"일","월","화","수","목","금","토","일"};
		String printDate = (now.getYear()+1900)+"년"+(now.getMonth()+1)+"월"+now.getDate()+"일"+now.getDay()+"요일";
		
		System.out.println("현재 = "+ printDate);
		
		//Date.getTime() : Date 객체에 저장된 날짜와 시간에 대한 타임스템프를 변환하는 메서드
		//타임스템프(TimeStamp) : 1970년 1월 1일 기준으로 1ms마다 증가된 정수 값
		// -> 날짜와 시간을 정수값(long)으로 표현하여 연산 처리하기 위해 사용
//		long currentTime = now.getTime();
		long currentTime = System.currentTimeMillis();
		
		
		//2000년 1월 1일 0시 0분 0초
		Date wantDate = new Date(100,0,1); // 1900년 1월 0일 기준..?
		
		long wantTime = wantDate.getTime();
		
		System.out.println("연산결과(일) = " + (currentTime-wantTime)/1000/86400);//24시간 = 86400초 
		
	}
}
