package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public GridLayoutApp(String title) {
		super(title);
		
		setLayout(new GridLayout(3,2));//컨테이너를 몇행 몇열로 만들것인지
		
		Button button1 = new Button("Button-1");
		Button button2 = new Button("Button-2");
		Button button3 = new Button("Button-3");
		Button button4 = new Button("Button-4");
		Button button5 = new Button("Button-5");
//		Button button6 = new Button("Button-6");\

		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
//		add(button6);
		
		setBounds(1000, 300, 400, 400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		GridLayoutApp gla = new GridLayoutApp("gridlayout");
	}
}
