package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

//student table 생성 ->  ORACLE SQL DEVELOPER 에서 생성 (번호, 이름, 전화번호, 주소, 생일)


//STUDENT 테이블에 학생정보를 삽입하는 JDBC 프로그램 작성.
public class Jdbc03_InsertStudentApp {
	public static void main(String[] args) {
		//jdbc관련 객체의 경우 예외처리 블럭 외부에 선언함 -> 전체 영역에서 객체를 사용하기 위함.
		Connection con =null;
		Statement stmt = null;
		try {
//			DriverManager.registerDriver(new OracleDriver());			
			
			//Class.forName 메서드 호출 -> ClassLoader 프로그램을 이용하여 OracleDriver 클래스를 읽어 메모리에 저장함.
			//oracledriver 클래스 읽어 들일 시, -> memory에 등록됨 -> OracleDriver 클래스의 정적 영역에서 객체생성 => DriverManager 클래스의 JDBC Driver로 등록하는 메서드를 호출 함.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			﻿Connection con = DriverManager.getConnection(String url ,String user, String password)
			//﻿oracle dbms 접근하기위한 uml : jdbc:oracle:thin:@ServerName:port:SID 
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			//만약 아래 명령문에서 
			con = DriverManager.getConnection(url,user,password);
			
//			Connect객체로부터 sql명령을 전달할 수 있는 Statement 객체를 반환 받아 저장 함.
			stmt = con.createStatement();
//			String sql = "insert into student values(100,'홍길동','010-1234-5678','서울시 강남구','00/01/02')";		
//			String sql = "insert into student values(2000,'임꺽정','010-7894-1234','수원시 월정구','02/05/08')";		
			String sql = "insert into student values(3000,'전우치','010-1478-5050','인천시 상당구','03/06/09')";		
			int rows = stmt.executeUpdate(sql);
			
			System.out.println("[메세지]"+rows+"명의 학생정보를 삽입하였습니다.");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("[error]Can not found Oracle Driver Class");
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("[error] JDBC error : " + e.getMessage());
		}finally { //예외 발생과 관계없이 실행되는 영역
			//jdbc관련 객체를 모두 제거함. -> 생성된 순서의 역순으로 제거
			try {
				//만일, stmt or con에 값을 저장하기 이전에 에러가 발생할 경우, 둘의 값은 초기값대로 null임
				//null로 메서드를 소환하는 것은 불가능 하므로 NullPointerException 발생함
				//-> if 구문을 사용하여 null일 경우 발생할 오류를 방지함
				if(stmt!=null)stmt.close();
				//접속해제
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
