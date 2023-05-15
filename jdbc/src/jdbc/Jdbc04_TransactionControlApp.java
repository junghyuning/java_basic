package jdbc;

import java.sql.Statement;

import oracle.jdbc.proxy.annotation.GetCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//jdbc프로그램의 경우, 기본적으로 AutoCommit 기능이 활성화 돼있음 => DML이라도 자동으로 commit 됨

//
public class Jdbc04_TransactionControlApp {
	public static void main(String[] args) {
		//student 테이블에 저장된 학생 정보 중 학번이 2000인 학생의 이름을 임꺽정으로 변경하는 jdbc 프로그램 작성
		Connection con= null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con = DriverManager.getConnection(url,user,password);
			
			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			String sql = "update student set name = '임꺽정' where no =2000";
			int rows = stmt.executeUpdate(sql);
			if(rows>0) {//조작이 있는 경우
				System.out.println("[메세지] "+rows+"명의 학생정보를 변경 하였습니다.");
			}else {
				System.out.println("[메세지]변경처리할 학번의 학생정보를 찾을 수 없습니다.");
			}
			
			//커밋처리하는 메서드. Connect.commit(); 
			con.commit();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println("예기치 못한 오류 발생");
			try {
				con.rollback(); //예외발생시 commit이 되지 않고 rollback 수행.
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}finally {
			try {
				if(stmt!=null) stmt.close();
				//접속해제
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
