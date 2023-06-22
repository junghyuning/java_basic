package xyz.itwill.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	//JSP 문서에서 커스텀 태그를 사용한 경우 객체에 의해 자동으로 호출되는 메서드
	@Override
	public int doStartTag() throws JspException {
		 try {
			pageContext.getOut().println("<h3>커스텀 태그 사용</h3>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return super.doStartTag();
	}
}
