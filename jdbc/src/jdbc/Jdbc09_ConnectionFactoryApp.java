package jdbc;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc09_ConnectionFactoryApp {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			con=ConnectionFactory.getConnection();
			stmt=con.createStatement();
			String sql = "select deptno,dname,loc from dept order by deptno";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno")+", 부서이름 : "+rs.getString("dname")+", 부서위치 : "+rs.getString("loc"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.close(con, stmt, rs);
			System.out.println("connecion closed");
		}
	}
}
