package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TilesView 클래스 : 요청 처리 메소드의 반환값(ViewName)을 제공받아 다수의 JSP 문서가 결합된
//JSP 문서(템플릿 페이지)로 응답하기 위한 기능을 제공하는 클래스 - ViewResolver
//1.TilesView 관련 라이브러리(tiles-extras 라이브러리)를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2.요청 처리 메소드의 반환값(ViewName)을 제공받아 응답할 템플릿 페이지 설정
// => TilesView 프로그램의 환경설정파일을 설정 - /WEB-INF/spring/appServlet/tiles.xml


@Controller
public class TilesController {
	@RequestMapping("/")//최상위디렉토리를 요청했을 경우 = 보통 메인페이지가 호출 됨
	public String tiles() {
		
		return "main";
	}
}