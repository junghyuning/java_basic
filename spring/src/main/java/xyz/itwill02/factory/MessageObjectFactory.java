package xyz.itwill02.factory;


//Factory 디자인 패턴을 이용하여 작성된 클래스 - Factory 클래스(Provider 클래스)
// => 프로그램 개발에 필요한 객체를 생성 제공하는 클래스 - Container
public class MessageObjectFactory {
	//FACTORY 클래스에 의해 제공될 객체를 구부하기 위한 상소 (Constant)
	public static final int HELLO_MSG=1;
	public static final int HI_MSG=2;
	
	//매개변수에 전달된 값을 비교하여 필요한 객체를 생성하여 반환하는 메서드
	public static MessageObject getMessageObject(int messageObject) {
		MessageObject object = null;
		switch (messageObject) {
		case 1:
			object = new HelloMessageObject(); break;
		case 2:
			object = new HelloMessageObject(); break;
		}
		return object;
	}
}
