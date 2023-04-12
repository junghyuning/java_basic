package realization;

public class BoatCarRealApp {
	public static void main(String[] args) {
//	BoatCarReal boatCarReal = new BoatCarReal();

		// 자식클래스가 상속받은 모든 부모 인터페이스로 참조변수를 생성하여 자식클래스의 객체 저장 가능
		//=> 묵시적 객체 형변환에 의해 오버라이딩된 자식클래스의 메서드 호출
		//=> 인터페이스에따라 호출 가능한 메서드가 다른 경우 발생
		BoarCar boatCar = new BoatCarReal();
//		Car boatCar = new BoatCarReal();
//		Boat boatCar = new BoatCarReal();
		
		
		
		boatCar.run();
		boatCar.navigate();
		boatCar.floating();
		
		
		//같은 자손을 둔 조상 클래스 끼리는 형변환 가능.
		if (boatCar instanceof Car) System.out.println(true);
		((Car)boatCar).run();
		
	}
}
