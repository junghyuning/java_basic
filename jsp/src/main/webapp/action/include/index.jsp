<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//request객체의 인코딩 값 지정.
request.setCharacterEncoding("utf-8");
//JSP 문서 요청시 전달된 값을 반환받아 저장
String category = request.getParameter("category");

if (category == null) { //전달값이 없는 경우
	category = "mail";
}
String headerPath = ""; //Header 영역에 포함될 파일의 경로를 저장하기 위한 변수 
String master = ""; //페이지 관리자의 정보를 저장하기 위한 변수

// 전달값을 비교하여 Header 영역에 포함될 파일의 경로 구분하여 저장
if (category.equals("mail")) {
	headerPath = "header_mail.jsp";
	master = "홍길동(hong@itwill.xyz)";
} else if (category.equals("blog")) {
	headerPath = "header_blog.jsp";
	master = "임꺽정(lim@itwill.xyz)";
} else if (category.equals("cafe")) {
	headerPath = "header_cafe.jsp";
	master = "전우치(jeon@itwill.xyz)";
} else {
	response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	return;
}

//Content 영역에 포함될 파일의 경로를 저장하기 위한 옵션
String contentPath = category + ".jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%-- Header 영역 --%>
	<%-- 	<h1>메일페이지</h1>
	<a href = "index.jsp?category=mail">메일(Mail)</a>&nbsp;&nbsp;
	<a href = "index.jsp?category=blog">블로그(Blog)</a>&nbsp;&nbsp;
	<a href = "index.jsp?category=cafe">카페(Cafe)</a>&nbsp;&nbsp;
	<hr> --%>
	<%-- <%@include file = "header.jspf" %>
	<%@include file=”<%=headerPath%>”%> => 불가능한 형태
	 --%>
	<%-- include Tag : 요청 JSP 문서에서 다른 JSP 문서로 스레드를 이동하여 실행하고 실행결과를 가져와 요청 JSP 문서에 포함하는 태그 --%>
	<%-- 형식) <jsp:include path="JSP 문서의 경로"></jsp:include> --%>
	<%-- <jsp:include page="header.jsp"></jsp:include>--%>
	<!-- 동적 포함  -->
	<jsp:include page="<%=headerPath%>" />


	<%-- Content 영역 --%>
	<jsp:include page="<%=contentPath%>" />

	<!-- <p>메일관련 정보가 출력됩니다.</p>
	<p>메일관련 정보가 출력됩니다.</p>
	<p>메일관련 정보가 출력됩니다.</p>
	<p>메일관련 정보가 출력됩니다.</p>
	<p>메일관련 정보가 출력됩니다.</p> -->

	<%-- Footer 영역 --%>
	<%--
	<hr>
	<p>Copyright ⓒ Itwill Corp. All rights reserved.</p>
	<p>관리자 : 홍길동( hong@itwill.xyz)
	 --%>
	<%-- <p>관리자 : <%=master %></p> --%>
	<%-- include 태그와 forward 태그의 하위 태그로 param 태그를 제외한 문장이 존재할 경우, 에러 발생 - 주석 및 enter도 불가능 --%>
	<jsp:include page="footer.jsp">
		<jsp:param value="<%=master%>" name="master" />
	</jsp:include>
</body>
</html>