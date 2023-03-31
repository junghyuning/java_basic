package example;

public class VariableExample {
	public static void main(String[] args) {
		//변수생성 및 형변환
		//가로의 길이가 7이고 세로의 길이가 10인 사각형의 넓이를 계산하여 출력하세요.
		int width1 = 7, height1 = 10;
		int square = width1*height1;
		System.out.println("사각형의 넓이 = "+ square);

		System.out.println("======================================================");
		//높이가 9이고 밑변의 길이가 7인 삼각형의 넓이를 계산하여 출력하세요.
		int height2=9, width2 = 7;
		double triangle = height2*width2/2.0;
		System.out.println("삼각형의 넓이 = "+triangle);
		

		System.out.println("======================================================");
		//10명의 전체 몸무게가 759Kg인 경우 평균 몸무게를 계산하여 출력하세요.
		int weight = 759, people = 10;
		double ave = (double) weight/people;
		System.out.println("평균 몸무게 = "+ave+"kg");

		System.out.println("======================================================");
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균을 계산하여 이름, 총점, 평균을 출력하세요.
		//단, 평균은 소숫점 한자리까지만 출력하고 나머지는 절삭 처리 하세요.
		String name = "홍길동";
		int kor = 89, eng = 93, math=95;
		int total = kor+eng+math;
		double ave2 = total/3.0; //실수형은 double 타입이 default
		System.out.println("이름 = "+ name +", 총점 = "+total+", 평균 = "+(int)(ave2*10)/10.0);
		System.out.println("======================================================");
	}
}