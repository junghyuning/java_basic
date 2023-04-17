package xyz.itwill.thread;

public class AccountUserApp {
	public static void main(String[] args) {
		//Account 클래스로 객체를 생성하여 저장 - 은행계좌 생성
		Account account = new Account(10000);  //계좌는 하나만 개설했음.
		
		//단일스레드를 이용하여 account user 클래스로 객체 생성 및 저장
		// 은행계좌를 사용하는 사용자를 여러개 생성하여 같은 은행계좌를 사용하도록 설정.
		AccountUser one = new AccountUser(account, "홍길동");
		AccountUser two = new AccountUser(account, "임꺽정");
		AccountUser three = new AccountUser(account, "전우치");
		
		//단일 스레드 - 3인의 입금처리
		
		one.getAccount().deposit(one.getUserName(), 5000); 
		two.getAccount().deposit(two.getUserName(), 5000);
		three.getAccount().deposit(three.getUserName(), 5000);
		
	}
}
