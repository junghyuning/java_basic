package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring 프레임워크에서는 BeanFactory 객체 or ApplicationContext 객체로 Spring Container 기능 제공
//=> 스프링컨테이너는 환경설정파일(Spring Bean Configuration File - XML)로 클래스를 제공받아 Spring Bean(객체) 관리
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1.BeanFactory 객체를 생성하여 스프링 컨테이너로 사용하는 방법");
		System.out.println("=============Spring Container 초기화 전===============");
		//BeanFactory 인터페이스를 상속받은 자식클래스로 객체 생성 - BeanFactory 객체
		//=> BeanFactory 객체를 생성할 때 Spring Bean Configuration File을 제공받아 스프링 컨테이너 생성
		//        = 스프링컨테이너 초기화 작엄
		//=> 매개변수에는 Spring Bean Configuration File의 경로를 제공받아 Resource 객체로 생성
		//=> BeanFactory 객체는 Spring Bean Configuration File에 등록된 클래스로 미리 객체를 생성하지 않고 Spring Bean을 제공받기 위해 요청시 객체를 생성하여 제공
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("=============Spring Container 초기화 후===============");
		//BeanFactory.getBean(String beanName) : 매개변수로 Spring Bean을 구분하기 위한 식별자(beanName)을 전달받아
		//스프링 컨테이너로부터 Spring Bean(객체)를 생성하여 변환하는 메서드
		//=>Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		//=> 매개변수로 전달받은 식별자(beanName)의 Spring Bean이 없는 경우 NoSuchBeanDefinit
		CreateBean bean1 = (CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("======================================================");
		System.out.println("2.ApplicationContext객체를 생성하여 스프링 컨테이너로 사용하는 방법");
		System.out.println("============Spring Container 초기화 전===============");
		//ApplicationContext 인터페이스  
		//=〉 ApplicationContext 객체를 생성할 때 Spring Bean Configuration FiIe을 제공받아
		//스프링 컨테이너 생성 - 스프링 컨테이너 초기화 작업
		// =〉 클래스가 참조 가능한 폴더(ClassPath)에 저장된 Spring Bean configuration File을
		// => AplicationContext 객체는	Spring Bean Configuration File에 등록된 클래스로 미리
		//객체를 생성하여 Spring Bean 요청시 미리 생성된 객체를 제공
		ApplicationContext context = new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("============= Spring Container 초기화 후 =============");
	}
}
