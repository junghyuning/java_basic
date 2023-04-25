package xyz.itwill.util;

import java.util.Scanner;
import java.util.regex.Pattern;


//정규표현식 test 사이트도 있음.
//정규표현식 : 메타문자(Mera Character), 회피문자(Escape Character) 등을 사용하여 일정한 규칙의 문자열을 표현하는 방법 
//=> 사용자 입력값에 대한 검증을 할 때 사용할 것.


/*<<META 문자>>
 ^ : 문자 or 문자열로 시작 됨.
 $ : 문자열로 종료 됨
 . : 임의의 문자 하나 의미(\자는 표현 불가)ㅁ
 [문자1문자2문자3] : 나열된 문자 중 하나
 [^문자1문자2문자3] : 나열된 문자를 제외한 문자 중 하나
 [문자1-문자2] : 문자1~문자2 범위의 문자 중 하나
 문자열1|문자열2|문자열3 : 나열된 문자열 중 하나
 문자열+ : 문자열이 1번이상 반복 -> 무조건 존재
 문자열* : 문자열이 0번이상 반복 -> 있어도 되고 없어도 됨
 문자열? : 문자열이 0 or 1번 존재함
 문자열{숫자} : 문자열이 [숫자] 만큼 반복
 문자열{숫자1,숫자2} : 문자열이 [숫자1] ~ [숫자2] 만큼 반복
 (?!)문자열 : 문자열에서 대소문자를 구분 x
 (?=문자열) : 문자열이 반드시 포함
 (!=문자열) : 문자열이 반드시 포함x
 
*/


/* <<회피 문자>>

\s : 공백이 있는 문자열
\S : 공백이 없는 문자열
\w : 영문자, 숫자, 특수문자(_)의 문자로만 구성된 문자열
\W : 영문자, 숫자, 특수문자(_)제외 나머지로만 구성된 문자열
\d : 숫자형태의 문자로만 구성
\D : 숫자형태의 문자를 제외한 문자로 구성된 문자열
\메타문자 : 메타문자를 일반문자로 표현함 => \. : 문자 . 
*/

//키보드로 사용자에게 맞는 값을 입력받아 형식에 맞는 값인지를 바교하여 출력하는 프로그램
//=> 형식에 맞지 않는 값이 입력될 경우 에러 메세지 출력 후 프로그램 종료
public class RegualarExpressionApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//아이디 입력받아 형식에 맞는 값인지 비교
		//패턴 : 영문자 시작 , 영문자, 숫자, 특수문자(_)의 조합으로 6~20자리
		System.out.print("아이디 입력 >>");
		String id = scanner.nextLine();
		
		if(id==null||id.equals("")) {
			System.out.println("[error] 아이디를 입력해 주세요.");
			System.exit(0);
		}
		
		//아이디 패턴을 정규표현식으로 표현하여 저장.
		String idReg = "^[a-zA-Z][a-zA-Z0-9_].{5,19}$";
		String idReg2 = "^[a-zA-Z]\\w{5,19}$";//역슬레시는 java에서 회피문자로 인식 -> \\w 처럼 씀.
		
		
		//Pattern 클래스 : 정규표현식을 사용하기 위한 기능의 메서드를 제공하는 클래스
		//Pattern.mathces(String regEx, CharSequence input) : 정규표현식과 입력값을 비교 -> 정규표현식의 패턴과 입력값이 다르면 false , 일치할 시 true 반환
		if(!Pattern.matches(idReg, id)) {
			System.out.println("[error] ID does not Matched");
			System.exit(0);
		}
		
		System.out.println("[message] 형식에 맞는 아이디를 입력 하였습니다.");
		
		
		//사용자에게 비밀번호 입력받아 형식에 맞는 값인지 검증
		// 패턴 : 영, 숫, 특문 반드시 1번이상 포함. 
		//8-30 범위의 문자들로 구성된 문자열
		System.out.print("비밀번호 입력>> ");
		String password = scanner.nextLine();
		
		if(password==null||password.equals("")) {
			System.out.println("[error] 아이디를 입력해 주세요.");
			System.exit(0);
		}
		//?= 문자가 반드시 포함돼야..  //.* : 임의의 문자가 0번이상 포함 // [a-zA-Z] : 이 범위의
		String passwordTest = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{8,30}$"; //-는 마지막에 넣어야 마이너스 기호로 인식 함.
		if(!Pattern.matches(passwordTest, password)) {
			System.out.println("[error] password does not Matched");
			System.exit(0);
		}
		
		System.out.println("[message] 형식에 맞는 비밀번호를 입력 하였습니다.");
		System.out.println("==================================================================================");
		//사용사에게 email 입력받음 -> 패턴 : [아이디@도메인]
		
		System.out.print("비밀번호 입력>> ");
		String eMail = scanner.nextLine();
		
		if(eMail==null||eMail.equals("")) {
			System.out.println("[error] 이메일를 입력해 주세요.");
			System.exit(0);
		}
		
		String eMailTest = "^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$"; //-는 마지막에 넣어야 마이너스 기호로 인식 함.
		if(!Pattern.matches(eMailTest, password)) {
			System.out.println("[error] password does not Matched");
			System.exit(0);
		}
		System.out.println("[message] 형식에 맞는 이메일을 입력 하였습니다.");
		scanner.close();
	}
}
