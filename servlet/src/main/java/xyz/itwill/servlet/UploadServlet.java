package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지에서 전달된 값과 파일명을 클라이언트에게 전달하여 응답하는 서블릿
//=> 전달파일은 서버 디렉토리에 저장 = 파일 업로드 처리
@WebServlet("/upload.itwill")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("fileupload.html");
		}
		
		request.setCharacterEncoding("utf-8");
		
		String uploader = request.getParameter("uploader");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파일업로드</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = " + uploader + "</p>");
		
	}

}
