<%@page import="javax.websocket.Decoder.Text"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="page_error_7.jsp"%> --%>
	<!-- web.xml파일에서 에러처리 영역에서 에러 페이지를 지정했으므로 따로 지정하지 않아도 괜찮음  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String text = "ABCDEFG";
	/* 널포인터 익셉션 발생 */
	//String text=null;
	
	//int su=10/0;
	/* 400에러 발생 */
	/* if(request.getMethod().equals("GET")){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return; 
	}*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - errorPage 속성</h1>
	<hr>
	<p>page Directive의 errorPage 속성에는 JSP 문서 실행 시 에러(예외)가 발생될 경우 
	클라이언트에게 500 상태코드 대신, 에러페이지로 응답하기 위한 
	웹문서의 URL 주소를 속성값으로 설정</p>
	<hr>
	<%-- <p>문자열의 문자 갯수 = <%=text.length() %> --%>
</body>
</html>