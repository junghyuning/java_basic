package enumerate;

public enum Compass {
	//열거형에 선언된 상수필드는 기본적으로 정수형으로 설정
	// => 상수필드를 선언하면 열거형의 기본생성자를 이용하여 초기값이 상수필드에 저장
	//=> 상수필드에는 차례대로 0부터 순차적으로 정수값이 기본값으로 저장.
	
	//EAST, WEST, SOUTH, NORTH;  //기본적으로 private final int형  // 생성자 생성시, 오류 발생
	//=> 매개변수가 있는 생성자를 이용하여 상수필드를 생성하여 초기값 저장함.
	EAST("동"), WEST("서"),SOUTH("남"),NORTH("북");
	
	
	//if -> 0,1,2,3,...말고 다른 값을 저장하고 싶다면?
	//상수필드의 자료형 or 저장값을 변경하기 위한 필드 선언
	//=> 형식) private final 제한자 사용하여 필드 선언해야 함.
	//=> 필드에 저장된 값을 변경하기 위해 반드시 매개변수가 있는 생성자를 선언해야 함.
	private final String value;	//상수필드값을 변경하기위한 필드
	
	
	//상수필드에 초기값을 저장하기 위한 매개변수가 있는 생성자 선언
	//=> 상수필드의 자료형 or 저장값을 변경하기 위한 필드에 매개변수의 값 저장
	//=> 반드시 생성자는 <<<은닉화>>>
	//생성자를 선언하면 매개변수x인 기본생성자는 미제공. => 즉, 기본생성자로 초기화된 필드는 오류생김
	//생성자
	private Compass(String value) {
		this.value = value;
	}
	
	
	//상수필드의 자료형 or 저장값을 변경하기위한 필드값 반환
	//=> 상수필드에 저장된 값을 반환 하는것.
	public String getValue() {
		return value;
	}
	
}
