package xyz.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class StudentControllerTest {
	//WebApplicationContext 객체를 제공받아 저장하기위한 필드 선언 - 의존성 주입
	//=> WebApplicationContext 객체 : SpringMVC 프로그램에서 스프링 컨테이너 기능을 제공하기 위한  
	@Autowired
	private WebApplicationContext context;
	
	//MockMvc 객체를 저장하기 위한 필드 선언
	//=> MockMvc 객체 : 요청과 응답을 가상으로 제공하기위한 객체
	private MockMvc mvc;
	
	
	
	@Before
	public void setup() {
		//MockMvcBuilders.webAppContextSetup(WebApplicationContext context)
		//=>MockMvcBuilder 객체를 생성하여 반환하기위한 메서드
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		log.info("MockMvc객체 생성");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
	
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		
		log.info(result.getModelAndView().getViewName());
		log.info(result.getModelAndView().getModel().toString());
		
	}
}
