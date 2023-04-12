package enumerate;

public class EnumApp {
	public static void main(String[] args) {
		//열거형을 출력할 경우, 초기화된 숫자가 아닌 이름이 제공됨
		System.out.println("삽입 = " + EnumOne.INSERT);
		System.out.println("변경 = " + EnumOne.UPDATE);
		System.out.println("삭제 = " + EnumOne.DELETE);
		System.out.println("검색 = " + EnumOne.SELECT);
		System.out.println("===============================================");
		System.out.println("삽입 = " + EnumTwo.ADD);
		System.out.println("변경 = " + EnumTwo.MODIFY);
		System.out.println("삭제 = " + EnumTwo.REMOVE);
		System.out.println("검색 = " + EnumTwo.SEARCH);
		System.out.println("===============================================");
		//숫자형에 저장하는것이 불가능해짐
		//int choice = EnumOne.DELETE; 
		//따라서 상수필드의 값을 숫자형으로 저장하기 위해서는, 
		EnumOne choice = EnumOne.DELETE;
		System.out.println("EnumOne.DELETE = " +  EnumOne.DELETE);
		System.out.println("choice = " + choice);
		
		switch(choice) {  
		//choice의 자료형 EnumOne -> 따라서 case 비교문은 무조건 EnumOne자료형의 요소임 -> 따라서 요소만 쓰면 되지, EnumOne.INSERT 이런식으로 쓰면 오류나는것. 
		//ex) switch(num)일때, case문에 int 1 이런식으로 쓰지 않음
		case INSERT:  //or case ADD  // EnumOne.INSERT 사용시 Error 
			System.out.println("# 학생정보를 삽입합니다.");
			break;                
		case UPDATE: 
			System.out.println("# 학생정보를 수정합니다.");
			break;                
		case DELETE: 
			System.out.println("# 학생정보를 삭제합니다.");
			break;                
		case SELECT: 
			System.out.println("# 학생정보를 선택합니다.");
			break;
		}

	}
}
