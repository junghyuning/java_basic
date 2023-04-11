package association;

public class carApp {
	public static void main(String[] args) {
		
		//엔진 생성
		Engine engine = new Engine();
		
		//(setter통해) 포함관계 생성 => 직접, 메서드에 불러 내서 포함관계를 만들어줘야 함.
		// 포함관계 미생성시, nullPointException 발생함.
		engine.setFualType("경유");
		engine.setDisplacement(2000);
		
		Car carOne = new Car();
		
		
		//포함관계 생성 => 직접, 메서드에 불러 내서 포함관계를 만들어줘야 함.
		// 포함관계 미생성시, nullPointException 발생함.
		carOne.setModelName("쏘렌토");
		carOne.setProductionYear(2020);
		//setter 메소드를 호출 -> 매개변수에 엔진정보 저장
		carOne.setCarEngine(engine);
		
		carOne.displayCar();
		
		System.out.println("============================================================");
		Car carTwo = new Car("싼타페",2023, new Engine("휘발유", 3000));		
		carTwo.displayCar();
		System.out.println("============================================================");
		//쏘렌토의 엔진정보만
		System.out.println(carOne.getModelName()+"의 엔진정보 >> ");
		engine.displayEngine();
		System.out.println("============================================================");
		//carTwo의 엔진정보 보기 -> 선언시, 참조변수 선언x but 필드는 생성해둠 => 따라서 getter 메서드 사용
		//getter메서드로 carTwo의 엔진객체 불러오고 해당 객체로하여금 displayEngine() 메서드 호출하도록함.
		//다중 참조 가능.(a.b.c)
		carTwo.getCarEngine().displayEngine();
		
	}
}
