package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

// 로그인 상태의 사용자만 요청 가능하도록
//아이디를 전달받아 USERINFO테이블에 저장된 회원정보를 검색하여 request 객체의 속성값으로 저장
//=> [user_view.jsp]로 포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class ViewModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward = new ActionForward();
		
		try {
			HttpSession session = request.getSession();
			UserinfoDTO loginUserinfo = (UserinfoDTO)session.getAttribute("loginUserinfo");
			
			
			//에러를 발생시킬 시, catch 부에서 처리함
			if(loginUserinfo==null) { //로그인 사용자가 아닐 시 -> 예외 발생시킴
				throw new Exception();
			}
			
			if(request.getParameter("userid")==null) {//전달값이 없는 경우 - 비정상적인 요청
				throw new Exception();
			}
			
			String userid = request.getParameter("userid");
			
			request.setAttribute("userinfo", UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(true);
			actionForward.setPath("/model_two/user_view.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		
		return actionForward; //사용할 view를 반환하는 것.
	}

}
