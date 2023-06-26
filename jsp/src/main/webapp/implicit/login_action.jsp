<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%-- 인증 정보(id&pwd)를 전달받아 로그인 처리하기 위한 JSP 문서 --%>
   <%-- 인증 성공 : 전달받은 아이디와 비밀번호가 올바른 경우  --%>
   <%-- => 세션에 권한 관련 정보가 저장된 객체를 저장 = 로그인 --%>
   <%-- => [login_user.jsp]로 연결 --%>
   <%-- 인증 실패 : 전달받은 아이디와 비밀번호가 올바르지 않은 경우  --%>
   <%-- => [login_form.jsp]로 연결 --%>
<%
	//request.getMethod(): 웹 자원을 요청한 요청방식(GET or POST)을 반환하는 메서드
	if(request.getMethod().equals("GET")){
		/* response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//405에러 반환
		return; 에러 페이지 반환*/
		String message = URLEncoder.encode("비정상적인 방법으로 페이지를 요청하였습니다.", "utf-8"); 
		//redirectURL. 반환
		response.sendRedirect("login_form.jsp?message="+message);
		return;
	}

	//리퀘스트 메세지 몸체부에 저장되어 전달되어 전달된는 값에 대한 문자형태
	//데이터를 전달받아 처리하기 전에 문자를 처리할 인코딩 정보를 설정하는 것.
	request.setCharacterEncoding("utf-8");
	
	//request.getParameter(String name) : 전달값을 문자열(String 객체)로 반환하는 메서드
	//=> 매개변수로 전달받은 이름의 전달값이 없는 경우 null 반환
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	//인증 실패
	if(!id.equals("abc123") || !passwd.equals("123456")){
		session.setAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
		session.setAttribute("id", id);
		response.sendRedirect("login_form.jsp");
		return;
	}
	//인증 성공
	session.setAttribute("loginId", id);
	response.sendRedirect("login_user.jsp");
	

%>