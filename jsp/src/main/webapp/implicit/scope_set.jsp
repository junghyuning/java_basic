<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//내장객체를 이용하여 객체를 속성값으로 저장
//속성명을 이용하여 속성값 구분 - 내장객체가 다른 경우 같은 이름의 속성명을 사용 가능
pageContext.setAttribute("pageName", "홍길동"); // 자기 자신만
request.setAttribute("requestName", "임꺽정"); //  자기자신 + 스레드가 이동된 JSP만
session.setAttribute("sessionName", "전우치"); // 클라이언트가 같은 모든 JSP 문서에서 sessionName 속성의 속성값으로 "전우치" 사용 가능
application.setAttribute("applicationName", "일지매");// 클라이언트에 상관없이 같은 WAS를 사용하는 모든 JSP 문서에서 속성값 "일지매" 사용 가능
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>객체의 사용 범위(Scope)</h1>
	<hr>
	<%
	//내장객체에 저장된 속성값을 속성명으로 구분하여 반환받아 저장.
	String pageName = (String) pageContext.getAttribute("pageName");
	String requestName = (String) request.getAttribute("requestName");
	String sessionName = (String)session.getAttribute("sessionName");
	String applicationName = (String)application.getAttribute("applicationName");
	%>
	
	<p> pageName = <%=pageName %>
	<p> requestName = <%=requestName %>
	<p> sessionName = <%=sessionName %>
	<p> applicationName = <%=applicationName %>

</body>
</html>