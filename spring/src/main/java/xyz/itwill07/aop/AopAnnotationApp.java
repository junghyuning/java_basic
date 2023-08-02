package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAnnotationApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-5_aopAnnotation.xml");
		AopAnnotationBean bean=context.getBean("aopAnnotationBean", AopAnnotationBean.class);
		System.out.println("==========================================================");
		bean.display1();
		System.out.println("==========================================================");
		bean.display2();
		System.out.println("==========================================================");
		bean.display3();
		new RuntimeException();//인위적 오류 발생 -> AfterThrowing 메서드 실행 (Returning은 미실행)
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}