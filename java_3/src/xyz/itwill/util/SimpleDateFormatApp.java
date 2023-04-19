package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//java.text 패키지 : 값을 변환하는 기능을 메서드로 제공하기 위한 클래스
//SimpleDateFormat 클래스 : Date와 String 객체를 서로 변환하기 위한 기능을 메서드로 제공

public class SimpleDateFormatApp {
	public static void main(String[] args) {
		Date now = new Date();

		// y/Y=년, M=월(m은 분 - 충돌), d=일, E=요일, AM, PM, h(시:12), H(시: 24시), m, s
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");

		String printDate = dateformat.format(now);

		System.out.println("now Date = " + printDate);
		dateformat.applyPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("now =" + dateformat.format(now));

		String want = "2000-01-01 00:00:00";
		try {
			Date wantDate = dateformat.parse(want); // 패턴정보와 일치하는 문자열을 전달받아 Date객체를 생성하는 메서드
			// parse Exception 발생가능  // dateformat : yyyy-MM-dd HH:mm:ss 인데 wantDate의 형식을 2023년 12월 30일 이런 식으로 입력했을 경우.
			System.out.println("wantDate = " + wantDate);
		} catch (ParseException e) {
			System.out.println("패턴정보와 입력값의 형식일 일치하지 않습니다.");
		} catch (Exception e) {
			System.out.println("예기치못한 오류가 발생하였습니다.");
		}

	}

}
