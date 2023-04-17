package xyz.itwill.lang;


public class WrapperApp {
	public static void main(String[] args) {
		Integer num1 = 100, num2 = 200;
		Integer num3 = num1 + num2;
		
		
		Integer num = Integer.valueOf("ABC",16); //int num = 0xABC;(16진수화)
		System.out.println("num = " + num);
		System.out.println("===============================================================");
		Integer su = 50;
		
		System.out.println("su(10진수) = " + su);
		System.out.println("su(8진수) = " + Integer.toOctalString(su));
		System.out.println("su(16진수) = " + Integer.toHexString(su));
		System.out.println("su(2진수) = " + Integer.toBinaryString(su));
		System.out.println("-su(2진수) = " + Integer.toBinaryString(-su));
		System.out.println("===============================================================");
		String str1 = "100", str2 = "200";
		System.out.println("합계 = " + str1 + str2);  //문자열의 결함 -> 100200
		System.out.println("===============================================================");
	}
}
