package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

//Apache 그룹에서 제공하는 DBCP 라이브러리 클래스를 이용하여 DBCP 객체를 생성하여 Connection 객체를 제공받아 COnnection 객체의 정보를 클라이언트에게 전달하여 응답하는 서블릿
@WebServlet("/dbcp.itwill")
public class DataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//BasicDataSource 객체(DataSource 객체) 생성
		BasicDataSource dataSource = new BasicDataSource();
		//클래스를 JDBC 드라이버로 등록
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		dataSource.setInitialSize(10);//최초 생성될 connection 객체의 개수 변경
		dataSource.setMaxIdle(10);//대기 상태의 connection 객체의 갯수 변경
		dataSource.setMaxTotal(15);//최대 생성 가능한 
		
		

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>DBCP (DataBase Connection Pool)</h1>");
		out.println("<hr>");
		try {
			Connection con = dataSource.getConnection();
			out.println("<p>con = "+con+"</p>");
			out.println("<hr>");
			out.println("<p>Idle Connection Number = " + dataSource.getNumIdle()+"</p>");
			out.println("<p>Active Connection Number = " + dataSource.getNumActive()+"</p>");
			out.println("<hr>");
			out.println("<h3>Connection 객체 제거 후</h3>");
			con.close();
			out.println("<p>Idle Connection Number = " + dataSource.getNumIdle()+"</p>");
			out.println("<p>Active Connection Number = " + dataSource.getNumActive()+"</p>");
			dataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");

	}

}
