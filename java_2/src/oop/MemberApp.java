package oop;


public class MemberApp {
	public static void main(String[] args) {
		
		Member member1 = new Member();
		//초기화 x 시, 디폴트값이 초기값으로 자동 저장
		System.out.println("ID : " + member1.getId());
		System.out.println("NAME : " + member1.getName());
		System.out.println("E-mail : " + member1.getEmail());
		System.out.println("=================================================================================");
		
		//setter메서드 이용 -> 값 변경
		member1.setId("abc123");
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz");
		//변한 결과 확인
		System.out.println("ID : " + member1.getId());
		System.out.println("NAME : " + member1.getName());
		System.out.println("E-mail : " + member1.getEmail());
		System.out.println("=================================================================================");
		member1.display();
		System.out.println("=================================================================================");
		
		Member member2 = new Member("xyz258", "임꺽정", "xyz258@itwill.xyz");  //매개변수 값이 필요한 생성자
		member2.display();
		
	}
}
