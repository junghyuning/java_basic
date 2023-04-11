package inheritance;

public class Member {  //부모클래스
	private String id;
	private String name;

	//생성자
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	//Setter & Getter
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

	//출력 메서드
	public void display() {
		System.out.println("id : " + id);
		System.out.println("name : " + name);
	}

}
