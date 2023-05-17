package dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//user.properties 파일에 저장된 값을 얻어와 출력하는 프로그램 작성
public class Dbcp01_PropertiesApp {
	public Dbcp01_PropertiesApp() throws IOException {
		//properties 파일을 읽어오기 위한 파일 입력 스트림 작성
		//=> 파일 입력 스트림 이용
//		FileInputStream in = new FileInputStream("src/dbcp/user.properties");
		//=> but, 해당 경로는 컴퓨터 내부 저장소를 가리키므로 현 컴퓨터에서 실행시에는 문제가 없지만, 
		//	배포시에는 문제가 되므로 잘 사용하지 않음
		
		//1. 클래스.class : Class 파일을 이용하여 Class 객체를 제공받는 방법
		//2. Class.getClassLoader() : 클래스를 읽어 메모리에 저장된 ClassLoader 객체를 반환하는 메서드
		InputStream in = getClass().getClassLoader().getResourceAsStream("dbcp/user.properties");
		
		//properties 객체 생성
		Properties properties = new Properties();
		properties.load(in);
		
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		System.out.println("아이디 = "+id);
		System.out.println("비밀번호 = "+password);
		System.out.println("이름 = "+name);
	}
	
	public static void main(String[] args) throws IOException  {
		new Dbcp01_PropertiesApp();
	}
}
