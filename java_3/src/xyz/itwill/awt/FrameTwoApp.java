package xyz.itwill.awt;

import java.awt.Frame;

public class FrameTwoApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	
	public FrameTwoApp(String title) {
		// 생성자에서 UI 구현함.
		super(title);
		
		setBounds(600,100,400,300); //컴포넌트의 출력 위치 & 크기
		setVisible(true);
		setResizable(true);
		
	}
	
	public static void main(String[] args) {
		//Frmae 상속받은 자식클래스의 객체 생성함. = 프레임 생성됨.
		new FrameTwoApp("Title:Frame");
		
	}
}
