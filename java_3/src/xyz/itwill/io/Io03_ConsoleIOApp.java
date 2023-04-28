package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//키보드로 이름과 태어난 년도를 입력받아 이름과 나이를 계산하여 출력하는 프로그램
public class Io03_ConsoleIOApp {
	public static void main(String[] args) throws IOException {
		//Java 프로그램 개발을 위해 기본적으로 제공되는 키보드 입력스트림 (System.in)을 이용
		//-> InputStreamReader 클래스로 확장하고 -> Reader 객체 전달 -> Buffered Reader 클래스의 입력스트림으로 확장 
		//-> 대량의 문자데이터를 입력받을 수 있는 입력스트림 생성
//		확장 = 메서드의 증가 (기존의 클래스를 상속받아 새로운 기능을 추가한것이기 때문)
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("name >> ");
		
		String name = in.readLine();
		
		System.out.println("Birth Year >> ");
		 int birthYear = Integer.parseInt(in.readLine());
		 
		 int age = Calendar.getInstance().get(Calendar.YEAR)-birthYear+1;
		 
		 System.out.println("[result]"+ name+"님의 나이는 "+age+ "살입니다.");
		
		
	}
}
