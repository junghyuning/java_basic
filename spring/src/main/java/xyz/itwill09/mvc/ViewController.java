package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member = new Member("test", "홍길동", "서울시 종로구");
		request.setAttribute("member", member);
		
		return "member_view";
	}
	
	
}
