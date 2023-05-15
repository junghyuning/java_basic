package jdbc;

import java.sql.Statement;
import java.util.BitSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc08_SelectStudentApp {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			stmt = con.createStatement();
			String selectSql = "Select * from student order by no";
			//검색한 행의 객체를 반환받음.
			rs =stmt.executeQuery(selectSql);  // 검색결과를 2차원 테이블 형식으로 반환받음
			if(rs.next()) {
				System.out.println("[message] 검색된 학생정보가 있습니다.");
				//ResultSet 객체를 처리하기 위한 반복문 -> 검색행의 갯수가 불확실하므로 while구문 이용할 것.
				//if 구문에서 ResultSet 커서를 다음행으로 이미 이동하였으므로 do-while 구문을 사용함.
				do {
					//ResultSet 커서가 위치한 처리행의 컬럼값을 하나씩 반환받아 저장
					//ResultSet.getXXX(int columnIndex) 또는 ResultSet.getXXX(String columnLabel)
					// => ResultSet 커서가 위치한 처리행의 컬럼값을 반환하는 메소드
					// => XXX는 컬럼값을 반환받기 위한 Java 자료형을 표현
					// => columnIndex : 검색행에서 검색대상을 순서대로 1부터 1씩 증가되는 정수값으로 표현 
					// => columnLabel : 검색행에서 검색대상의 이름을 문자열로 표현
					//int no=rs.getInt(1);
					int no=rs.getInt("no");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					Date birthday = rs.getDate("birthday");
					System.out.println("학번 : "+no);
					System.out.println("이름 : "+name);
					System.out.println("전화번호 : "+phone);
					System.out.println("주소 : "+address);
					System.out.println("생년월일 : "+birthday);
					
					
					System.out.println("===================================");
					
				}while(rs.next());
			}else {
				System.out.println("[message] 검색된 학생정보가 없습니다.");
			}

			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("oracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con != null) con.close();		
				
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
	}
}
