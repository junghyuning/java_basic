package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class PanelApp extends Frame {

private static final long serialVersionUID = 1L;
	
	public PanelApp(String title) {
		super(title);
		
		Button red = new Button("Red");
		Button green = new Button("Green");
		Button blue = new Button("Blue");
		
		
		
		TextField textField = new TextField(); // 한줄
		
		TextArea textArea = new TextArea(); //여러줄
		
		Panel panel = new Panel(); //FlowLayout이 기본 배치관리자인 클래스
		
//		add(red, BorderLayout.NORTH);
//		add(green, BorderLayout.NORTH);//같은 장소에 여럿 배치 불가 -> 겹쳐 나옴
//		add(blue, BorderLayout.NORTH);
		//=> 만일 둘다 북쪽에 배치하고싶다면 추가의 컨테이너를 생성하여 사용함
		//=> 이때, 새로 생성하는 컨테이너는 프레임을 설정하면 안됨
//		=> 독립적으로 사용 불가한 컨테이너에 배치후, 프레임에 추가해줌.
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		add(panel,BorderLayout.NORTH);
		add(textArea,BorderLayout.CENTER);
		add(textField,BorderLayout.SOUTH);
		
		
//		panel.setFont(getFont()); // Font 클래스 사용 : 글자 관련 속성 저장을 위한 클래스
		
		
		panel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		textField.setFont(new Font(Font.SERIF,Font.BOLD,18));
		
		//Color 클래스
//		Component.setForeground(Color c) 글자색 변경 메서드
//		빨, 파, 초 0~255 범위의 정수값
//		단색 
		red.setForeground(new Color(255,0,0));
		green.setForeground(new Color(0,255,0));
		blue.setForeground(new Color(0,0,255));
		
		textArea.setBackground(Color.ORANGE);
		textField.setBackground(Color.ORANGE);
		red.setEnabled(false); // 컴포넌트의 비활성화 = 변경불가 = 비활성화 = 누를 수 없음.
		textArea.setFocusable(false); // 텍스트 컴포넌트 전용 메서드 -> 입력촛점위치여부를 변경(커서가 안움직임) false 일시, 입력 불가능
		
		setBounds(1000, 300, 400, 400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new PanelApp("Panel");
	}
}
