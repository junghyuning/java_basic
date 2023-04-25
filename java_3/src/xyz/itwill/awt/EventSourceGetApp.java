package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventSourceGetApp extends Frame {

	private static final long serialVersionUID = 1L;
	Button red, green, blue, white;
	Canvas canvas;

	public EventSourceGetApp(String title) {
		super(title);

		canvas = new Canvas();
		red = new Button("RED");
		blue = new Button("BLUE");
		green = new Button("GREEN");
		white = new Button("WHITE");

		Panel panel = new Panel();
		panel.setLayout(new GridLayout(1, 4));
		panel.add(red);
		panel.add(blue);
		panel.add(green);
		panel.add(white);

		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);

		panel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

		// 프레임 닫기 버튼 누른 경우 프로그램을 종료하는 이벤트 처리 객체 등록.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

//		red.addActionListener(new RedButtonHandle());
//		blue.addActionListener(new BlueButtonHandle());
//		green.addActionListener(new GreenButtonHandle());
//		white.addActionListener(new WhiteButtonHandle());

		//컴퍼넌트마다 이벤트를 처리하는 클래스를 동일하게 설정
		// => 이벤트 처리 메소드에서 이벤트가 발생된 컴퍼넌트를 구분하여 명령을 선택 실행
		red.addActionListener(new ColorButtonHandle());
		green.addActionListener(new ColorButtonHandle());
		blue.addActionListener(new ColorButtonHandle());
		white.addActionListener(new ColorButtonHandle());

		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventSourceGetApp("event source get");
	}
	
	public class ColorButtonHandle implements ActionListener {
		//이벤트 처리 메소드의 매개변수에는 이벤트 관련 정보를 Event 객체로 제공받아 사용
		@Override
		public void actionPerformed(ActionEvent e) {
			//Event.getSource() : 이벤트가 발생된 컴퍼넌트(컨테이너)를 반환하는 메소드
			// => 컴퍼넌트(컨테이너)가 Object 타입의 객체로 반환 
			Object eventSource=e.getSource();
			
			//참조변수에 저장된 객체의 메모리 주소 비교
			if(eventSource==red) {
				canvas.setBackground(Color.RED);	
			} else if(eventSource==green) {
				canvas.setBackground(Color.GREEN);	
			} else if(eventSource==blue) {
				canvas.setBackground(Color.BLUE);	
			} else if(eventSource==white) {
				canvas.setBackground(Color.WHITE);	
			}
		}
		
	}
//	public class RedButtonHandle implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			canvas.setBackground(Color.RED);
//		}
//	}
//	public class BlueButtonHandle implements ActionListener{
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			canvas.setBackground(Color.BLUE);
//		}
//	}
//	public class GreenButtonHandle implements ActionListener{
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			canvas.setBackground(Color.GREEN);
//		}
//	}
//	public class WhiteButtonHandle implements ActionListener{
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			canvas.setBackground(Color.WHITE);
//		}
//	}
}
