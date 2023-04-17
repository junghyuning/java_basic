package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 주민번호 입력받아 주민번호를 이용 -> 생년월일과 성별 제공받아 출력
// 주민번호 14자리로 입력받아야함 + 7번째에 반드시 - 문자
//if 비정상 입력 => error 메세지 출력 후, 재입력하도록.
public class PersonNumberApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String personNum;
		while(true) {
			System.out.print("주민등록번호 입력(-포함) >> ");
			personNum = scanner.nextLine().replace(" ", "");
			if(personNum.length()==14 && personNum.charAt(6)== '-' ) break;
			System.out.println("[error] 맞는 형식으로 입력해 주세요.");
		}
		scanner.close();
		
		
		String[] personNum2 = personNum.split("-");
		String birthDate, gender ;
		if(personNum2[1].charAt(0)<='2') {
			birthDate = 19+personNum2[0];
			if(personNum2[1].charAt(0)==1)
				gender = "남자";
			else gender = "여자";
		}
		else {
			birthDate = 20+personNum2[0];
			if(personNum2[1].charAt(0)==3)
				gender = "남자";
			else gender = "여자";
		}
		birthDate = birthDate.substring(0,4)+"년"+birthDate.substring(4,6) +"월"+birthDate.substring(6) +"일";
		System.out.println("생년월일 : "+birthDate+", 성별: "+ gender);
	}
}
