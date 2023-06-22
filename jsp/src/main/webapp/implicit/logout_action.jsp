<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--로그아웃 처리 후 [login_form.jsp] 문서를 요청할 수 있는 URL 주소를 처리하여 응답 --%>
    <%-- => 로그아웃 처리 : 권한 관련 정보가 저장된 객체를 세션에서 삭제 처리 --%>
<%
	//session.remobeAttrubute("loginId");

	//session.invalidate() : 클라이언트의 정보(JSESSIONID 쿠키)로 바인딩 된 세션(session)을 삭제하는 메서드 -> 세션 언바인딩 처리
	session.invalidate(); // 이렇게 처리할 경우 기존의 세션은 만료되고 새로운 요청 시 새로운 session과 sessionID를 부여받아 사용하는 것.
	
	response.sendRedirect("login_form.jsp");
%>