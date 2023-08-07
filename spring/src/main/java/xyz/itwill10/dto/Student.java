package xyz.itwill10.dto;

import lombok.Data;

/*
이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE  
*/
@Data
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
