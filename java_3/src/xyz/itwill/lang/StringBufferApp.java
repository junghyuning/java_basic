package xyz.itwill.lang;

//문자열을 저장하기 위한 클래스
//StringBuffer 객체에 저장된 문자를 조작하기위한 메서드 제공  => 문자열 직접 변경 가능.

public class StringBufferApp {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("ABC");
		System.out.println("sb = " + sb.toString());
		System.out.println("sb = " + sb);
		System.out.println("==================================");

		String str = sb.toString();
		System.out.println("str =" + str);
		System.out.println("==================================");

		// 값을 추가하는 method -> append();
		sb.append("DEF"); // str +="DEF";
		System.out.println("sb = " + sb);

		str += "DEF";
		System.out.println("str =" + str);
		System.out.println("==================================");
		sb.insert(4, "X");
		System.out.println("sb = " + sb);
		System.out.println("==================================");
		sb.deleteCharAt(4);
		System.out.println("sb =" + sb);//ABCDEF(0,1,2,3,4,5)
		sb.delete(4, 6);
		System.out.println("sb =" + sb);//ABCD
		System.out.println("==================================");
		sb.reverse();
		System.out.println("sb = "+sb);//DCBA
		System.out.println("==================================");
	}

}
