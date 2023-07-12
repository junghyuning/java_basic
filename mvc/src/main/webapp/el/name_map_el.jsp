<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL-Map</h1>
	<hr>
	<%--  --%>
	<%-- <p>이름 = ${nameMap.first.name } ${nameMap.second.name }</p> --%>
	
	<p>이름 = ${nameMap["first.name"]}${nameMap["second.name"] }</p>

</body>
</html>