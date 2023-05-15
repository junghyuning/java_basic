package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//STUDENT 테이블에 저장된 학생정보 중 학번이 [3000]인 학생정보를 삭제하는 JDBC 프로그램 작성
public class Jdbc07_DeleteStudentApp {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // OracleDriver Class 객체를 생성하고 데이터메니저에 등록함
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url,user,password); //DataManager에 객체를 등록 했으니, url, user, password 사용해 실제로 연결
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String delSql = "Delete from student where no=3000";
			System.out.println("삭제한 행 : "+stmt.executeUpdate(delSql));
			con.commit();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Oracle Driver Class 를 찾을 수 없음.");
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}