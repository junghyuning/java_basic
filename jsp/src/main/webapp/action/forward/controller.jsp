<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%-- 전달값을 이용하여 다른 JSP 문서로 포워드 이동하는 JSP 문서 --%>
<%
	String pageName= request.getParameter("pageName");

	if(pageName==null) {
		//클라이언트에게 URL 주소를 전달하여 응답 처리
		//=> URL 주소를 응답받은 클라이언트는 브라우저 요청 URL 주소를 변경하여 서버의 JSP 문서를 요청하여 실행결과(HTML 웹문서)를 응답밭아 출력
		//=> 리다이렉트 이동
		response.sendRedirect("main.jsp");
		return;
	}
	String contextPath = pageName +".jsp";
	System.out.println(contextPath);
%>
<%-- forward Tag : 요청 JSP 문서에서 다른 JSP 문서로 스레드가 이동하여 스레드가 이동된 JSP 문서로 응답 처리하기 위한 기능을 제공하는 태그--%> 
<jsp:forward page="<%=contextPath %>"/>