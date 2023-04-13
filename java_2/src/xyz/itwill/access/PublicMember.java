package xyz.itwill.access;

//public : 모든 패키지의 클래스에서 접근가능.
//하나의 소스파일 안에는 public class 1개만 존재함
//but 1개의 public class + 다른접근범위의 클래스가 존재하는것 가능.
//public 클래스를 호출하는 다른 패키지의 class도 public 클래스 여야 함.
public class PublicMember {
	public int num;
	public void display() {
		System.out.println("num = " + num);
		
	}
}

