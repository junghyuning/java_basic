package basic;

//switch문에서 case의 값은 중복되어서는 안됨.
//실수값은 switch문에서 비교값으로 사용할 수 없음.
public class SwitchApp_08 {

	public static void main(String[] args) {
		int choice = 1;
		
		//break;문이 없기 때문에 case 1 이후 모든 명령문이 수행됨.
		switch(choice) {
		case 1: System.out.println("수성으로 이동합니다.");
		case 2: System.out.println("금성으로 이동합니다.");
		case 3: System.out.println("화성으로 이동합니다.");
		}
		System.out.println("====================================================================");

		choice = 4;
		//해당되는 case가 없으므로 아무런 명령도 수행되지 않음.
		switch (choice) {
		case 1: System.out.println("수성으로 이동합니다.");
		case 2: System.out.println("금성으로 이동합니다.");
		case 3: System.out.println("화성으로 이동합니다.");
		}
		System.out.println("====================================================================");
		
		
		//해당되는 case가 없어도 실행하고싶은것이 있을 시, default 사용
		switch (choice) {
		case 1: System.out.println("수성으로 이동합니다.");
		case 2: System.out.println("금성으로 이동합니다.");
		case 3: System.out.println("화성으로 이동합니다.");
		default: System.out.println("지구로 이동합니다.");
		}
		System.out.println("====================================================================");
		
		//break;문 사용례
		choice = 1;
		switch (choice) {
		case 1: System.out.println("수성으로 이동합니다."); break;
		case 2: System.out.println("금성으로 이동합니다."); break;
		case 3: System.out.println("화성으로 이동합니다."); break;
		default: System.out.println("지구로 이동합니다.");  break;
		}
		System.out.println("====================================================================");


		int jumsu=81;
		//변수값이 0~100 범위의 유효값인지 아닌지 구분하여 출력
		// 정상적인 값일때는 변수값을 이용해 등급을 나눔 100-90 : A / 89-80: b / 79-70:c / 69-60 :d / 59-0 : F
		// 가독성적인 측면에서는 switch 사용하는것이 좋음. but 등급구간이 일정하지 않을경우 사용할수 없는 경우가 발생할것. -> 확장성 안좋음.
		if(jumsu<=100 && jumsu>=0) {
			System.out.println("[결과] 0~100범위의 정상적인 점수가 입력되었습니다.");
			String grade = "";
			
			switch (jumsu/10) {
			case 10:
			case 9: grade = "A"; break;
			case 8: grade = "B"; break;
			case 7: grade = "C"; break;
			case 6: grade = "D"; break;
			default: grade = "F";
			}
			System.out.println("[결과] "+jumsu+"점 = "+ grade +"학점");
		} else {
			System.out.println("[에러] 0~100범위를 벗어난 비정상적인 점수가 입력되었습니다.");
			
		}
		System.out.println("====================================================================");

		String kor = "둘";
		String eng = "";
		
		switch (kor) {
		case "하나": eng="One"; break;
		case "둘": eng="Two"; break;
		case "셋": eng="Three"; break;
		}
		System.out.println("[결과]" + kor + " = " + eng);
		
		
		System.out.println("====================================================================");
		
		

	}

}
