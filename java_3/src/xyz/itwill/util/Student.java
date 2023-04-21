package xyz.itwill.util;


//VO클래스 : 값저장 목적의 객체를 생성하기 위한 클래스
public class Student {
	private int num;  //학번 : 고유값 -> 중복 불가
	private String name;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override  //오버라이드 하지 않을 시, student 객체의 주소를  문자열로 반환하게 됨.
	public String toString() {
		return "학번 = " + num + ", 이름 = " + name;
	}
	
	@Override // 해시코드 오버라이딩
	public int hashCode() {
		return super.hashCode();
	}
	
}
