<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디 검색 관련 정보를 전달받아 MEMBER 테이블에 저장된 회원정보의 아이디를 검색하여
클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%
 String name = request.getParameter("name");
 System.out.println(name);
 String email = request.getParameter("email");
 
/*  MemberDTO member = MemberDAO.getDAO().nameSelectMember(name, email);
 if(member == null || member.getMemberStatus()==0 ){
	 session.setAttribute("message", "일치하는 회원 정보가 없습니다.");
	 session.setAttribute("name", name);
	 session.setAttribute("email", email);
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/index.jsp?group=member&worker=search_id'");
	out.println("</script>");
	 return;
 }
  String id = member.getId(); */
  
  
  //방법2
  MemberDTO member = new MemberDTO();
  member.setName(name);
  member.setEmail(email); 
	
  String id = MemberDAO.getDAO().selectMemberId(member);

%>
<h1>아이디 검색 결과</h1>
<p style="font-size: 1.5em;"><%=name %>님의 아이디는 [<%=id %>] 입니다.</p>