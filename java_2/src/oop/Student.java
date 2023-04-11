package oop;

//static 키워드 : 객체가 아닌 클래스로 접근하기 위한 기능을 제공하는 제한자
//=>Access modifier : public, package(default), protected, public
//=> static, final, abstract //"내부"클래스, 필드, 메서드에 사용가능

//학생정보(학번, 이름, 국어, 영어, 총점) 저장 위한 클래스 - vo class
//if - 계산 x -> 문자열 / 계산 o -> 숫자형
//but 검색속도 : 숫자 >>>>>>>> 문자 따라서 계산 목적이 아니더라도 검색목적이 있으면 숫자형이 좋음.
public class Student {
	
	//필드
	private int num;
	private String name;
	private int kor, eng, tot;  // 객체마다 변수가 따로 생성됨 -> 따라서 전체 객체를 아우르는 결과를 얻기 위해서는 static(class자체로 접근하는 방식) 변수 및 메서드를 사용함.
	// 정적 필드: static field : 클래스를 읽어 메모리에 저장될때 생성되는 필드 = 클래스변수.
	// => 객체가 생성되기 전에 메모리에 하나만 생성됨 
	// (클래스 로드시 클래스 변수도 메모리에 로드되므로 당연히 객체보다 일찍 생성되고 메모리에 등록되므로 결과적으로 모든 객체들이 사용하는것이 가능해짐)
	// => 직접 초기화해야함 ( 생성자에서 사용 x)
	// => 클래스로 생성된 모든 객체가 정적 필드 사용 가능 -> 공유값임 (메모리 절약 및 필드값 변경)
	// => 클래스 외부에서는 객체가 아닌 클래스를 사용하여 접근할 수 있음.
	private static int total ; // static은 미리 주어지는 것. -> 생성자가 초기화하지 않고 직접 초기값을 필드에 저장함. (초기화값이 default값과 같은경우 초기화할필요x)
	
	//생성자(constructor) : 특별한 형태의 메서드.
	//1. 기본 생성자
	public Student() {}
	
	//2. 학번 이름 국어 영어 - 총점은 나중에 연산을 통해 값 저장 -> 초기화 필요x // 사실상 구조적으로 set메서드와 마찬가지로, 매개변수를 받아 변수에 저장하는 것.
	public Student(int num, String name, int kor, int eng) {
		super();
		this.num = num; //private의 의미가 있는가..? if문 같은 조건을 달지 않을경우 그게그것인지??  
						// 그게 그것이지만, java의 경우 모든것을 객체지향으로 표현해주는것이 좋음 (그것이 객체지향이니까)
						// 객체지향으로 표현시 당장은 아니더라도 유지보수시에 수정에 유리함
		this.name = name;
		this.eng = eng;
		this.kor = kor;
		
		
		//tot = kor+eng; => 이런식으로 초기화 외의 명령문도 작성할 수 있음. -> but 따로 메서드 만드는 것이 유지보수에 유리하므로 분리함.
		calcTot(); // => 다른메서드 호출 가능.
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	
	public int getTot() {
		return tot;
	}
	


	
	private void calcTot() {  // 외부에서 사용하지 않고 클래스 내부에서만 사용하므로 private로 작성 가능
		tot = kor+eng;  // tot, kor, eng 는 private 이지만, private는 같은 클래스 내에서는 별도의 조치없이 참조할 수 있으므로 사용 가능.
	}
	
	public void display() {
		System.out.print("["+name+"]님의 성적 >> ");
		System.out.println("kor = " +kor+", eng = "+eng+", tot = "+tot);
	}
	
	
	// this. 을 생략하듯, class. 도 생략한채 변수명만 사용할 수 있음.
	// static + method() => this 키워드를 자동으로 제공하지 않는 메서드
	// static 메서드는 클래스를 사용하여 정적 필드 및 메서드 접근 가능. (but 클래스 호출 생력 가능)
	public static int getTotal() {
		return total;
	}
	
	public static void setTotal(int total) {  // 초기값을 변경하고 싶을 때, 사용하는 메서드.
		Student.total = total;
	}
}
