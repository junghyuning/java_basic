package xyz.itwill.util;

import java.text.DecimalFormat;

// number <-> String 하는 클래스
//parse : 객체 <- String
//format : 객체 -> String
public class DecimalFormatApp {
	public static void main(String[] args) {
		int money = 10_000_000;
		System.out.println("금액 = "+ money +"원");
		
		
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0");
		System.out.println("");
		
//		저장된 패턴정보로 표현 : [.,0#$] 사용 가능
		System.out.println(decimalFormat.format(money)+"원");
		
//		getInstance() -> 3자리마다 , 삽입
		System.out.println(DecimalFormat.getInstance().format(money)+"원");
		
//		getCurrentyInstance() : 맨 앞에 화폐단위를 붙이고 3자리마다 , 삽입
		System.out.print(DecimalFormat.getCurrencyInstance().format(money));
		
	}
	
}
