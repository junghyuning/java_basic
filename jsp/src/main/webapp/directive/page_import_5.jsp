<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%-- page 디렉티브에서 다른 속성값이 저장된 동일한 속성을 여러번 선언할 경우, 에러 발생
=> but, import 속성은 예외 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page contentType="text/html; charset=UTF-84" %>
<%
	List<String> nameList = new ArrayList<>();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	text-align: center;
	width: 200px;
	padding: 2px;
}
</style>
</head>
<body>
	<h1>page Directive - import 속성</h1>
	<hr>
	<p>page Directive의 import 속성에는 JSP 문서에서 사용할 클래스 또는 인터페이슬르 속성값으로 설정
	- 클래스 or 인터페이스를 패키지를 사용하여 명확하게 표현하여 제공하기 위한 사용</p>
	<hr>
	<% for(String name : nameList) { %>
		<li><%=name %></li>		
	<% } %>
</body>
</html>