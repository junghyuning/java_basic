<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("num")==null){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);	
		return;
	}
	int num = Integer.parseInt(request.getParameter("num"));
	int rows = AjaxCommentDAO.getDAO().deleteAjaxComment(num);
	

%>

<% if(rows>0) {//변경행이 있는 경우 %>
{"code":"success"}
<% } else {//변경행이 없는 경우 %>
{"code":"error"}
<% } %>