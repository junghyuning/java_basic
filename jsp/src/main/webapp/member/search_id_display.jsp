<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디 검색 관련 정보를 전달받아 MEMBER 테이블에 저장된 회원정보의 아이디를 검색하여
클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%
 System.out.println("서치디스플레이");
 String name = request.getParameter("name");
 String email = request.getParameter("email");
 
 MemberDTO member = MemberDAO.getDAO().nameSelectMember(name, email);
 if(member == null || member.getMemberStatus()==0 ){
	 session.setAttribute("message", "일치하는 회원 정보가 없습니다.");
	 response.sendRedirect("member/search_id.jsp");
	 return;
 }
 

%>
<h1>아이디 검색 결과</h1>
<p style="font-size: 1.5em;"><%=name %>님의 아이디는 [<%=member.getId() %>] 입니다.</p>