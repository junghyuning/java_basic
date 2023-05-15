package jdbc;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//키보드로 입력받은 학생 정보 중, 해당 이름의 학생정보를 검색하여 출력하는 jdbc 프로그램 작성.
public class Jdbc13_Statement2 {
	public static void main(String[] args) throws IOException, SQLException {
		// 입력스트림 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 입력>>");
		System.out.print("이름 입력 >> ");
		String name = in.readLine();
		
		System.out.println("-----------------------------------");
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		String sql="select * from student where name = '"+name+"' order by no";
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("<<학생정보 출력>>");
		if(rs.next()) {
			do {
				System.out.println("학번 : "+ rs.getInt("no")+", 이름 : "+rs.getString("name")+", 전화번호 : "+rs.getString("phone")+", 주소 : "+rs.getString("address")+", 생일 : "+rs.getString("birthday").substring(0,10));
			} while(rs.next());
		}else {
			System.out.println("검색된 학생정보가 없습니다.");
		}
		System.out.println("-----------------------------------");
		
		//but if => ' or '1 입력시? => select * from student where name = '' or '1' order by no
		//즉, 항상 참인 결과를 반환 -> 모든 학생정보가 출력됨 
		//=> 관리자 권한을 침입할수도 있는 것이므로 보안의 취약성 초래.
		// => statement 사용하지 말것을 권고하고 있음.
		
	}

}
