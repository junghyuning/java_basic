package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일) 계산하여 출력하는 program
//Date & SimpleDateFormat 활용하기 : String -> Date  // Timestamp 
//1. 생년월일 입력 - 20000-01-01 >> 2023-04-19
//[결과] 태어난지 1일이 지났습니다.
// 형식에 맞지 않는 생년월일을 입력한 경우, 에러메세지 출력 후 종료
public class DayCaculateApp {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);
		System.out.print("생년월일 >> ");
		String birthDay = scanner.nextLine();
		scanner.close();
		Date birthDate = null;
		//초기화 하지 않으면, 값이 존재하지 않으므로 컴파일러가 예외가 발생할것이라고 판단하지 않아 아예 try문을 실행하지 않음 => 따라서 반드시 초기화 해줘야 함.
		try {
			birthDate = dateFormat.parse(birthDay);
		} catch (ParseException e) {
			System.out.println("[error] 형식을 잘못입력하셨습니다.");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("[error] 예기치못한 오류");
		}
		System.out.println("[결과] 태어난지"+((System.currentTimeMillis()-birthDate.getTime())/1000/86400)+"일 지났습니다.");		
	}
	
	
}