package jdbc;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

//키보드로 sql 명령을 입력받아 dbms 서버에 전달 & 실행  -> 결과 출력하는 jdbc 프로그램 작성
//1. 키보드로 입력 가능한 sql 명령은 INSERT, UPDATE, DELETE, SELECT 명령만 입력받아 실행함.
//2. SQL 명령은 [EXIT] 입력 전까지 반복적으로 입력받아 실행함. - EXIT 대소문자 구분X
//3. 입력받은 SQL 명령이 잘못된 경우 에러 메세지 출력.
public class Jdbc15_SqlMinusApp {
	public static void main(String[] args) throws SQLException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = null;

		System.out.println("SQLMinus 프로그램을 실행합니다.(종료 : exit)");

		while (true) {
			System.out.print("SQL > ");
			String sql = in.readLine().trim();

			// 키보드 입력값이 없는 경우 반복문을 처음부터 다시 실행.
			if (sql == null || sql.equals(""))
				continue;

			// 키보드 입력값이 exit인 경우 반복문 종료 - ignorecase : 대소문자 구분x
			if (sql.equalsIgnoreCase("exit"))
				break;

			// 입력받은 SQL 명령을 전달하여 실행하고 실행결과를 반환받아 출력 - execute 이용
			String dml = null;
			if(sql.contains(" ")) {
				dml = sql.substring(0, sql.indexOf(' '));
			} else continue;

			try {
				if (dml.equalsIgnoreCase("select") || dml.equalsIgnoreCase("update") || dml.equalsIgnoreCase("delete")
						|| dml.equalsIgnoreCase("Insert")) {
					if (stmt.execute(sql)) { // select문일시,
						rs = stmt.getResultSet();
						while (rs.next()) {
							System.out.println("학번 : " + rs.getInt("no") + ", 이름 : " + rs.getString("name")
									+ ", 전화번호 : " + rs.getString("phone") + ", 주소 : " + rs.getString("address")
									+ ", 생일 : " + rs.getString("birthday").substring(0, 10));
						}
					} else { // 그 외 명령일 시,
						System.out.println(stmt.getUpdateCount());
					}

				} else
					System.out.println("[error] 수행할수없는 sql 명령어를 입력하셨습니다.");

			} catch (SQLSyntaxErrorException e) {
				System.out.println("[error] sql 명령의 문법에 어긋나는 명령을 입력하셨습니다.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("SQLMinus 프로그램을 종료합니다.");
	}
}
