package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelloWorldApp {
	//Logger 객체 : 로그 이벤트를 발생하기 위한 객체
	private static final Logger logger = LoggerFactory.getLogger(LogHelloWorldApp.class);
	
	public static void main(String[] args) {
		logger.info("시작");
		LogHelloWorld hw = new LogHelloWorld();
		String message = hw.hello("홍길동");
		System.out.println("message = "+message);
		logger.info("종료");
		
	}
}
