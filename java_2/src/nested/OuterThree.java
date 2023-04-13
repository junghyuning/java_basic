package nested;



public class OuterThree {
	private int outerNum;

	public OuterThree() {
		// TODO Auto-generated constructor stub
	}

	public OuterThree(int outerNum) {
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
	}
	public void local() {
		//지역클래스 : 지역매서드 내에서만 작동하며, 메서드 종료시 사라짐
		//final or abstract 제한자만 사용하여 선언
		//접근제한자 및 static 사용 불가.
		//=> 비동기식 처리를 위한 스레드 객체르 생성하기위해 사용.
		class InnerThreeLocal{
			int innerNum;
			
			void innerDisplay() {
				System.out.println("innerNum = " + innerNum);
			}
		}
		
		InnerThreeLocal innerThreeLocal = new InnerThreeLocal();
		innerThreeLocal.innerNum=300;
		innerThreeLocal.innerDisplay();
	}

}
