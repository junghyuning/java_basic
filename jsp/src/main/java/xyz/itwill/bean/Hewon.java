package xyz.itwill.bean;


//회원정보를 저장하기 위한 JavaBean 클래스 (= VO 클래스)
//Java - VO 클래스
//Web 프로그램 - JavaBean 클래스
//DAO - DTO
public class Hewon {
	private String name;
	private String phone;
	private String address;
	
	public Hewon() {
	}

	public Hewon(String name, String phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
