package xyz.itwill.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//글번호를 전달받아 GUEST 테이블에 저장된 행을 삭제하고 

@WebServlet("/guest/remove.itwill")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달값이 없을 경우, 비정상 요청
		if(request.getParameter("num")==null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		//리퀘스트 메세지 몸체부에 저장되어 전달되는 값에 대한 캐릭터셋 변경
		//숫자만 받아오는 것이므로 별도의 인코딩 필요x
//		request.setCharacterEncoding("utf-8");
		
		//전달값을 반환받아 저장
		int num = Integer.parseInt(request.getParameter("num"));
		

		
		//DTO 객체를 전달받아 GUEST 테이블에 행을 삽입하는 DAO 클래스의 메소드 호출
		int rows =GuestDAO.getDAO().deleteGuest(num);
		//클라이언트에게 URL 주소를 전달하여 응답 처리
		// => 클라이언트는 전달받은 URL 주소의 서블릿을 요청하여 실행결과를 응답받아 출력 - 리다이렉트 이동
		//삭제된 행이 없는경우 error반환, 있는경우 redirect url 반환
		if(rows>0) {
			response.sendRedirect("list.itwill");			
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}
}