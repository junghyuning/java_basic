package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(form.html)로부터 전달받은 값(회원정보)을 반환받아 클라이언트에게 전달하여 응답하는 서블릿
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter out = response.getWriter();

		// 서블릿을 GET 방식으로 요청한 경우 비정상적인 요청으로 클라이언트에게 에러코드를 반환하거나 에러페이지로 이동되도록 처리
		// HttpServletRequest.getMethod() : 서블릿을 요청한 요청방식(GET or POST)을 반환하는 메서드
		/*
		 * if(request.getMethod().equals("GET")) { //서블릿을 비정상적으로 요청한 경우
		 * 
		 * //HttpServletResponse.sendError(int src) : 클라이언트에게 에러코드 (4XX, 5XX)를 전달하여 응답하는
		 * 메서드 //=> 상태코드(StatusCode)는 HttpServletResponse 인터페이스의 정의된 상수 사용
		 * //response.sendError(405);
		 * response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400
		 * //response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//405
		 * 
		 * return;
		 * 
		 * 
		 * 
		 * //HttpServletResponse.sendRedirect(String url) : 클라이언트에게 301상태코드와 URL 주소를
		 * 전달하여 응답 //301 상태코드 = 재요청 (=>클라이언트는 전달받은 URL 주소로 브라우저의 요청 URL을 변경하여 재요청)
		 * //요청하여 실행결과를 응답받아 출력 - 페이지 이동(redirect 이동)
		 * response.sendRedirect("error.html"); //에러 발생시 해당 페이지로 이동
		 * //response.sendRedirect("form.html"); //에러 발생시 해당 페이지로 이동
		 * 
		 * return;
		 * 
		 * 
		 * out.println("<script type ='text/javascript'>");
		 * out.println("alert('비정상적으로 페이지를 요청하였습니다.');");
		 * out.println("location.href='form.html';"); out.println("</script>");
		 * 
		 * 
		 * }
		 */

		// 서블릿을 post 방식으로 요청한 경우, 사용자 입력값을 리퀘스트 메세지 몸체부에 저장하여 전달
		// => 리퀘스트 메세지 몸체부에 저장된 값의 기본 문자 형태가 ISO-8859-1(서유럽어가 default)
		// => 반환받기 전에 리퀘스트 메세지 몸체부에 저장되어 전달되는 값에대한 인코딩 값(charset 속성값) 변경
		// => GET방식으로 요청한 경우 body 부를 사용하지 않으므로 메서드 사용x
		request.setCharacterEncoding("utf-8");

		// 서블릿을 요청할 때 전달된 값을 반환받아 저장
		// HttpServletRequest.getParameter(String name) : 매개변수로 전달된 이름의 전달값을 문자열로 반환하는
		// 메서드

		// -> 매개변수의 이름으로 전달된 값이 없는 경우 [null] 반환
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		// 동일한이름으로 전달되는 다수의 값이 있는 경우, getParameter()는 첫번째 전달값만 반환받아 저장 함.
		// => getParameterValues() 사용할 것.
		String[] hobby = request.getParameterValues("hobby");
		String job = request.getParameter("job");
		String profile = request.getParameter("profile");

		// 입력값 검증 - but 이미 자스에서 검증했기때문에 꼭 할필요가 없는데도 하는이유
		// ==> 보안 때문
		/*
		 * if(id==null || id.equals("")) { // 전달값이 없는 경우 - 비정상 요청
		 * response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400 return; }
		 * 
		 * if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) { //전달값이 패턴에 맞지 않는 경우 - 비정상
		 * 요청 response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400 return; }
		 */
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원가입확인</h1>");
		out.println("<hr>");
		out.println("<p>아이디 = " + id + "</p>");
		out.println("<p>비밀번호 = " + passwd + "</p>");
		out.println("<p>이름 = " + name + "</p>");
		out.println("<p>이메일 = " + email + "</p>");
		out.println("<p>성별 = " + gender + "</p>");
		out.println("<p>취미 = "); 
		for(int i =0; i<hobby.length; i++) {
			out.println(hobby[i]);  //실제 출력값이 아니고 html태그에 대한 출력값이므로 println 써도 무방함.
			if(i < hobby.length-1) {
				out.println(", ");
			}
		}
		out.println("</p>");
		out.println("<p>직업 = " + job + "</p>");
		//엔터는 브라우저에서 실행되지 않는 문자이므로 <br> 태그로 변환해야만 줄바꿈 발생.
		out.println("<p>자기소개 = " + profile.replace("\n", "<br>") + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
