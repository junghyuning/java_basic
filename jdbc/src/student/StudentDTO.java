package student;

//student 테이블에 저장된 하나의 행(학생정보)을 저장하여 전달하기위한 클래스
public class StudentDTO {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;

	//[Ctrl]+[Space] >> Constructor 선택
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	//[Alt]+[Shift]+[S] >> 팝업메뉴 >> [O] >> 필드 선택 >> Generate
	public StudentDTO(int no, String name, String phone, String address, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	//[Alt]+[Shift]+[S] >> 팝업메뉴 >> [R] >> 필드 선택 >> Generate
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return no+"\t"+name+"\t"+phone+"\t"+address+"\t"+birthday;
	}
}