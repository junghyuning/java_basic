package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloMessageTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	//커스텀 태그의 속성값을 저장하기 위한 필드 => 커스텀 태그의 속성명과 같은 이름으로 필드 선언
	private String name;
	
	//생성자에 객체 생성에 필요한 초기화 작업 관련 명령 작성 - 필드 초기값 설정
	public HelloMessageTag() {
		name = "홍길동";
	}

	public String getName() {
		return name;
	}
	
	//커스텀 태그 사용시태그 속성을 사용하여 속성값을 설정할 경우 Setter 메서드 자동 호출
	public void setName(String name) {
		this.name = name;
	}

	//커스텀 태그 사용시 호출되는 = 필요한 메서드만 오버라이드
	//=> 오버라이드하지 않은 메서드의 경우 부모 클래스의 명령이 없는 메서드를 호출하므로 
	//=> 호출 하여도 효력은 발생하지 않음
	@Override
	public int doStartTag() throws JspException {
		
		try {
			if(name.equals("홍길동")) {
				//pageContext.getOut() : 응답문서를 생성하기 위한 출력스트림(JspWriter 객체)을 반환하는 메소드
				pageContext.getOut().print("<h3>관리자님, 안녕하세요.</h3>");
			} else {
				pageContext.getOut().print("<h3>"+name+"님, 안녕하세요.</h3>");
				
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		return SKIP_BODY;
	}
	
}
