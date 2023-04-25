package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowAdapterApp(String title) {
		super(title);

		// addWindowListener(new WindowEventHandleTwo());

		// 프레임의 [닫기]를 누른 경우 프로그램을 종료하는 기능의 명령 - 익명의 내부클래스 사용
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setBounds(800, 200, 300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WindowAdapterApp("Window Adapter");
	}

	// 내부클래스로 윈도우핸들클래스 선언
//	public class WindowEventHandleTwo extends WindowAdapter { // 필요한 메서드만 오버라이딩 가능한 클래스.
//		@Override
//		public void windowClosing(WindowEvent e) {
//			System.exit(0);
//		}
//	}
}
