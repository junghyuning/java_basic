package xyz.itwill.util;

//표현 대상을 추상화하여 클래스로 선언할 경우, 필드의 자료형에따라 여러개의 클래스를 선언하여 사용하는 경우 발생
//But Object 클래스 활용 : 필드의 자료형을 Object 클래스 타입으로 선언할 경우 모든 클래스로 생성된 객체를 저장 가능함.
//=> Object 타입의 필드에 저장된 객체를 반환받아 사용하기 위해서는 반드시 명시적 객체 형변환 필요함 -> 코드의 복잡성 증가.

public class NoneGeneric {
	private Object field;
	//생성자
	public NoneGeneric() {
		// TODO Auto-generated constructor stub
	}
	
	public NoneGeneric(Object field) {  //매개변수로 Object 설정시, 모든 자료형 가능함
		super();
		this.field = field;
	}
	//getter, setter
	public Object getField() {  // 반환형으로 Object => 모든 객체를 반환 할 수 있다는 의미.
		return field;
	}

	public void setField(Object field) {
		this.field = field;
	}
	
}
