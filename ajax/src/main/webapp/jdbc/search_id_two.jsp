<%@page import="xyz.itwill.dto.AjaxMemberDTO"%>
<%@page import="xyz.itwill.dao.AjaxMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름과 이메일을 전달받아 AJAX_Member 테이블에 저장된 회원정보의 아이디를 검색하여 XML 데이터로 응답하는 JSP 문서 --%>
<%
	if(request.getMethod().equals("GET")){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	AjaxMemberDTO ajaxMember = new AjaxMemberDTO();
	ajaxMember.setName(name);
	ajaxMember.setEmail(email);
	String id = AjaxMemberDAO.getDAO().selectAjaxMemberId(ajaxMember);
			
%>
<result>
	<% if(id!=null) { %>
	<code>success</code>
		<id><%=id %></id>
	<% } else { %>
	<code>empty</code>
		<% } %>
</result>