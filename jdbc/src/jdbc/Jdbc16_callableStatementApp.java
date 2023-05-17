package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/*
CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN STUDENT.NO%TYPE, VNAME OUT STUDENT.NAME%TYPE) IS
BEGIN
    SELECT NAME INTO VNAME FROM STUDENT WHERE NO = VNO;
    IF SQL%FOUND THEN
        DELETE FROM STUDENT WHERE NO=VNO;
        COMMIT;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        VNAME := NULL;
END;
/
*/


public class Jdbc16_callableStatementApp {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 삭제>>");
		System.out.println("학번 입력>>");
		int no = Integer.parseInt(in.readLine());
		System.out.println("--------------------------------------------");
		Connection con = ConnectionFactory.getConnection();
		
		//conection.preparecall(string sql) : 저장 프로시저를 호출하는 명령을 전달하여 실행하기 위한 callablestatement 객체를 반환하는 메서드
		String sql = "{call delete_student(?,?)}";//첫 ? : 입력받은 값 / 두번째 ? : 저장할 값
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, no);
		
		//CallableStatement.registerOutParameter(int parameterIndex, int sqlType)
		// => 저장 프로시저에서 사용한 매개변수 중 OUT 모드의 매개변수에 저장된 값을 제공받기 위한 메소드
		// => sqlType : SQL 자료형 - Types 클래스의 상수 사용
		cstmt.registerOutParameter(2, Types.NVARCHAR);
		
		//저장 프로시저를 호출하는 명령을 전달하여 실행하는 메서드
		cstmt.execute();
		
		//CallableStatement.getString(int parameterIndex) : out모드의 매개변수에 저장된 값을 반환하는 메서드
		String name = cstmt.getString(2);
		
		if(name == null) {
			System.out.println("[메세지] 해당 학번의 학생 정보를 찾을 수 없습니다.");
		} else {
			System.out.println("[메세지]"+name+"님을 삭제하였습니다. ");
		}
		
	}
}
