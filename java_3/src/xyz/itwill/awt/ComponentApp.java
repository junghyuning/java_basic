package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentApp extends Frame{
	private static final long serialVersionUID = 1L;

	public ComponentApp(String title) {
		// TODO Auto-generated constructor stub
	super(title);
	Button button = new Button("Button");
	
	
	//Container.add(Conponet c) : 컨테이너에 컴퍼넌트를 배체하는 메서드
	//=> 컨테이너에 설정된 배치관리자에의해 컴퍼넌트가 자동 배치
	//출력 위치 및 크기도 자동 설정
	add(button);
	
	setBounds(600,100,300,300);
	setVisible(true);
	setResizable(true);
	
	}
	
	public static void main(String[] args) {
		new ComponentApp("component Set");
	}
}
