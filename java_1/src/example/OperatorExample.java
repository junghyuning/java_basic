package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int sec = 245678;
		int min = sec/60;
		int hour = min/60;
		int day = hour/24;
		sec %= 60;
		min %= 60;
		hour %= 24;
		System.out.println("245678초 = "+day+"일"+hour+"시간"+min+"분"+sec+"초");
		
		
		 //선생님 코드
		int cho = 245678;
		int day1 = cho/(24*60*60); // 1일 = 86400초 
		cho%=86400;
		int hour1 = cho/(60*60); // 1시간 = 3600
		cho%=3600;
		int min1 = cho/60;
		cho %= 60;
		System.out.println("245678초 = "+day1+"일"+hour1+"시간"+min1+"분"+cho+"초");
		

		System.out.println("===============================================");
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요. -> 15대 미만일경우 할인x
		int plain = 150_000_000, purchase = 20;
		long total = (long)(purchase >= 15 ? plain*0.75 : plain)*purchase;
		System.out.println("총 지불 금액 = "+ total + "원");
		System.out.println("===============================================");
	}
}