package xyz.itwill01.old;

public class MessagePrint {
	
	public MessagePrint() {
	
	}
	
	public void helloMessagePrint() {
		HelloMessageObject object = new HelloMessageObject(); //명령을 통해 객체를 직접 생성하는 방법
		String message = object.getHelloMessage();
		System.out.println("message = "+message);
	}
	
	public void hiMessagePrint() {
		HiMessageObject object = new HiMessageObject();
		String message = object.getHiMessage();
		System.out.println("message = " + message);
	}
}
