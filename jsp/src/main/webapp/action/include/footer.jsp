<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%-- 요청 JSP 문서에서 스레드가 이동되어 실행되는 JSP 문서의 request 객체와 
	response 객체를 전달받아 사용
	
	=> footer.jsp는 index.jsp의 request, response 객체를 빌려와 사용하는 형태이므로 사용에 제한이 있음.
	
	 --%>
	
	<%
	//request 객체의 사용에 제약이 있기 때문에,,, request객체의 정보를 반환받아 사용할 수는 있어도
	//객체 정보를 "변경"하는 것은 불가능 (ex. setCharacterEncoding)
	//request.setCharacterEncoding("utf-8");
	String master = request.getParameter("master");  //<jsp: param>태그의 매개변수값을 받아오는 것.
	
	
	//스레드가 이동되어 실행되는 JSP 문서에서는 response객체에 실행결과를 포함하여 요청 JSP 문서에 전달할 수 있지만,
	//클라이언트에게 에러코드나 URL 주소를 직접 전달하여 응답하는 것은 불가능
	//=> 클라이언트에게 에러코드나 URL 주소를 전달할 경우 JavaScript 이용
	if(master==null){
		//response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		response.sendRedirect("../standard_action.jsp");
		return;
	}
	
	%>
	<%--footer영역 --%>
	<hr>
	<p>Copyright ⓒ Itwill Corp. All rights reserved.</p>
	<p>관리자 : <%=master %></p>
