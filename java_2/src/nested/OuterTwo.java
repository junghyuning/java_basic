package nested;

public class OuterTwo {
	private int outerNum;

	public OuterTwo() {
		// TODO Auto-generated constructor stub
	}

	public OuterTwo(int outerNum) {
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

		//
		System.out.println("staticNum = " + InnerTwo.staticNum); // 이미 메모리에 로드되어있으므로 객체없이 클래스참조로 접근가능

		InnerTwo innertwo = new InnerTwo(200); // 객체 생성시, 사용 가능해짐
		System.out.println("innerNum = " + innertwo.getInnerNum());// 엣...? innernum에숫자 저장하려면 어케해야함?

	}

	// 정적 내부 클래스 (Static InnerClass) :
	// => 정적 내부클래스에서는 static 제한자를 사용하여 필드 or 메서드 선언이 가능.
	// static -> class통해서만 접근 가능 -> 내부클래스이지만, 결국 서로 접근 불가
	public static class InnerTwo {

		private int innerNum;
		private static int staticNum = 300; // 스태틱변수 사용 가능.

		public InnerTwo() {
			// TODO Auto-generated constructor stub
		}

		public InnerTwo(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}

		public static int getStaticNum() {
			return staticNum;
		}

		public static void setStaticNum(int staticNum) {
			InnerTwo.staticNum = staticNum;
		}

		public void innerDisplay() {
			System.out.println("innerNum = " + innerNum);
			System.out.println("staticNum = " + staticNum);
//			System.out.println("outerNum = " + outerNum);  // 내부클래스이지만, static 클래스의 경우 외부클래스의 객체변수에는 접근 불가함
			// 메모리 로딩 타이밍이 달라서
			// 외부클래스 참조 가능한 경우 : 외부클래스의 static 필드 or 메서드의 경우 참조 가능 -> 메모리 로딩 타이밍이 같음.

		}
	}

}
