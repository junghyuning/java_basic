package xyz.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트 요청에 의해 이미지파일로 응답하기 위한 서블릿으로 작성
@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에게 이미지 파일이 응답되도록 응답파일의 타입 변경
		//문서파일이 아니므로 인코딩 제공할 필요x (charset 설정x)
		response.setContentType("image/jpeg");
		
		//응답파일을 생성하기 위한 출력스트림을 반환받아 저장
		//=> 이미지파일(이진 파일 : Binary File)을 생성하기 위해 ServletOutputStream 객체 반환
		ServletOutputStream out = response.getOutputStream();
		
		//서버에 저장된 이미지 파일의 시스템 경로를 반환받아 저장
		
		//WAS 가 접근할 수 있는 영역은 web directory 이므로 이미지를 webapp 영역에 업로드해야 사용 가능함.
		String imageFilePath = request.getServletContext().getRealPath("/WEB-INF/Koala.jpg");
		
		
		//매개변수에 이미지 파일의 시스템 경로를 제공 - 파일 입력 스트림 생성
		FileInputStream in = new FileInputStream(imageFilePath);
		
		
		//입력스트림으로 원시데이터를 읽어와 출력 스트림으로 전달 - 반복
		//=> 서버에 저장된 이미지 파일을 클라이언트에게 전달하여 응답
		while (true) {
			int readByte = in.read();
			if(readByte ==-1) break;
			out.write(readByte);
		}
		in.close(); // 파일 입력스트림 제거
	}

}
