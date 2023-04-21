package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//1. 이벤트 소스 // 2. 이벤트처리 객체 //3. 이벤트 처리 객체를 호출

//이벤트 처리 프로그램 : 이벤트 발생 -> 원하는 기능 구현 & 실행되도록 프로그램 작성
// 이벤트 처리 프로그램 작성 방법
//1. 컴퍼넌트와 컨테이너 관련 클래스를 사용하여 디자인 클래스 작성 - UI 구현
//=>Frame 클래스를 상속받아 디자인 클래스 작성.
//=> 컴포넌트 or 컨테이너에서 다양한 이벤트 발생시, JVM이 이벤트와 관련된 xxxEVENT 클래스 객체를 자동 생성함.
//ex) 버튼 누름 -> ActionEnvent 클래스로 객체 생성 -> Action Event 발생

/*
 2. 이벤트 소스엣 발생된 이벤트를 처리하기위한 클래스 작성
 => 이벤트를 처리하기 위한 xxxListener 인터페이스를 상속받아 이벤트 처리 클래스 작성.
 ex) ActionEvent >> ActionListener 인터페이스 상속받아 이벤트 처리 클래스 작성.
 => Listener 인터페이스에서 컴포넌트에서 발생된 이벤트를 처리하기 위해 추상메서드 제공
 => 인터페이스를 상속받은 자식클래스에서 추상메서드를 오버라이딩 선언 -> 이벤트 처리 명령 작성
 3. 이벤트 소스에서 이벤트가 발생되면 이벤트 처리 클래스의 객체를 제공받아 이벤트 처리 명령이 실행되도록 설정함.
 => 형식) Component.addXXXListener(Listner l); 메서드 호출
*/
//[EXIT]버튼 누르면 프로그램을 종료하는 프로그램.
public class EventHandleApp extends Frame{

	private static final long serialVersionUID = 1L;
	public EventHandleApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		setLayout(new FlowLayout());
		
		//UI 생성
		Button exit = new Button("EXIT");
		exit.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		add(exit);
		
		//이벤트 처리 객체 등록
		exit.addActionListener(new EventHandle());
		
		
		setBounds(800,200,300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventHandleApp eventHandleApp = new EventHandleApp("Event");
		
		
	}
}

//이벤트 처리기능을 제공하기 위한 클래스 - Listener 인터페이스를 상속 받음.
class EventHandle implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {  // 이벤트 처리명령을 작성하기 위한 메서드
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
}
