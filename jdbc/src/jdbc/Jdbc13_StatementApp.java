package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc13_StatementApp {
	public static void main(String[] args) throws Exception {
		//키보드로 학생정보를 입력받아 student 테이블에 삽입 -> 저장된 모든 학생정보를 검색 및 출력하는 jdbc프로그램
		
		//키보드로 학생정보를 입력받기 위한 입력스트림 생성 : bufferedreader 사용
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//system.in -> InputStreamReader -> buffered reader 확장
		
		//학생정보 입력받아 저장
		System.out.println("학생정보입력");
		System.out.print("학번 입력 >>");
		int no = Integer.parseInt(in.readLine()); //String으로 입력받아 integer로 변환.
		System.out.print("이름 입력 >>");
		String name = in.readLine();
		System.out.print("전화번호 입력 >>");
		String phone = in.readLine();
		System.out.print("주소 입력 >>");
		String address = in.readLine();
		System.out.print("생년월일 입력 >>");
		String birthday = in.readLine();
		System.out.println("=====================================");
		Connection connection = ConnectionFactory.getConnection();
		
		Statement stmt = connection.createStatement();
		String sql1 = "insert into student values("+no+",'"+name+"','"+phone+"','"+address+"','"+birthday+"')";
		int rows = stmt.executeUpdate(sql1);
		
		System.out.println("[result]"+rows+"명의 학생정보를 삽입하였습니다.");
		System.out.println("====================================");
		String sql2 = "select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
		System.out.println("<<학생정보출력>>");
		while(rs.next()) {
			System.out.println("학번 : "+ rs.getInt("no")+", 이름 : "+rs.getString("name")+", 전화번호 : "+rs.getString("phone")+", 주소 : "+rs.getString("address")+", 생일 : "+rs.getString("birthday").substring(0,10));
		}
		System.out.println("=================================");
		ConnectionFactory.close(connection, stmt, rs);
		
	}
}
