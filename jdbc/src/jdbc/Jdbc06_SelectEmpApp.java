package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//emp 테이블에 저장된 모든 사원 정보의 empno,ename,sal / order by sal desc => 검색 및 출력
public class Jdbc06_SelectEmpApp {
	public static void main(String[] args) {
		Connection con = null; //연결 객체
		Statement stmt = null; // con으로부터 연결객체를 생성받아 sql에 명령을 전달하는 객체
		ResultSet rs = null; // select 명령문의 결과 객체를 저장하는 객체

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 객체 생성 및 등록
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			String selectSql = "select empno,ename,sal from emp order by sal desc";
			rs = stmt.executeQuery(selectSql);
			int count = 0;
			while (rs.next()) {//검색 테이블에서 다음행으로 이동하는 명령어
				int empno = rs.getInt("empno");
				int sal = rs.getInt("sal");
				String ename = rs.getString("ename");

				System.out.println("사원번호 : " + empno);
				System.out.println("사원이름 : " + ename);
				System.out.println("급료 : " + sal);
				System.out.println("=============================");
				count++;
			}
			System.out.println("총 인원 :"+ count);
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(rs != null) rs.close();
				if(con != null) con.close();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
