<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 학생정보를 전달받아 Student 테이블의 행으로 삽입하고 [displayStudent.jsp] 문서를 요청할 수 있는 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서--%>
<%
if (request.getMethod().equals("GET")) {
	session.setAttribute("message", "비정상적인 방법으로 페이지를 요청하였습니다.");
	response.sendRedirect("insertFormStudent.jsp");
	return;
}
//전달값에 대한 캐릭터셋 변경 - POST방식으로 요청받았을 때만 가능
request.setCharacterEncoding("UTF-8");

//전달값을 반환받아 변수에 저장
int no = Integer.parseInt(request.getParameter("no"));
String name = request.getParameter("name");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String birthday = request.getParameter("birthday");

StudentDTO student = new StudentDTO();
student.setNo(no);
student.setName(name);
student.setPhone(phone);
student.setAddress(address);
student.setBirthday(birthday);
//사용자로부터 입력받아 전달된 학생번호가 STUDENT 테이블에 저장된 기존 학생 정보의 학생번호와 중복될 경우 다시 form으로 이동
//=> 학생번호를 전달받아 Student 테이블에 저장된 학생 번호를 검색하여 DTO 객체로 반환하는 DAO  클래스의 메소드 호출
if(StudentDAO.getDAO().selectStudent(no)!=null){
	session.setAttribute("message", "이미 존재하는 학생번호를 입력하였습니다.");
	session.setAttribute("student", student); // 검색된 학생정보에대한 DTO 객체를 반환.
	response.sendRedirect("insertFormStudent.jsp");
	return;
}

//학생정보를 전달받아 STUDENT 테이블의 행으로 삽입하는 DAO 클래스의 메서드
StudentDAO.getDAO().insertStudent(student);

response.sendRedirect("displayStudent.jsp");
%>
