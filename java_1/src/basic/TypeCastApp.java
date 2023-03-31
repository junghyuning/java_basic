package basic;

//자료형 변환 : 자료형을 '일시적으로' 변환하여 사용
public class TypeCastApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("결과 = " + (3+1.5)); // int 3 + double 1.5 -> double 4.5로 자동 형변환
		
		double su = 10; // 10>>10.0으로 자동 형변환 시킴.
		//자동 형변환
		System.out.println("su = " + su);
		System.out.println("결과 =" + (35/10)); // int /int -> int
		System.out.println("결과 =" + (35.0/10.0));  // double / double -> double
		System.out.println("결과 =" + (35.0/10));  // double / int(자동형변환) -> double
		System.out.println("결과 =" + (35/10.0));  // int(자동형변환) / double -> double
		System.out.println("결과 =" + (35/10.));  // int(자동형변환) / double -> double
		
		int kor = 95, eng = 90;
		int total = kor + eng;  // 총점
		double ave = total / 2; // 평균 but, 정수 / 정수 = 정수 -> 결과값이 정수를 실수로 표현할 뿐.
		System.out.println("총점 = " + total + " 평균 = " + ave);
		
		ave = total / 2.0; // 평균 나누는 값을 실수타입으로 해야 정수 / 실수 => 결과값도 실수가 됨.
		System.out.println("총점 = " + total + " 평균 = " + ave);
		
		//int 자료형 보다 작은 자료형(short, byte, char)의 값은 연산시, 무조건 int로 형변환 되어 연산됨. 
		byte su1 = 10, su2 = 20;
		//byte su3 = su1+su2;  // int형이 되므로 byte에 저장 불가.
		int su3 = su1 + su2;
		System.out.println("su3 = " +su3);

		System.out.println("===============================================================");
		//강제형변환
		int num = (int)12.3;
		System.out.println("num = " + num);
		
		int num1 = 95, num2 = 10;
		double num3 = num1/num2;
		System.out.println("num3 = " + num3); //9.0
		
		num3 = (double)num1/num2; // 피연산자 중 한개를 double로 형변환
		System.out.println("num3 = " + num3); //9.5
		
		int num4 = 100_000_000 , num5 = 30;  //숫자 표기시 , 대신 _ 사용 가능. 
		int num6 = num4*num5;  //연산결과가 21억 넘음
		System.out.println("num6 = " + num6);  // int(4Byte) 범위를 벗어남. (오버플로우발생)
		
		//애초에 num 4,5를 long 으로 선언시, 런타입애러 발생x but, 저장값이 int 범위 내이므로 공간의 낭비가 발생
		//가능하다면 그냥 int를 사용하는것이 나음.
		long num7 = (long)num4*num5;  //피연산자중, 하나만 long타입으로 바꿀 시, 자동형변환.
		System.out.println("num7 = " + num7);  
		
		
		System.out.println("===============================================================");
		
		double number = 1.23456789;

		//소숫점 2자리 버림. n자리 올림버림반올림 실행시 *10^n 수행 
		System.out.println("number(내림) = " + (int)(number*100)/100.0); //100곱하고 int 변환 -> 소숫점 아래 버림 -> 다시 곱한값 나누어주면, 원하는 자리수 만큼만 남기고 버림.
		
		//반올림
		System.out.println("number(반올림) = " + (int)(number*100+0.5)/100.0); 
		
		//올림
		System.out.println("number(올림) = " + (int)(number*100+0.9)/100.0); 
		
		
		
	}

}
