package xyz.itwill.app;
//import 자동완성 -> ctrl+space // import 명령 정리 : ctrl + shift + O
//아이티윌 서브젝트 패키지의 오라클클래스만 사용하고 싶을시 - import xyz.itwill.subject.OracleSubject;
//아이티윌 서브젝트의 모든 클래스를 사용하고 싶을시 - import xyz.itwill.subject.*;
import xyz.itwill.subject.*;

//패키지: 같은 목적의 자료형(참조형)을 명확하게 구분하여 그룹화하기위해 사용함
//java 참조형 : class, interface, Enum
//java 자료형을 보다 쉽게 관리하기위해 패키지 사용.
// 도메인을 역방향으로 나열 - 그룹명을 지정하여 작성하는 것을 권장.
//ex) itwill.xyz : ehapdls >> xyz.itwill.board
//도메인(Domain) : 인터넷에 개인or 그룹이 사용하기위한 네트워크 식별자

//패키지에 작성된 소스파일의 처음 위치에는 소스파일이 작성된 패키지를 반드시 명확하게 작성
//형식)pakage 패키지 경로;
//=> Java 자료형이 어떤 패키지에서 선언된 자료형인지 명확하게 구분하여 사용

public class SubjectApp {
	public static void main(String[] args) {
		//다른패키지의 클래스 사용하고싶을시? => import 사용하여 넣아줌 => 클래스명까지 적을 시, 해당 클래스의 클래스명 생략하고도 사용 가능해짐
		OracleSubject oracleSubject = new OracleSubject();
		oracleSubject.display();
		
		//import사용x 시, 아래처럼 경로를 모두 적어줘야 함.
//		xyz.itwill.subject.OracleSubject subject1 = new xyz.itwill.subject.OracleSubject(); 
		JavaSubject javaSubject = new JavaSubject();
		javaSubject.display();

		//유니윌과, 아이티윌의 서브젝트의 클래스명이 같은 경우 원시적인 방법으로 해줘야함. (Import 사용 불가)
		xyz.uniwill.subject.JavaSubject javaSubject2 = new xyz.uniwill.subject.JavaSubject();
		javaSubject2.display();
		
	}
}
