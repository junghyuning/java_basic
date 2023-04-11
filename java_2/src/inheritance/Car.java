package inheritance;

public class Car extends Object{
	private String modelName;
	private String userName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(String modelName, String userName) {
		super();
		this.modelName = modelName;
		this.userName = userName;
	}
	
	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	//Object 클래스의 toString() 메서드를 오버라이드 선언
	//=> object클래스의 toString() 메서드는 숨겨지고 Car 클래스의 toString()메서드 호출
	//=> VO클래스에서는 필드값을 문자열로 변환하여 반환하는 명령 작성 - 필드값 확인.
	@Override
	public String toString() {
		return "모델명 = "+ modelName + ", 소유자 " + userName;
	}

	
	

}
