<!--디렉티브 : 지시어 -->
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//Java 명령 작성
Date now = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat();
String displayNow = dateFormat.format(now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
#displayDiv {
	width: 600px;
	margin: 0 auto;
	padding: 30px 0;
	font-size: 2em;
	font-weight: bold;
	text-align: center;
	border: 2px solid black;
}
</style>
</head>
<body>
	<h1>Hello, JSP!!!</h1>
	<hr>
	<!-- HTML 주석 : 주석문이 클라이언트에게 전달 - 소스보기 가능 -->
	<%-- JSP 주석 : 주석문이 클라이언트에게 미전달 - 소스보기 불가능 --%>
	<p>JSP(Java Server Pages) : 서블릿보다 쉽게 웹 프로그램을 작성하기 위한 기술 - 스크립트
		요소(Script Element), 지시어(Directive), 표준 액션 태그(Standard Action Tag)</p>
	<hr>
	<!-- 스크립트 요소<% %> -->
	<div id="displatDiv"><%=displayNow%></div>
	
	<script type="text/javascript">
		setInterval(function() {
			location.reload();
		},1000);
	</script>
</body>
</html>