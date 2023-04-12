package realization;

public interface BoarCar extends Car, Boat { // 인터페이스끼리 상속할때는 extends 사용 -> 구현할 것 아니므로 + 다중상속도 가능
												// 즉, car와 Boat의 구조를 다시 쓸필요x
	void floating();
}
