package xyz.itwill.util;

//제네릭: 필드의 자료형 대신 사용될 식별자 -> 미지정 자료형
//=> java 자료형 선언시 <> 기호에 제네릭타입 식별자 선언
//Object 타입을 사용할 때와는 다르게 형변환 필요x 
public class Generic<T extends Number> {//
	private T field;
	//생성자
	public Generic() {
		// TODO Auto-generated constructor stub
	}
	
	public Generic(T field) {  //매개변수로 Object 설정시, 모든 자료형 가능함
		super();
		this.field = field;
	}
	//getter, setter
	public T getField() {  // 반환형으로 Object => 모든 객체를 반환 할 수 있다는 의미.
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
}
