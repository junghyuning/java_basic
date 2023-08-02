package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Model 기능을 제공하는 클래스가 반드시 상속받아야하는 인터페이스
// => 모든 Model 클래스에 동일한 메서드가 작성되도록 규칙 제공
// => Controller에서 Model 기능의 클래스의 객체로 요청처리 메서드를 쉽게 호출하여 사용하기 위한 필요
public interface Controller {
	//모든 Model 기능의 클래스에서 반드시 작성할 요청처리 메서드를 추상 메서드로 선언
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
