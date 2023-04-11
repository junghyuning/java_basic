package association;

//엔진 정도 : 연료타입, 배기량
public class Engine {
	private String fualType;
	private int displacement;
	
	


	//기본생성자
	public Engine() {
		// TODO Auto-generated constructor stub
	}
	
	//생성자
	public Engine(String fualType, int displacement) {
		super();
		this.fualType = fualType;
		this.displacement = displacement;
	}


	//private 변수에 대한 getter setter 메서드들.
	public String getFualType() {
		return fualType;
	}

	public void setFualType(String fualType) {
		this.fualType = fualType;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	
	
	//엔진정보(필드값)출력하는 메서드
	
	public void displayEngine() {
		System.out.println("연료타입 = " + fualType);
		System.out.println("배기량 = " + displacement);
	}
	

}
