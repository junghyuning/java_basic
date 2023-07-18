package xyz.itwill.dto;

/*
MYUSER 테이블 : 회원정보를 저장하기 위한 테이블
=> SQL 명령은 대소문자를 구분하지 않음 => 식별자 선언시 스네이크 표기법(_) 사용

create table myuser(user_id varchar(50) primary key, user_name varchar2(50));

이름        널?       유형           
--------- -------- ------------ 
USER_ID   NOT NULL VARCHAR2(50) - 아이디
USER_NAME          VARCHAR2(50) - 이름


*/

//Java 자료형(Class, Interface, Enum)을 선언할 경우 [파스칼 표기법] 이용
//=> 파스칼 표기법(PascalCase) : 모든 단어의 첫문자를 대분자로 표현하여 식별자를 선언
public class MyUser {
	String userId;
	String userName;
	
	public MyUser() {
	}

	public MyUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
