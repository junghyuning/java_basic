package xyz.itwill.thread;

public class AccountUserAppMultiThread {
	public static void main(String[] args) {
		Account account = new Account(10000);
		new AccountUser(account, "홍길동").start();
		new AccountUser(account, "전우치").start();		
		new AccountUser(account, "임꺽정").start();
	}
}
