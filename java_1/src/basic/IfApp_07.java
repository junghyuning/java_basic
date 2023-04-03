package basic;

//제어문(Control Statement) : 프로그램의 흐름을 바꾸어주는 문장.
public class IfApp_07 {

	public static void main(String[] args) {
		int su = 90;
		
		System.out.println("su = "+su);
		
		//변수값이 50이상인 경우에만 화면에 출력되도록
		if(su>=50)
			System.out.println("su >= 50");
		System.out.println("===============================================================");
		
		int score=50;
		if(score>=60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다.");
		} else {   //if(score<60) 으로 쓸수도 있음. 다중 if문이 필요할때도 있을 것.
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다.");
		}
		System.out.println("===============================================================");
		
		int num = 9;
		//변수값을 홀수 or 짝수로 구분하여 출력하는 프로그램 작성
		if(num%2 != 0)  //%는 나머지!!
			System.out.println(num+" = 홀수");
		if(num%2 == 0)
			System.out.println(num + "= 짝수");
		System.out.println("===============================================================");
		
		char mun='O';
		
		//문자변수에 저장된 문자값을 영문자와 비영문자로 구분하여 출력하는 프로그램
		if((mun>='A' && mun <='Z') || (mun>= 'a' && mun<='z'))
			System.out.println("[결과]" + mun + "영문자");
		else 
			System.out.println("[결과]" + mun + "비영문자");
		System.out.println("===============================================================");

		boolean sw = false;
		
		
		//조건식 대신, boolean 변수값 사용하여 명령 선택 실행 가능.
		if(sw) {	// if(sw == true)와 같음.
			System.out.println("현재 변수값은 [참]입니다.");
		}else {
			System.out.println("현재 변수값은 [거짓]입니다.");
		}
		System.out.println("===============================================================");
		
		int jumsu=81;
		//변수값이 0~100 범위의 유효값인지 아닌지 구분하여 출력
		// 정상적인 값일때는 변수값을 이용해 등급을 나눔 100-90 : A / 89-80: b / 79-70:c / 69-60 :d / 59-0 : F
		if(jumsu<=100 && jumsu>=0) {
			System.out.println("[결과] 0~100범위의 정상적인 점수가 입력되었습니다.");
			String grade = "";
			if (jumsu>=90) grade = "A";
			else if (jumsu>=80) grade = "B";
			else if (jumsu>=70) grade = "C";
			else if (jumsu>=60) grade = "D";
			else grade = "F";
			System.out.println("[결과] "+jumsu+"점 = "+ grade +"학점");
		} else {
			System.out.println("[결과] 0~100범위를 벗어난 비정상적인 점수가 입력되었습니다.");
			
		}
		System.out.println("===============================================================");

	}

}
