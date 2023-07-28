package xyz.itwill06.oop;


//핵심관리 코드를 가진 메서드에 횡단관심코드를 가진 메서드를 삽입하여
public class AopProxy implements Aop{
	//핵심관심코드의 메서드가 선언된 클래스의 객체를 저장하기 위한 필드
	//=> 필드의 자료형을 인터페이스를 선언하여 모든 자식 클래스의 객체가 저장되도록 설정
	private Aop target;
	
	//횡단관심 코드의 메서드가 선언된 클래스의 객체를 저장하기 위한 필드
	private AopLogger logger;
	
	
	//생성자를 이용하여 필드에 객체를 전달받아 저장하거나 객체를 직접 생성하여 필드에 저장 = 의존성 주입
	public AopProxy(Aop target) {
		this.target = target;
		logger = new AopLogger();
	}
	
	//인터페이스를 상속받아 오버라이드 선언된 메서드(PointCut)에 핵심관심코드에 횡단관심코드가 삽입(Weaving)되어 명령이 실행되도록 작성
	//=> 핵심관심 코드가 작성된 메서드 호출 전/후에 작성된 메서드를 호출 가능
	@Override
	public void display1() {
		logger.beforeLog(); //횡단관심코드
		target.display1(); //핵심관심코드
	}

	@Override
	public void display2() {
		logger.beforeLog(); //횡단관심코드
		target.display2();
	}

	@Override
	public void display3() {
		logger.beforeLog(); //횡단관심코드
		target.display3();
	}
	
}
