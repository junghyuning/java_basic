package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Userinfo {
	private String userid;
	private String password;
	private String name;
	private String email;
	private int status;
	
	
}
