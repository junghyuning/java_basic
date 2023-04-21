package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutApp extends Frame {

	private static final long serialVersionUID = 1L;

	public BorderLayoutApp(String title) {

		super(title);

		Button button1 = new Button("center");
		Button button2 = new Button("east");
		Button button3 = new Button("west");
		Button button4 = new Button("south");
		Button button5 = new Button("north");

		add(button1,BorderLayout.CENTER);
		add(button2,BorderLayout.EAST);
		add(button3,BorderLayout.WEST);
		add(button4,BorderLayout.SOUTH);
		add(button5,BorderLayout.NORTH);


		setBounds(1000, 300, 400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		BorderLayoutApp bla = new BorderLayoutApp("BorderLayout");
	}
}
