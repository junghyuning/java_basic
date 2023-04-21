package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

//FlowLayout : 왼-> 오 차례로 배치
public class FlowLayoutApp extends Frame {

	private static final long serialVersionUID = 1L;

	public FlowLayoutApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		
		//프레임의 배치 관리자를 [FlowLayout]으로 변경함.
		setLayout(new FlowLayout());
		Button button1 = new Button("Button-1");
		Button button2 = new Button("Button-2");
		Button button3 = new Button("Button-3");
		Button button4 = new Button("Button-4");
		Button button5 = new Button("Button-5");

		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		
		
		
		setBounds(1000, 300, 400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutApp("FlowLayout");
	}
}
