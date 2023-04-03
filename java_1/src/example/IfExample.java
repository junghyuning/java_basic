package example;

public class IfExample {
	public static void main(String[] args) {
		// 변수에 저장된 문자값을 출력하세요.
		// 단, 변수에 저장된 문자값이 소문자인 경우 대문자로 변환하여 출력하세요.(소->대 : -32)
		char mun = 'x';
		if (mun >= 'a' && mun <= 'z')
			mun -= 32; // mun = mun -32; mun은 char타입으로 int보다 작은 자료형이기 때문에 무조건 int로 변환하여 계산하기때문에 같다고 할 수
						// 없다.
						// 위와같은 형태를 사용하고 싶을 시, 연산값을 다시 char로 형변환 해줘야함. mun = (char)(mun -32);

		System.out.println("mun = " + mun);
		System.out.println("============================================================");

		// 변수에 저장된 정수값이 4의 배수인지 아닌지를 구분하여 출력하세요.
		int num = 345644;
		if (num % 4 == 0)
			System.out.println(num + " = 4의배수");
		else
			System.out.println("= 4의 배수가 아니다.");

		System.out.println("============================================================");
		// 올해가 평년인지 윤년을 구분하여 출력하세요.
		// => 년도를 4로 나누어 나머지가 0인 경우 윤년
		// => 위 조건을 만족하는 년도 중 100으로 나누어 나머지가 0인 경우 평년
		// => 위 조건을 만족하는 년도 중 400으로 나누어 나머지가 0인 경우 윤년
		int year = 2023;
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) { // 윤년 //비교를 여러번할 때 and 와 or 를 활용하여 한줄로 끝내는 법도
																			// 알아야함.
			System.out.println(year + "년은 윤년입니다.");
		} else {
			System.out.println(year + "년은 평년입니다.");
		}

		System.out.println("============================================================");
		// 이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		// 총점과 평균, 학점을 계산하여 이름, 총점, 평균, 학점을 출력하세요.
		// => 국어,영어,수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 강제 종료
		// System.exit(0) : 프로그램을 강제로 종료하는 메소드
		// => 평균을 이용한 학점 계산 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
		// => 평균은 소숫점 두자리까지만 출력하고 나머지는 절삭 처리 하세요.
		String name = "홍길동";
		int kor = 89, eng = 93, mat = 95;
		int tot = kor + eng + mat;
		double ave = tot / 3.0;
		String grade = "";

		// 아래 방식으로 하지 않고
		// if ((kor < 0 || kor > 100) || (eng < 0 || eng > 100) || (mat < 0 || mat >
		// 100)) System.exit(0);
		// 을 등급 결정문보다 앞에 사용하여 else문을 사용하지 않을 수 있음.
		boolean valid = false;  // 검증 = false , 검증x = true로 설정하여 검증되지 않은 점수가 입력될 경우 강제종료하도록 프로그래밍

		if (kor < 0 || kor > 100) {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 국어점수가 입력 되었습니다.");
			valid = true;
		}
		if (eng < 0 || eng > 100) {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 영어점수가 입력 되었습니다.");
			valid = true;
		}
		if (mat < 0 || mat > 100) {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 수학점수가 입력 되었습니다.");
			valid = true;
		}
		if (valid) {
			System.exit(0);
		}

		if (ave >= 90)
			grade = "A";
		else if (ave >= 80)
			grade = "B";

		else if (ave >= 80)
			grade = "C";
		else if (ave >= 80)
			grade = "D";
		else
			grade = "F";

		System.out
				.println("이름 = " + name + ", 총점 = " + tot + ", 평균 = " + (int) (ave * 100) / 100.0 + ", 학점 = " + grade);

		System.out.println("============================================================");

	}
}
