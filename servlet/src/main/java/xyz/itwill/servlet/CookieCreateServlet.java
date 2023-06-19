package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create.itwill")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// Cookie 객체 생성 : Cookie(Stirng name, String value)
		Cookie idCookie = new Cookie("id", "abc123");
		Cookie countCookie = new Cookie("count", "0");

		countCookie.setMaxAge(24 * 60 * 60);

		// 클라이언트에게 쿠키 전달 -> 클라이언트에서 요청이 발생하면, 서버에서 쿠키를 생성하여 클라이언트에 쿠키 부여
		//create.itwill 요청 발생 -> 쿠키 생성 및 추가 완료 
		response.addCookie(idCookie);
		response.addCookie(countCookie);

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키전달</h1>");
		out.println("<hr>");
		out.println("<p>네 안에 쿠키있다</p>");
		out.println("<hr>");
		//쿠키는 이미 저장된 상태 -> 단순히 read.itwill 페이지로 이동하는 링크
		out.println("<p><a href='read.itwill'>쿠키 읽기</a></p>");
		out.println("</body>");
		out.println("</html>");

	}
}
