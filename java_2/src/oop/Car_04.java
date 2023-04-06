package oop;

//클래스 : 객체를 생성하기위한 자료형 - 참조형
//-> java 에서는 객체대신, 인스턴스라는 용어 사용   
//
//현실에 존재하는 사물 or 관념을 클래스라는 자료형으로 표현하여 프로그램에 동작될수 있도록 객체를 생성하여 사용함
//
//클래스 선언 형식
//-> [public] class 클래스명{
//	필드(field) = 멤버변수 : 표현 대상의 속성값을 저장하기 위한 변수
//	...
//	생성자(Constructor) : 클래스로 객체를 생성하기 위한 특별한 메소드 (if 생성자가 하나도 없을 시, 기본 생성자를 jms가 자동으로 하나 추가해줌)
//	...
// 메소드(Method) = 멤버함수 : 표현대상의 행위를 명령으로 제공하기 위한 함수 
// ...
// }
// => 메서드는 필드에 저장된 값을 이용하여 필요한 기능을 제공.

//클래스를 작성할 때 필드와 메소드에 접근 지정자를 사용하여 접근 허용 유무설정 가능
//접근 제한자(Access Modifier) : 필드, 생성자, 메서드를 은닉화 하기위해 사용함.
//private(클래스) > default(패키지) > protected(패키지+다른 패키지이지만 해당클래스의 자손클래스인 경우) > public(전체공개)

// 자동차를 객체 모델 -> 클래스 작성 
//속성 = 필드: 모델명 / 엔진상태 / 현재속도 
//행위(기능) = method : 시동 on,off / 속도 증,감, 중지(0)


public class Car_04 {
	// 필드(field) = 멤버변수
	private String modelName;
	private boolean engineStatus; // false = off / true = on
	private int currentSpeed; // 현재속도

	// 생성자(constructor) : 생성자 선언x시 매개변수가 없는 기본 생성자가 (default constructor) 자동으로 제공됨.
	// but 다른 생성자가 이미 존재하고 있고, 기본생성자도 필요할 경우 기본생성도 따로 표기해 줘야 함.

	// 메서드(Method) : 필드를 이용하여 메소드의 명령으로 필요한 기능을 제공되도록 작성.

	// 1. 시동 on
	void startEngine() {
		engineStatus = true;
		System.out.println(modelName + "의 시동을 켰습니다.");
	}

	// 2. 시동 off
	void stopEngine() {
		if (currentSpeed != 0) {
			System.out.println("운전 중입니다. 멈추겠습니다.");
			// 코드의 중복성 최소화 -> 생산성 및 유지보수의 효율성 증가. (코드 변경시 일괄처리 가능해짐.)
			speedZero(); // 클래스 내부에 선언된 메소드는 서로 호출 가능.

		}
		engineStatus = false;
		System.out.println(modelName + "의 현재속도는 " + currentSpeed + "km/h 입니다. 시동을 껐습니다.");
	}

	// 3. 속도 증가
	void speedUp(int speed) { // 증가하는 속도를 매개변수로 전달 받을 것.
		if (!engineStatus) {
			System.out.println(modelName + "의 자동차 엔진이 꺼져있습니다.");
			return; // 메서드 종료
		}
		if (speed < 0 && speed + currentSpeed >= 150) {
			System.out.println("비정상 가속하였습니다.");
			return;
		}
		currentSpeed += speed;
		System.out.println(modelName + "의 속도가 " + speed + "km/h 증가되었습니다. 현재속도는 " + currentSpeed + "km/h 입니다.");

	}

	// 4. 속도 감소
	void speedDown(int speed) { // 증가하는 속도를 매개변수로 전달 받을 것.
		if (!engineStatus) {
			System.out.println(modelName + "의 자동차 엔진이 꺼져있습니다.");
			return;
		}
		if (currentSpeed - speed < 0) {
			System.out.println("비정상 감속하였습니다.");
			return;
		}
		currentSpeed -= speed;
		System.out.println(modelName + "의 속도가 " + speed + "km/h 감소되었습니다. 현재속도는 " + currentSpeed + "km/h 입니다.");

	}

	// 5. 이동 중지

	void speedZero() {
		currentSpeed = 0;
		System.out.println(modelName + "의 현재속도는 " + currentSpeed + "km/h 입니다. 자동차가 멈추었습니다.");
	}

//	캡슐화(=추상화) : 표현대상의 속성(변수)와 기능(메서드)를 하나의 자료형으로 필드를 은닉화 처리하여 보호 / 메서드를 이용하여 처리되도록 설정.
//	Getter 메소드 : 은닉화 처리된 필드를 외부에서 사용/변경할 수 있도록, 필드값을 반환하는 메서드 
//	형식) => public 반환형 get필드명(){ return 필드명; }
//	=> 즉, 필드의 자료형이 boolean 인 경우, method의 반환형 역시 boolean 이며, 메서드의 이름은 [is필드명] 으로 사용함.
//	=> public boolean getIsEngineStatus(){ return engineStatus; }
//	
//	Setter 메서드 : 매개변수로 값을 전달받아 매개변수에 저장된 겂으로 필드값을 변경하는 메서드
//	형식) public void set필드명(자료형 변수명) { 필드명 = 변수명; }
//	=> public void setModelName(String name) {
//		//검증
//		modelName = name;
//	}
//	but, 만일 해당 클래스 내부의 연산에서만 값을 사용할 목적이라면 getter/setter 역시 생성할 필요x
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelName){  // carOne.setModelName("sonata"); => sonata를 modelName에 저장하게 됨.
		this.modelName = modelName;  // 필드와 매개변수를 구분하기위해 참조변수 this 사용
	}

	public boolean isEngineStatus() {
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	//이클립스에서는 은닉화 처리된 필드에 대한 getter 메소드와 Setter메서드를 만들어주는 메뉴 있음. (source -> generate Getters and Setters)
	// 단축키 => Alt + Shift + s => R >> generate
	
	
	
}
