package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc10_ExecuteApp {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		String sql1 ="update student set name ='임걱정' where no =2000";
		int row = stmt.executeUpdate(sql1);
		System.out.println("[message]"+row+"명의 학생정보를 변경 하였습니다.");
		System.out.println("========================================================");
		String sql2="select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
		while(rs.next()) {
			System.out.println("학번 : "+rs.getInt("no")+", 이름 : " + rs.getString("name"));
		}
		System.out.println("========================================================");
		int choice = 1;
		String sql="";
		if(choice==1) {
			sql="update student set name='임꺽정' where no=2000";
		}else {
			sql="select * from student order by no";
		}
		
		Boolean result = stmt.execute(sql);
		if(result) { // true인 경우, select 명령어
			ResultSet rs2 = stmt.getResultSet();
			while(rs2.next()) {
				System.out.println("학번 = "+rs.getInt("no")+"이름 : "+ rs.getString("name"));
			}
			ConnectionFactory.close(con,stmt,rs);
		} else { //select 제외 ddl, dml 명령이 실행된 경우.
			System.out.println("변경된 학생 정보 : "+stmt.getUpdateCount()+"행");
			ConnectionFactory.close(con, stmt);
		}
		
	}
}
