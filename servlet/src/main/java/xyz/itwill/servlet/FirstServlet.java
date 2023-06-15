package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */

// @WebServlet(name="first", value="/first.itwill")
@WebServlet("/first.itwill")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#1 클라이언트에게 요청에 대한 실행결과를 파일로 제공하기 위한 파일 형태 + 응답파일 생성을 위한 출력 스트림 반환받기
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //response 가 실행결과 저장을 위한 객체 이므로 response가 해당 수단을 제공하는 것.
		
		//#2 요청에 대한 처리 명령 및 처리결과를 저장할 응답파일 생성
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		//SimpleDateFormat 객체의 format() 메서드를 호출하여 매개변수로 전달받은 Date 객체를 해당 패턴의 문자열로 변환하여 반환
		String displayNow = dateFormat.format(now);
	
		
		//#3 실행결과를 저장한 응답파일 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("<style type = 'text/css'>");
		out.println("p{");
		out.println("width: 600px;");
		out.println("margin: 0 auto;");
		out.println("font-size: 2em;");
		out.println("font-weight: bold;");
		out.println("text-align: center;");
		out.println("border: 1px solid black");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿 시계</h1>");
		out.println("<hr>");
		out.println("<p>"+displayNow+"</p>");
		out.println("<script type ='text/javascript'>");
		out.println("setInterval(function(){");
		out.println("location.reload();");
		out.println("},1000);");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

}
