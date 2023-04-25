package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventAnonymousHandleApp extends Frame {

	private static final long serialVersionUID = 1L;

	
	public EventAnonymousHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit = new Button("EXIT");// 이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		//익명클래스 형태 : 1회용으로만 사용하고 재사용하지 않을시에만 사용 -> 유지보수 어려움.
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new EventAnonymousHandleApp("익명클래스이벤트처리");
	}
}
