package xyz.itwill.dto;
//
/*
create table review(num number primary key, id VARCHAR2(30),
subject VARCHAR2(500), content VARCHAR2(4000), regdate date, readcount number,
ref number(4), restep number(4), relevel number(4)
, ip VARCHAR2(20), status number(1));

이름        널?       유형             
--------- -------- -------------- 
NUM       NOT NULL NUMBER         - 글번호
ID                 VARCHAR2(30)   - 작성자(아이디) : 로그인한 사용자만 작성가능하도록
SUBJECT            VARCHAR2(500)  - 제목
CONTENT            VARCHAR2(4000) - 내용
REGDATE            DATE           - 작성일자
READCOUNT          NUMBER         - 조회수
REF                NUMBER(4)      - 글그룹 (답글)
RESTEP             NUMBER(4)      - 글그룹 내부의 글순서(답글)
RELEVEL            NUMBER(4)      - 게시글의 깊이(답글) -> 깊이에 따라 출력 위치가 조금씩 달라짐
IP                 VARCHAR2(20)   - 작성자 컴퓨터의 IP 주소
STATUS             NUMBER(1)      - 게시글 상태 (0: 삭제글-삭제처리하지 않고 이렇게 관리, 1: 일반글, 2: 비밀글 ) 

*/


public class ReviewDTO {
	private int num;
	private String id;
	private String name;
	private String subject;
	private String content;
	private String regdate;
	private String ip;
	private int readcount;
	private int ref;
	private int restep;
	private int relevel;
	private int status;
	
	public ReviewDTO() {
	}

	public ReviewDTO(int num, String id, String writer, String subject, String content, String regdate, String ip,
			int readcount, int ref, int restep, int relevel, int status) {
		super();
		this.num = num;
		this.id = id;
		this.name = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.ip = ip;
		this.readcount = readcount;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
		this.status = status;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRestep() {
		return restep;
	}

	public void setRestep(int restep) {
		this.restep = restep;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
