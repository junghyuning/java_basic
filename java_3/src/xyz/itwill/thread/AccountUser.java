package xyz.itwill.thread;


//은행계좌 사용자정보 (계좌, 사용자명) 저장
public class AccountUser extends Thread{
	private Account account; // account 메서드 호출 가능 = 포함관계
	private String userName;
	
	public AccountUser() {
		// TODO Auto-generated constructor stub
	}

	public AccountUser(Account account, String name) {
		super();
		this.account = account;
		this.userName = name;
	}
		
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void run() {
		//개발자에 의해 생성된 스레드 -> run)메서드를 호출하여 실행할것.
		//=> 은행계좌 사용자가 사용하는 은행계좌에 입금하는 메서드.
//		1. 메서드 전체를 동기화한 경우 
		this.account.deposit(userName, 5000);
		
		
//		2. 메서드 전체를 동기화하지 않고 영역을 임계화 하는 방식.
		synchronized (account) {
			this.account.withDraw(userName, 5000);
		}
		
	}
	
}
