<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<style type="text/css">
#header {
	border: 2px solid red;
	height: 150px;
	margin: 10px;
	padding: 10px;
	text-align: center;
}

#content {
	border: 2px solid blue;
	height: 150px;
	margin: 10px;
	padding: 10px;
	text-align: center;
}
#footer {
	border: 2px solid blue;
	height: 150px;
	margin: 10px;
	padding: 10px;
	text-align: center;
}
</style>
</head>
<body>
	<div id="header">
		<%-- insertAttribute 태그 : TilesView 프로그램의 환경설정파일에서 put-attribute 엘리먼트에 제공된
		JSP 문서의 실행결과를 제공받아 삽입하기위한 태그  --%>
		<tiles:insertAttribute name="header"/>
	</div>

</body>
</html>