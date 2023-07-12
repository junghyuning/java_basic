<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력값을 전달받아 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%
	//POST 방식으로 요청하여 리퀘스트 메세지 몸체부에 저장되는 값에 대한 캐릭터셋 변경
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Request Parameter</h1>
	<hr>
	<h2>EL 미사용</h2>
	<ul>
		<li>이름 :<%=request.getParameter("name") %>
		<li>주소 :<%=request.getParameter("address") %>
		<li>음식-1 :<%=request.getParameterValues("food")[0] %>
		<li>음식-2 :<%=request.getParameterValues("food")[1] %>
	</ul>
	<hr>
	<h2>EL 사용</h2>
	<ul>
		<li>이름 = ${param.name }</li>
		<li>주소 = ${param.address }</li>
		<li>음식-1 = ${paramValues.food}</li>
		<li>음식-1 = ${paramValues.food[0]}</li>
		<li>음식-2 = ${paramValues.food[1]}</li>
		
	</ul>
</body>
</html>