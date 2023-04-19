package xyz.itwill.util;

import java.util.Random;
import java.util.UUID;

public class NewPasswordApp {
	public static String newPasswordOne() {
		Random random = new Random();
		String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		StringBuffer password = new StringBuffer();
		for(int i =1 ; i<=10; i++)
			password.append(string.charAt(random.nextInt(string.length())));
		return password.toString();  // stringBuffer와 String은 다른 타입이므로 반환타입인 String에 저장하여 반환.
	}
	
	public static void main(String[] args) {
		System.out.println("새로운 비밀번호 #1 = " + newPasswordOne());
		System.out.println("새로운 비밀번호 #2 = " + newPasswordTwo());
		
	}

	private static String newPasswordTwo() {
		// UUID = 범용적으로 사용되는 식별자(고유값)를 생성하기위한 기능을 메서드로 제공하는 클래스
		// OR TimeStamp 사용하는 방식도 있음.
		return UUID.randomUUID().toString().replace("-","").substring(0,10).toUpperCase();
		
	}
}
