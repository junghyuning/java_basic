package nested;


//중첩 클래스(Nested Class) : 클래스 안의 클래스
//=> 두개의 클래스가 밀접한 관계에 있을 때 선언. -> 캡슐화 강화의 역할.

public class OuterOne {  //외부클래스
	private int outerNum;
	
	public OuterOne() {
		// TODO Auto-generated constructor stub
	}
	public OuterOne(int outerNum) {
		super();
		this.outerNum = outerNum;
	}
	public int getOuterNum() {
		return outerNum;
	}
	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void outerDisplay() {
		System.out.println("outerNum = " + outerNum);
		//outer클래스는 innerclass의 필드or 메서드 직접적인 접근 불가
//		System.out.println("innerNum = "+ innerNum);
//		innerDisplay();
		
		//=> but 객체를 생성하여 내부클래스에 접근은 가능.
//		InnerOne innerOne = new InnerOne();
//		System.out.println(innerOne.innerNum);
//		innerOne.innerDisplay();
	}

	
	//일반 내부클래스 : 컴파일 시, [외부class.내부class.class] 파일로 제공됨.
	public class InnerOne {
		private int innerNum;
		
		public InnerOne() {
			// TODO Auto-generated constructor stub
		}
		
		public InnerOne(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}
		public void innerDisplay() {
			System.out.println("innerNum = "+ innerNum);
			
			//객체내부클래스에서는 외부클래스의 필드or 메서드를 접근제한자에 상관없이 참조 가능.
			System.out.println("outerNum = "+ outerNum);  //private로 선언된 외부클래스의 변수도 사용 가능.
			outerDisplay();  //외부클래스의 메서드 가져다쓰기 가능
		}
	}

}
