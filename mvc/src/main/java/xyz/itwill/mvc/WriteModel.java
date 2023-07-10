package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.exception.ExistsUserinfoException;
import xyz.itwill.service.UserinfoService;
//[user_write.jsp] => [/write.do]요청 = [WriteModel.java]클래스
//클라이언트가 [/write.do]로 요청한 경우 객체로 생성될 모델 역할의 클래스
// => 회원정보를 전달받아 USERINFO 테이블에 회원정보로 삽입하고 [/loginform.do] 페이지로 
//리다이렉트 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class WriteModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		UserinfoDTO userinfo=null;
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}
			
			request.setCharacterEncoding("utf-8");
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			int status=Integer.parseInt(request.getParameter("status"));
			
			userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			userinfo.setPassword(password);
			userinfo.setName(name);
			userinfo.setEmail(email);
			userinfo.setStatus(status);
			
			//UserinfoService 클래스의 addUserinfo() 메소드를 호출하여 회원등록 처리
			// => 전달받은 아이디가 USERINFO 테이블에 저장된 기존 회원정보의 아이디와 중복 검사 
			//1. 중복 -> ExistsUserinfoException 발생 2. 미중복 -> insertUserinfo(userinfo) 호출
			UserinfoService.getService().addUserinfo(userinfo);
			
			
			actionForward.setForward(false); //redirect방식으로 요청할 것.
			actionForward.setPath(request.getContextPath()+"/loginform.do"); 
			//loginform.do 페이지를 다시 요청 => loginform의 모델 생성됨. (기존 request객체는 삭제됨)
			
		} catch (ExistsUserinfoException e) {
			//아이디가 중복된 경우 발생되는 예외에 대한 예외처리 명령 작성
			request.setAttribute("message", e.getMessage()); //예외가 발생한 경우 ExistsUserinfoException에서 message를 매개변수로 받음 -> 해당 메세지를 setAttribute로 request객체에 저장함.
			request.setAttribute("userinfo", userinfo); //기존에 작성한 userinfo 객체를 다시 requset객체에 저장하여 다시 회원가입 페이지로 redirection
			actionForward.setForward(true); //forward 타입 이동
			actionForward.setPath("/model_two/user_write.jsp"); //user_write.jsp로 request객체 다시 전달 -> 다시 form에 기입됨
		} catch (Exception e) { //예기치 못한 에러
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		return actionForward;
	}

}