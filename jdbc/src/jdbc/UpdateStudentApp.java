package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Student 테이블에 저장된 학생 정보 중 학번이 2000인 학생의 이름을 임걱정으로 변경하고 주소를 부천시 원미구로 변경하는 JDBC프로그램 작성

public class UpdateStudentApp {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //OracleDriver 객체 생성 및 DriverManager에 등록
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password="tiger";
			con = DriverManager.getConnection(url,user,password); // DB와 연결(접속)
			
			stmt = con.createStatement(); //Statement = sql명령을 전달할 수 있는 객체 
			//con은 db와 접속된 객체이므로 con.createStatement로 생성된 Statement 객체는 db에 접근하여 명령을 전달할 수 있는 상태임) 
			
			String updateSql = "Update student set name='임걱정', address='부천시 원미구' where no=2000"; //Statement가 전달하게 할 명령
			String updateNo = "Update student set no='1000'where name='홍길동'"; //Statement가 전달하게 할 명령
			stmt.execute(updateNo);
			// 명령이 수행되었는지 확인
			int rows = stmt.executeUpdate(updateSql);
			
			System.out.println("[메세지]"+rows+"명의 학생정보를 수정하였습니다.");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("[error]Can not found Oracle Driver Class");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[error] JDBC error : " + e.getMessage());
		}finally { 
			//관련객체 모두 해제
			try {
				if(stmt!=null)stmt.close();
				//접속해제
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
