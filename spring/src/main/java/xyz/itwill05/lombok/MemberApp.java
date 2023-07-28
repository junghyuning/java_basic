package xyz.itwill05.lombok;

public class MemberApp {
	public static void main(String[] args) {
		Member member1 = new Member("abc123", "홍길동", "abc@itwill.xyz");
		
		System.out.println("아이디 = " + member1.getId());
		System.out.println("이름 = " + member1.getName());
		System.out.println("이메일 = " + member1.getEmail());
		System.out.println("===========================================");
		//Member 클래스로 생성된 참조변수를 출력할 경우 Member 클래스의 toString() 메서드 자동 호출
		System.out.println(member1);
		System.out.println("===========================================");
		Member member2 = Member.builder()
				.id("xyz789")
				.name("임꺽정")
				.email("xyz@itwill.xyz").build();
	}
}
