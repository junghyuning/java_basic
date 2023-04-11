package association;


// 클래스간의 관개 = 객체 관계
//=> UML : Unified Modeling Language -> UML을 사용하여 클래스 다이어그램으로 표현.
// 객체지향 프로그램을 사용하여 전체를 설계할때 사용.
// 1. 일반환 관계(Generalizatio) = 상속관계 X is a Y
// 사원 & 관리자 관계 -> 사원은 관리자이다 x // 관리자는 사원이다. (O)
// 2.  실체화관계(Realization) : 상속관계 
//=> 클래스 작성 시, 기존 인터페이스 상속받아 작성
//=> 인터페이스 : 현실에 존재하는 대상을 클래스보다 추상적으로 표현하기위한 자료형
// 3. 연관관계 (association) : 포함관계 (X has a Y)


//자동차정보 (모델명 생산년도, 엔진정보)
//엔진정보는 단순 string int 등으로 표현하기 어려워서 별도의 객체로 생성해줌.
public class Car {
	private String modelName;
	private int productionYear;
	
	
	//Engine 이라는 클래스를 이용해서 엔진 정보를 저장.  => Engine 클래스를 자료형으로 선언된 필드
	//=> 필드에는 Engine 객체를 제공받아 저장. = 포함관계
	private Engine carEngine;
	
	//기본생성자
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	//매개변수가있는 생성자 alt shift s -> o
	public Car(String modelName, int productionYear, Engine carEngine) {
		super();
		this.modelName = modelName;
		this.productionYear = productionYear;
		this.carEngine = carEngine;
	}


	
	
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	

	//carEngine 객체의 은닉화 -> 객체 생성 위한 getter 메서드
	public Engine getCarEngine() {
		return carEngine;
	}
	

	public void setCarEngine(Engine carEngine) {
		this.carEngine = carEngine;
	} 
	
	public void displayCar() {
		System.out.println("모델명 = " + modelName);
		System.out.println("생산년도 = " + productionYear);
		System.out.println("엔진정보 = " + carEngine); // 이렇게 작성 시, 주소만 반환
		//따라서 아래 두 방법 중 하나 사용해야 함.
		//but 포함관계가 설정되지않은 상태에서 메서드가 호출 될 경우 nullPointException 발생할 수 있음.
		
		/*System.out.println("연료타입 = " + carEngine.getFualType());
		System.out.println("배기량 = " + carEngine.getDisplacement());*/
		//코드의 중복성을 줄이는 효과가 있지만, 일반적으로 객체지향에서 입출력은 담당하지 않아 보통은 존재하지 않는 메서드임.
		
		carEngine.displayEngine();
	}
	
	
	
}


