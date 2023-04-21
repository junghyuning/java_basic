package xyz.itwill.awt;

import java.awt.Frame;

//CUI : character User Interface : 문자 중심의 실행 환경에서 동작되는 프로그램
//GUI : Graphic User Interface : 그랙픽 중심 실행환경에서 동작되는 프로그램
//=> 컴포넌트(위젯)(요소,부품) 이용해 작성된 program
//java.awt 패키지 : GUI 프로그램을 작성하기 위한 클래스가 선언된 패키지
//=> 운영체에(OS)에 종속된 컴포넌트 제공
//javax.swing 패키지 : awt의 확장 패키지 (GUI 프로그램을 작성하기 위한 클래스가 선언)

//컴포넌트 : GUI프로그램에서 사용자 환경을 구현하기 위한 클래스
//=> button , List, Labl, Canvas, Checkbox, Scrollbar, TextField, TextArea
//컨테이너 클래스 : 컴포넌트를 매치할 수 있는 컴포넌트.
//=> 독립적 컨테이너 : Frame (창) / Window (메뉴가 없는 창) / Dialog (안내창, 도움말 창, 파일 불러오기 창)
//=> 종속적 컨테이너 : Panel, Applet
public class FrameOneApp {
	public static void main(String[] args) {
		//Frame 클래스 : 메뉴가 존재하는 컨테이너를 생성하기 위한 클래스
		Frame frame=new Frame("프레임 연습");
		
		//Component.setSize(int width, int height) : 컴퍼넌트의 크기를 변경하는 메소드
		// => GUI 프로그램에서 크기 또는 위치는 픽셀(Pixel)을 기본단위로 표현하여 설정
		//픽셀(Pixel) : 하나의 색으로 표현하는 점(Dot)
		frame.setSize(400, 300);
		
		//Component.setLocation(int x, int y) : 컴퍼넌트의 출력 위치를 변경하는 메소드
		frame.setLocation(600,100);
		
		//크기변경 가능 불가능
		frame.setResizable(false);
		//Component.setVisible(boolean b) : 컴퍼넌트를 보여지 않게 처리하거나 보이도록 
		//처리하는 메소드 - false : 보여지 않도록 처리, true : 보여지도록 처리 
		frame.setVisible(true);
		
		
		
	}
}
