<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="xyz.itwill.dto.MyComment1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyComment1 comment3 = new MyComment1();
	comment3.setCommentId("opq"); 
	comment3.setCommentContent("세번째 게시글 입니다.");
	MyCommentDAO.getCommentDAO().insertComment(comment3);
	MyComment1 comment4 = new MyComment1();
	comment4.setCommentId("abc"); 
	comment4.setCommentContent("네번째 게시글 입니다.");
	MyCommentDAO.getCommentDAO().insertComment(comment4);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<hr>
	<p> 게시글 등록이 성공하였습니다.</p>
</body>
</html>