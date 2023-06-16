package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session.itwill")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		
		//HttpServletRequest.getSession() : 바인딩 처리된 세션(Session객체)을 반환하는 메서드
		//=> 새로운 세션을 생성하여 바인딩 or 기존 세션으 트래킹하여 바인딩 처리함
		
		HttpSession session = request.getSession();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>세션(Session)</h1>");
		out.println("<hr>");
		if(session.isNew()) {
			out.println("<p>세션을 생성하여 바인딩하였습니다.</p>");
		} else {
			out.println("<p>세션을 트랙킹하여 바인딩하였습니다.</p>");
		}
		
		out.println("<p>세션 고유값(SessionId) = " +session.getId()+"</p>");
		//session.getMaxInactiveInterval() : 세션 유지시간 (초)
		//세션을 장시간 사용하지 않을 경우 서버에 부담이 크므로 
		//=> 세션이 자동으로 소멸되도록 설정하는 시간 
		out.println("<p>세션 유지시간 = " +session.getMaxInactiveInterval()+"</p>");
		
		session.setAttribute("now", new Date());
		Date now = (Date)session.getAttribute("now");
		out.println("<p>객체에 저장된 속성값(객체) = "+now+"</p>");
		
		session.removeAttribute("now");
		
		session.invalidate();
		
		out.println("<hr>");
		out.println("</body>");
		out.println("</html>");

	}

}
