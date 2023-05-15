package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc14_PreparedStatement2 {
	public static void main(String[] args) throws IOException, SQLException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("<<학생정보입력>>");
		System.out.print("이름 >> ");
		String name = in.readLine();
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "select * from student where name = ? order by no";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name); //첫번째 인파라메터에 변수 name 을 저장.
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("학번 : "+ rs.getInt("no")+", 이름 : "+rs.getString("name")+", 전화번호 : "+rs.getString("phone")+", 주소 : "+rs.getString("address")+", 생일 : "+rs.getString("birthday").substring(0,10));
		}
	
		ConnectionFactory.close(con, pstmt, rs);
	}
}
