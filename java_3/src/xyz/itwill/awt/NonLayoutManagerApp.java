package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class NonLayoutManagerApp extends Frame{

	private static final long serialVersionUID = 1L;
	public NonLayoutManagerApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		setLayout(null); //배치관리자 사용하지 않겠다는 선언.
		Button button1 = new Button("BUTTON-1");
		Button button2 = new Button("BUTTON-2");
		
		button1.setBounds(80, 100, 150, 80);
		button2.setBounds(190, 300, 100, 120);
		
		add(button2);
		add(button1);
		
		
		setBounds(600,100,400,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		NonLayoutManagerApp nonLayoutManagerApp = new NonLayoutManagerApp("배치관리자 미사용");
	}
}
