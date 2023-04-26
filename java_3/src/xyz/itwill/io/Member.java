package xyz.itwill.io;

import java.io.Serializable;

public class Member implements Serializable{
	//객체 직렬화 클래스는 클래스를 구분하기 위한 고유값을 저장할 serialVersionUID 필드 선언 
	private static final long serialVersionUID = -3306639107947980039L;
	
	
	private String id;
	private String name;
	private String phone;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "아이디 = "+id+", 이름 = "+name+", 전화번호 = "+phone;
	}
}
