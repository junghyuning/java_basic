package enumerate;

public class CompassApp {
	public static void main(String[] args) {
//			열거형에 선언된 상수필드값 출력(문자 상수필드명 출력됨)
		System.out.println("동 = " + Compass.EAST);
		System.out.println("서 = " + Compass.WEST);
		System.out.println("남 = " + Compass.SOUTH);
		System.out.println("북 = " + Compass.NORTH);
		System.out.println("=====================================================================");
		System.out.println("동 = " + Compass.EAST.getValue());
		System.out.println("서 = " + Compass.WEST.getValue());
		System.out.println("남 = " + Compass.SOUTH.getValue());
		System.out.println("북 = " + Compass.NORTH.getValue());
		System.out.println("=====================================================================");
//		EnumType.values(): 열거형에 선언된 모든 상수필드를 배열로 변환 -> 반환하는 메서드.
		for(Compass compass : Compass.values()) {
			//EnumType.ordinal() : 상수필드를 구분하는 첨자(INDEX) 반환 // default 초기값
			System.out.println("Compass = "+ compass.getValue()+">>"+compass.ordinal());
		}
	}
}
