package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc14_PreparedStatementApp {
	public static void main(String[] args) throws IOException, SQLException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// system.in -> InputStreamReader -> buffered reader 확장

		// 학생정보 입력받아 저장
		System.out.println("학생정보입력");
		System.out.print("학번 입력 >>");
		int no = Integer.parseInt(in.readLine()); // String으로 입력받아 integer로 변환.
		System.out.print("이름 입력 >>");
		String name = in.readLine();
		System.out.print("전화번호 입력 >>");
		String phone = in.readLine();
		System.out.print("주소 입력 >>");
		String address = in.readLine();
		System.out.print("생년월일 입력 >>");
		String birthday = in.readLine();
		System.out.println("=====================================");
		Connection con = ConnectionFactory.getConnection();
		/*
		 PreparedStatement에 저장되는 명령에는 ?(InParameter) 기호를 사용 
		 ex) insert into student(?,?,?,?,?); 
		 Inparameter : java변수값을 제공받아 sql 명령의 문자값으로 표현하기 위한 기호
		 */
		String sql1 = "insert into student values(?,?,?,?,?)";  //불완전 sql 명령
//		-> 반드시 모든 InParameter에 java 변수값을 전달받아 완전한 sql 명령을 완성함.
		PreparedStatement pstmt = con.prepareStatement(sql1);
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		int rows = pstmt.executeUpdate();
		System.out.println("[result]"+rows+"명의 학생정보를 삽입하였습니다.");
		System.out.println("======================================");
		//모든 학생 정보를 검색 및 출력
		String sql2 = "select * from student order by no";
		pstmt = con.prepareStatement(sql2);
		ResultSet rs= pstmt.executeQuery();
		System.out.println("<<학생정보 출력>>");
		while(rs.next()) {
			System.out.println("학번 : "+ rs.getInt("no")+", 이름 : "+rs.getString("name")+", 전화번호 : "+rs.getString("phone")+", 주소 : "+rs.getString("address")+", 생일 : "+rs.getString("birthday").substring(0,10));
		}
		System.out.println("=================================");
		ConnectionFactory.close(con, pstmt, rs);
	}
}
