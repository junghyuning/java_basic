package xyz.itwill.lang;

import java.net.SocketOption;

public class StringApp {
	public static void main(String[] args) {
//		문자열은 "" 기호를 사용, -> String객체로 표현가능
//		엄밀히 말하면, ABC는 값이 아니라 객체임 => 따라서 str1에는 스트링객체 ABC의 주소가 저장됨.

		String str1 = "ABC"; // String 리터럴은 객체 생성시, 상수풀(Constant Pool)에 저장됨. -> 따라서 문자열은 같은 문자열이 2개 생성되지 않음
		String str3 = new String("ABC");// String 객체 생성시, Heap영역에 객체 생서됨 -> 참조변수에 Heap 영역의 메모리주소 저장

		System.out.println(str1.toString()); // 문자열의 문자 반환
		System.out.println(str1);// but 참조변수 출력시 toString을 자동 호출하므로 생략 가능.

		System.out.println("=============================================================");
		String str2 = "ABC";

		// 참조변수를 비교할 시, 메모리주소 비교하는것.
		if (str1 == str2)
			System.out.println("str1 == str2");
		else
			System.out.println("str != str2");

		System.out.println("=============================================================");
		if (str1 == str3)
			System.out.println("str1 == str3");
		else
			System.out.println("str != str3");
		System.out.println("=============================================================");

		System.out.println(str1.equals(str3));
		System.out.println("=============================================================");

		String str4 = "abc";
		System.out.println(str1.equals(str4)); // equals() : 대소문자 비교함

		System.out.println(str1.equalsIgnoreCase(str4)); // equalsIgnoreCase() 대소문자 비교
		System.out.println("=============================================================");
		if (str1.compareTo(str4) > 0)
			System.out.println("str1 > str4");
		else if (str1.compareTo(str4) < 0)
			System.out.println("str1 < str4");
		else
			System.out.println("str1 = str4");
		System.out.println("=============================================================");

		System.out.println(str1.compareToIgnoreCase(str4)); // 대소문자 구분x

		byte[] array = str1.getBytes(); // String 객체에 저장된 문자열을 byte 배열로 변환 후 반환하는 메서드 => 네트워크 학습시 사용할것.
		for (byte ch : array)
			System.out.print(ch); // 65:A / 66:B / 67:C
		System.out.println();

		for (byte ch : array)
			System.out.print((char) ch); // ascii 코드를 문자로 형변환하여 문자로 보여줌
		System.out.println();
		System.out.println("=============================================================");
		String str5 = "ABCDEFG";
		System.out.println(str5.length());
		System.out.println("=============================================================");
		System.out.println(str5.charAt(1));
		System.out.println("=============================================================");
		System.out.println(str5.indexOf("E")); // 시작값 반환 / 존재하지 않을시, -1 반환
		System.out.println(str5.indexOf("EF")); // 존재하지 않을시, -1 반환
		System.out.println("=============================================================");
		String str6 = "Java programming";
		System.out.println(str6);
		System.out.println(str6.toUpperCase());
		System.out.println(str6.toLowerCase());
		System.out.println("=============================================================");
		String str7 = "  Hong    Gil    Dong    ";
		System.out.println("[" + str7 + "]");
		System.out.println("[" + str7.trim() + "]");// 양옆공백다듬기
		System.out.println("=============================================================");
		System.out.println("[" + str7.replace(" ", "").replace("Gil", "GIL") + "]"); // replace("A","a").("b","B") => 여러
																						// 항목 수정시 점(.)연산자로 연결
		System.out.println("=============================================================");
		String str9 = "010-5447-7525";
		String[] numArray = str9.split("-"); // => "-"를 기준으로 분리 저장
		for (String string : numArray)
			System.out.println(string);
		System.out.println("=============================================================");
//		정규표현식에서 사용하는 메타문자 ex)* = all -> 이런걸 구분하기 위해서는 \\* 이렇게 역슬레시 2개 붙여 분리함
		String str8 = "010*5447*7525";
		String[] phonenum = str8.split("\\*");
		for (String string : phonenum)
			System.out.println(string);
		System.out.println("=============================================================");
		System.out.println(str9.substring(0, 3));
		System.out.println(str9.substring(4, 8));
		System.out.println(str9.substring(9, 13));
		System.out.println("=============================================================");
		// substring() 메소드 매개변수에 시작첨자만 전달하면 시작첨자의 문자로부터 문자열의
		// 마지막 문자까지 분리하여 반환
		System.out.println("전화번호 뒷부분 = " + str9.substring(9));
		System.out.println("==============================================================");
		// String.valueOf(Object obj) : 매개변수로 전달된 모든 자료형의 값을 문자열(String
		// 객체)로 변환하여 반환하는 메소드
		// String numString=String.valueOf(100);
		// ""+값 또는 값+"" 형식으로 모든 자료형의 값을 문자열과 결합하여 문자열로 사용 가능
		String numString = 100 + "";

		System.out.println("numString = " + numString);
		System.out.println("==============================================================");

	}
}
