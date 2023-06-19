package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectInputFilter.Config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 클라이언트 요청에 의해 WAS 프로그램에 등록된 서블릿 클래스를 읽어 메모리에 저장하고
//서블릿 클래스로 객체를 생성하여 요청 처리 메서드를 호출
// => 클라이언트 요청에 의한 서블릿 객체가 이미 생성되어 있는 경우 새로운 서블릿 객체를 생성하지 않고 기존 서블릿 객체를 사용하여 요청처리 메서드를 호출함
// => WAS 프로그램 종료시, WAS 프로그램에 의해 생성되어 관리된 모든 서블릿 객체 소멸
@WebServlet("/life.itwill")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	//Servlet 객체를 생성하기 위한 생성자 - 객체 생성"시" 초기화 명령 작성
	public LifeCycleServlet() {
		//name="홍길동";
		System.out.println("###LifeCycleServlet 클래스의 생성자 호출 - 객체생성 ###");
	}
	
	//서블릿 객체가 생성된 "후" WAS 프로그램에의해 자동으로 1번만 호출되는 메서드
	//=> 객체 생성 "후" 초기화 명령 작성
	// => init() 메소드는 매개변수로 ServletConfig 객체를 제공받아 사용 가능
		//ServletConfig 객체 : 웹자원을 생성하기 위한 환경 설정 관련 정보를 저장한 객체
		// => [web.xml] 파일에서 제공되는 값을 얻어와 서블릿 클래스에서 사용 가능 - 유지보수의 효율성 증가
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("###LifeCycleServlet 클래스의 init()메서드 호출 ###");
		//name="홍길동";// 생성자에서 초기화 한것과 같은 결과
		
		name = config.getServletContext().getInitParameter("name");  // WEB에 정의된 PARAM이 DATA를 받아옴
		System.out.println(name);
		//[web.xml]파일의 init-param 엘리먼트로 제공되는 값은 ServletConfig 객체의 getInitParameter(String name) 메서드를 호출하여 값을 얻어와 반환
		
		
	}
	
	
	//클라이언트가 요청할때마다 WAS 프로그램에 의해 호출되는 요청 처리 메서드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("###LifeCycleServlet 클래스의 service() 메서드 호출###");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿의 생명주기(Life Cycle)</h1>");
		out.println("<hr>");
		out.println("<p>"+name+"님 안녕하세요!</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	//서블릿 객체가 소멸되기 전에 WAS 프로그램에 의해 자동으로 1번만 호출되는 메서드
	// => 객체 소멸 전 실행될 명령 작성 - 마무리 처리
	
	@Override
	public void destroy() {
		
	}

}
