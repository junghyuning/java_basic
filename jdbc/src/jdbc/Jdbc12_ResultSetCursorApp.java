package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc12_ResultSetCursorApp {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		String sql = "select * from student order by no";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름"+rs.getString("name"));
		}
		System.out.println("=================================");
		//createStatement의 속성값 설정에 따라 커서의 이동이 자유로워 짐 -> 위의 값과 비교 가능
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		sql = "select * from student order by no";
		rs = stmt.executeQuery(sql);
		rs.first();
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름"+rs.getString("name"));
		
		rs.last();
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름"+rs.getString("name"));
		
		rs.absolute(2); // cursor가 2행에 위치하게 됨.
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름"+rs.getString("name"));
		System.out.println("=================================");

		
		
		ConnectionFactory.close(con, stmt, rs);
	}
}
