<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 템플릿 페이지를 구현한 JSP 문서 --%>
<%-- => 클라이언트의 모든 요청에 대한 응답 결과를 제공하는 JSP 문서 --%>
<%-- => 템플릿 페이지의 몸체부에는 클라이언트 요청에 의해 전달된 값을 이용하여 JSP 문서의 실행
결과를 제공받아 포함 --%>
<%
//쿼리스트링을 통해 전달받은 값을 getParameter로 가져옴..
	String group=request.getParameter("group");
	if(group==null) group="main";
	
	String worker=request.getParameter("worker");
	if(worker==null) worker="main_page";
	//포함시킬 페이지의 경로를 나타내는... 상대경로..?
	String contentPath=group+"/"+worker+".jsp";
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%-- 다른 페이지로 스레드를 이동하여 처리하고 돌아오는 인클루드 태그 --%>
	<%-- 헤더메인에는 다른 페이지로 이동할 수 있는 태그들이 존재 : 로그인 이용자와 비로그인 이용자에게 보여지는 화면이 달라야 함.--%>
	<div id="header">
		<jsp:include page="header_main.jsp"/>
	</div>
	
	<div id="content">
		<jsp:include page="<%=contentPath %>"/>
	</div>
	
	<div id="footer">
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>