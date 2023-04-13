package xyz.itwill.access;


//접근제한자(Access Modifier) : 클래스, 필드, 메소드에 대한 접근 설정을 제한하기 위한 키워드
public class PrivateMember {
	@SuppressWarnings("unused")
	private int num;
	
	@SuppressWarnings("unused")
	private void display() {
		System.out.println("private접근자 입니다.");
	}
	
}
