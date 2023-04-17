package xyz.itwill.thread;

//은행계좌정보(잔액)을 저장하기 위한 클래스
//=> 입금 및 출력 관련 메서드 작성.
public class Account {
	private int balance;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금처리 메서드
	public synchronized void deposit(String name, int amount ) {
		balance += amount;
		System.out.println("[Notify] "+ name + "님, 입금 : " + amount+", 잔액 : "+ balance );
	}
	
	//출금처리 메서드
	public void withDraw(String name, int amount) {
		if (balance<amount) {
			System.out.println(name+"님의 잔액이"+ balance+"원 남아 출금할 수 없습니다.");
			return;  // return 있어야 break 효과 -> 출금 안됨 
		}
		
		balance -= amount;
		System.out.println("[Notify] "+ name + "님, 출금 : " + amount+", 잔액 : "+ balance );
	
	}
}
