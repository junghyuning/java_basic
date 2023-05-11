package jdbc;

public class StaticBlock {
	static {
		System.out.println("###StaticBlock 클래스의 정적영역에 작성된 명령 실행### ");
		//이렇게 할 경우, Class.forName() 메서드 호출 만으로 객체의 생성 및 메서드 수행 가능.
		StaticBlock sb = new StaticBlock();
		sb.display();
	}
	
	public StaticBlock() {
		System.out.println("### StaticBlock 클래스의 기본 생성자 호출 - 객체생성 ###");
	}
	
	public void display() {
		System.out.println("### StaticBlock 클래스의 display() 메서드 호출###");
	}
}
