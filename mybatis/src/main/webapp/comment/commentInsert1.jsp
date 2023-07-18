<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="xyz.itwill.dto.MyComment1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyComment1 comment1 = new MyComment1();
	comment1.setCommentId("abc"); 
	comment1.setCommentContent("첫번째 게시글 입니다.");
	MyCommentDAO.getCommentDAO().insertComment(comment1);
	MyComment1 comment2 = new MyComment1();
	comment2.setCommentId("xyz"); 
	comment2.setCommentContent("두번째 게시글 입니다.");
	MyCommentDAO.getCommentDAO().insertComment(comment2);
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