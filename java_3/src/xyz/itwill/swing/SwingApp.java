package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

//JFrame -> java Frame => 닫기기능 자동 구현돼있음. 
//[닫기] 누른 경우 동작된능 변경하고싶은 경우 => JFrame.setDefaultCloseOperation(int operation)메서드

//=> DO_NOTHING_ON_CLOSE : 아무런 동작도 실행되지 않도록 설정하는 상수
//=> HIDE_ON_CLOSE : 프레임을 보여지지 않도록 설정하는 상수 - 기본값
//=> DISPOSE_ON_CLOSE : 메모리를 정리하고 프로그램을 종료하는 상수
//=> EXIT_ON_CLOSE  : 프로그램을 종료하는 상수

//3.프레임을 직접 변경하지 않고 프레임의 Container 객체를 반환받아 변경 처리
//=> 프레임의 배치관리자 변경, 프레임의 배경색 변경, 프레임의 컴퍼넌트 배치 등

//JTextField 컴퍼넌트에서 메세지를 입력 후 엔터를 누르면 JTextArea 컴퍼넌트에 메세지를 
//추가하여 출력되도록 프로그램 작성
//=> JTextField 컴퍼넌트에서 메세지를 입력 후 엔터를 누르면 ActionEvent 발생
public class SwingApp extends JFrame {

	private static final long serialVersionUID = 1L;

	JTextField jTextField;
	JTextArea jTextArea;

	public SwingApp(String title) {
		super(title);

		jTextArea = new JTextArea();
		jTextField = new JTextField("[홍길동]님이 입장하셨습니다.");

		jTextField.setFont(new Font("나눔고딕코딩", Font.BOLD, 20));
		jTextArea.setFont(new Font("나눔고딕코딩", Font.BOLD, 20));

		jTextArea.setBackground(Color.yellow);

		// JTextArea 컴퍼넌트에 입력촛점을 제공하지 않도록 설정 - 출력 컴퍼넌트로만 사용
		jTextArea.setFocusable(false);
		
		//JFrame.getContentPane() : 프레임의 컨테이너 기능을 객체를 반환하는 메소드
		Container container = getContentPane();
		container.add(jTextArea, BorderLayout.CENTER);
		container.add(jTextField, BorderLayout.SOUTH);

		// JTextField 컴퍼넌트에서 ActionEvent가 발생될 경우 이벤트 처리할 클래스로 객체를
		// 생성하여 이벤트 처리 기능 등록
		jTextField.addActionListener(new TextEventHandle());

//		매개변수로 WindowConstants.DO_NOTHING_ON_CLOSE / HIDE_ON_CLOSE / DISPOSE_ON_CLOSE / EXIT_ON_CLOSE 사용
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setBounds(800, 200, 400, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SwingApp("Swing app");
	}

	public class TextEventHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = jTextField.getText();

			if(!text.equals("")) {//입력된 문자열이 있는 경우
				//JTextArea.append(String text) : JTextArea 컴퍼넌트에 문자열을 추가하여 출력하는 메소드
				jTextArea.append("[홍길동]"+text+"\n");
				
				jTextArea.setCaretPosition(jTextArea.getText().length());
				//TextComponenet.setText(String text) : JTextField 컴퍼넌트 또는 JTextArea 
				//컴퍼넌트에 입력된 문자열을 변경하는 메소드
				jTextField.setText("");
			}
		}
	}
}
