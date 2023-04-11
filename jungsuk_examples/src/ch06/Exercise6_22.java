package ch06;

public class Exercise6_22 {
	
	public static boolean isNumber(String str){
		boolean isNumber = false;  // 숫자면 true, 숫자가 아니면 false
		for(int i=0; i<str.length();i++) {
			if(str.length()!=0 && str.charAt(i) >='0' && str.charAt(i) <='9') 
				isNumber = true;
			else isNumber = false;
		}
		
		return isNumber;
		
	}
	

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+" 는 숫자입니까? "+isNumber(str)); 
		str = "1234o";
		System.out.println(str+" 는 숫자입니까? "+isNumber(str)); 
		}

}

