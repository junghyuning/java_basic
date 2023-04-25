package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//프레임의 [닫기] 버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
//=> 프레임에서는 WindowEvent 발생 - WindowListener 인터페이스를 상속받은 자식클래스로 이벤트 처리
public class WindowListnerApp extends Frame {
	private static final long serialVersionUID = 1L;
	public WindowListnerApp(String title) {
		super(title);
		
		addWindowListener(new WindowEventHandleOne());
		
		
		setBounds(800,200,300,300);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new WindowListnerApp("window event");
	}
	
	
	//Listener 인터페이스 상속받은 자식클래스는 무조건 인터페이스의 모든 추상 메서드를 오버라이드해야함.
	// => 즉, 불필요한 추상메서드라도 다 오버라이딩해야하는 단점 존재 => window adapter 사용하기
	public class WindowEventHandleOne implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("window Opened method calling");
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("window Closing method calling");
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("window Closed method calling");
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("window conified method calling");
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("window Deconified method calling");
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("window Activated method calling");
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("window Deactivated method calling");
			
		}
		
	}
}
