package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트에 저장된 모든 쿠키를 삭제하고 실행결과를 전달하여 응답하는 서블릿

@WebServlet("/remove.itwill")
public class CookieRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {  //전달받은 쿠키가 존재하는 경우
			for(Cookie cookie : cookies) {
				//클라이언트에서 전달받은 쿠키의 유지시간을 0으로 변경 -> 클라이언트에 전달
				cookie.setMaxAge(0);
				response.addCookie(cookie); //유지시간을 0으로 변경한 쿠키를 클라이언트에 다시 전달함으로써 자동소멸되도록 함.
			}
		}
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 삭제</h1>");
		out.println("<hr>");
		out.println("<p>네 안에 쿠키 없다.</p>");
		out.println("<hr>");
		out.println("<p><a href='read.itwill'>쿠키 읽기</a></p>");
		out.println("</body>");
		out.println("</html>");

	}

}
