package student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

//학생정보를 관리하는 프로그램 작성
// 메뉴 선택에 따른 학생정보 삽입, 변경, 삭제, 검색 기능 제공
// => 입력과 출력은 프로그램에서 구현하고 데이터 처리는 DAO클래스의 메서드를 호출하여 처리함.
public class StudentCUIApp {
	// 키보드 입력스트림을 저장하기 위한 필드
	private BufferedReader in;

	public StudentCUIApp() {
		// 키보드로부터 문자열을 입력받기 위한 입력스트림을 생성하여 필드에 저장
		in = new BufferedReader(new InputStreamReader(System.in));
		String[] menu = { "1.학생정보 삽입", "2.학생정보 변경", "3.학생정보 삭제", "4.학생정보 검색", "5.학생목록 출력", "6.프로그램 종료" };
		System.out.println("〈〈 학생 관리 프로그램 〉〉");

		while (true) {
			// menu출력
			for (String item : menu) {
				System.out.println(item);
			}

			int choice;
			try {
				System.out.println("메뉴 선택[1~6] >> ");
				choice = Integer.parseInt(in.readLine());

				// throw new Exception() : 예외 발생시키기
				// =>메뉴 선택을 잘못한 경우 인위적으로 예외를 발생켜 예외처리문으로 넘어가게 하기 위함
				if (choice < 1 || choice > 6)
					throw new Exception();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("[error] wrong number");
				System.out.println();
				continue; // while문 재실행
			}
			System.out.println();

			if (choice == 6)
				break;

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				modifyStudent();
				break;
			case 3:
				removeStudent();
				break;
			case 4:
				searchStudent();
				break;
			case 5:
				displayAllStudent();
				break;
			}
			System.out.println();
		}

		// break문 실행시 while문의 바깥으로 이동하면서 종료 메세지 출력.
		System.out.println("[message] 학생 관리 프로그램을 종료합니다.");

	}

	public static void main(String[] args) {
		new StudentCUIApp();
	}

	// [1.학생정보 삽입] => 키보드로 학생정보를 입력받아 테이블에 삽입 및 결과출력
	public void addStudent() {
		System.out.println("###학생정보 삽입###");
		try {
			// 학번 입력 & 검증 : PK주의!
			// 키보드로 학생정보를 입력받아 저장 => 입력값 검증이 실패한 경우 재입력받도록
			int no; // 학번을 입력받아 저장하기 위한 변수
			while (true) { // 학번 입력값 검증 위한 반복문
				System.out.print("학번입력 >> ");
				String noTemp = in.readLine(); // 문자열로 입력받음
				if (noTemp == null || noTemp.equals(" ")) {
					System.out.println("[error]입력값이 없습니다. 학번을 반드시 입력해 주세요");
					continue;
				}
				// ^: 문자로 시작 , [0-9]{3} : 0~9범위의 숫자 3자리
				String noReg = "^[1-9][0-9]{3}$";
				if (!Pattern.matches(noReg, noTemp)) {
					System.out.println("학번은 4자리 숫자로만 입력해 주세요");
					continue;
				}
				no = Integer.parseInt(noTemp); // 문자열로 입력받은 학번을 정수값으로 변환하여 인티저 변수에 저장함.

				// 입력된| 학번이 STUDENT 테이블에 저장된 기존 학생정보의 학번과 비교 -> 중복일 경우 -> 재입력

				// 정상 형식의 학번을 전달받았을 경우, 기존 STUDENT 테이블에 저장된 학번을 검색하여 studentDTO 객체를 반환하는 DAO 메소드
				// 호출
				// =>null 반환 시 : 학생정보 미검색 = 추가가능한 학번 // StudentDTO 객체 반환시 = 학생정보 검색됐으므로 중복학번 기입.
				StudentDTO student = StudentDAOImpl.getDAO().selectStudent(no);

				if (student != null) { // 검색 성공한 경우
					System.out.println("[error] 이미 사용중인 학번을 입력하였습니다.");
					continue;
				}

				// 모든 검증에 성공하였을 경우, 반복문을 벗어남.
				break;

			}

			// 이름 입력 & 검증
			String name;// 이름을 저장하기 위한 변수
			while (true) {
				System.out.print("이름 입력 >> ");
				name = in.readLine();

				if (name == null || name.equals("")) {
					System.out.println("[입력오류]이름을 반드시 입력해 주세요.");
					continue;
				}

				// 이름에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String nameReg = "^[가-힣]{2,5}$";
				if (!Pattern.matches(nameReg, name)) {
					System.out.println("[입력오류]이름은 2~5 범위의 한글로만 입력해 주세요.");
					continue;
				}

				break;
			}

			// 전화번호 입력 & 검증
			String phone;// 전화번호를 저장하기 위한 변수
			while (true) {
				System.out.print("전화번호 입력 >> ");
				phone = in.readLine();

				if (phone == null || phone.equals("")) {
					System.out.println("[입력오류]전화번호를 반드시 입력해 주세요.");
					continue;
				}

				// 전화번호에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String phoneReg = "(01[016789])-\\d{3,4}-\\d{4}";
				if (!Pattern.matches(phoneReg, phone)) {
					System.out.println("[입력오류]전화번호를 형식에 맞게 입력해 주세요.");
					continue;
				}

				break;
			}

			// 주소 입력 & 검증
			String address;// 주소를 저장하기 위한 변수
			while (true) {
				System.out.print("주소 입력 >> ");
				address = in.readLine();

				if (address == null || address.equals("")) {
					System.out.println("[입력오류]주소를 반드시 입력해 주세요.");
					continue;
				}

				break;
			}

			// 생일입력 & 검증
			String birthday;
			while (true) {
				System.out.print("생년월일 입력 >> ");
				birthday = in.readLine();

				if (birthday == null || birthday.equals("")) {
					System.out.println("[입력오류] 생년월일을 반드시 입력해 주세요.");
					continue;
				}
				// 생년월일에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String birthdayReg = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
				if (!Pattern.matches(birthdayReg, birthday)) {
					System.out.println("[입력오류]생년월일을 형식에 맞게 입력해 주세요.");
					continue;
				}
				break;

			}
			// 키보드로 입력받은 학생 정보를 STUDENT 테이블에 행으로 삽입 - DAO 클래스의 메서드
			StudentDTO student = new StudentDTO(); // 학생정보를 저장하기 위한 DTO객체 생성
			// 키보드로 입력받은 값으로 StudentDTO객체 필드값 변경
			student.setNo(no);
			student.setName(name);
			student.setPhone(phone);
			student.setAddress(address);
			student.setBirthday(birthday);

			// 학생정보(StudentDTO 객체)를 전달받아 student 테이블에 삽입하는 StudentDAOImpl 클래스 사용
			// StudentDAOImpl.getDAO(); => StudentDAOImpl이 싱글톤 클래스 이므로, getDAO()를 통해 객체를
			// 생성함.
			// StudentDAOImpl의 객체가 insertStudent 메서드 사용하는 것.
			int rows = StudentDAOImpl.getDAO().insertStudent(student);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2.학생정보 변경 : 학번을 입력받아 검색 -> 해당 학생 변경
	public void modifyStudent() {
		System.out.println("### 학생목록 출력###");
		try {
			int no;
			while (true) {
				System.out.print("2. 학번 입력 >> ");
				String noTemp = in.readLine();	
				
				if(noTemp == null || noTemp.equals("")) {//입력값이 없는 경우
					System.out.println("[입력오류]학번을 반드시 입력해 주세요.");
					continue;//반복문 재실행 - 비정상적인 값 입력 : 재입력
				}
				
				//학번에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String noReg="^[1-9][0-9]{3}$";
				if(!Pattern.matches(noReg, noTemp)) {//정규표현식과 입력값의 입력패턴이 다른 경우
					System.out.println("[입력오류]학번은 4자리 숫자로만 입력해 주세요.");
					continue;	
				}
				
				no=Integer.parseInt(noTemp);
				
				StudentDTO student=StudentDAOImpl.getDAO().selectStudent(no);
				
				if(student == null) {//키보드로 입력된 학번의 학생정보가 검색된 경우 - 학번 중복
					System.out.println("[입력오류]해당 학번을 사용중인 학생이 존재하지 않습니다.");
					return;	//학번검색 항목에서 빠져나와 다시 실행중인 프로그램으로 돌아감.
				}
				
				System.out.println("==================================================");
				System.out.println("학번\t이름\t전화번호\t주소\t\t생년월일");
				System.out.println("==================================================");
				System.out.println(student);
				System.out.println("==================================================");
				
				//키보드로 학번을 제외한 값을 입력받아 저장 - 입력값 검증
				String name;//이름을 저장하기 위한 변수
				while(true) {
					System.out.print("이름 입력 >> ");
					name=in.readLine();
					
					//이름에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
					String nameReg="^[가-힣]{2,5}$";
					//입력 받지 않아도 괜찮음
					if(name != null && name != "" && !Pattern.matches(nameReg, name)) {
						System.out.println("[입력오류]이름은 2~5 범위의 한글로만 입력해 주세요.");
						continue;	
					}
					
					break;
				}
				
				String phone;//전화번호를 저장하기 위한 변수
				while(true) {
					System.out.print("전화번호 입력 >> ");
					phone=in.readLine();
					
					
					//전화번호에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
					String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
					if(phone != null && phone != "" && !Pattern.matches(phoneReg, phone)) {
						System.out.println("[입력오류]전화번호를 형식에 맞게 입력해 주세요.");
						continue;	
					}
					
					break;
				}
				
				String address;//주소를 저장하기 위한 변수
				while(true) {
					System.out.print("주소 입력 >> ");
					address=in.readLine();	
					break;
				}
				
				String birthday;//생년월일을 저장하기 위한 변수
				while(true) {
					System.out.print("생년월일 입력 >> ");
					birthday=in.readLine();
					
					//생년월일에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
					String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
					if(birthday != null && birthday != "" && !Pattern.matches(birthdayReg, birthday)) {
						System.out.println("[입력오류]생년월일을 형식에 맞게 입력해 주세요.");
						continue;	
					}
					
					break;
				}
				
				//변경값이 있는 경우에만 필드값을 변경 ( 입력값 없는 컬럼에 대해서는 이전 데이터가 유지됨)
				//studentDAO 객체에 변경값을 저장하는 과정.
				if(name!=null && !name.equals("")) student.setName(name);
				if(phone!=null && !phone.equals("")) student.setPhone(phone);
				if(address!=null && !address.equals("")) student.setAddress(address);
				if(birthday!=null && !birthday.equals("")) student.setBirthday(birthday);
				
				
				//학생정보를 전달받아 student 테이블에 저장된 정보를 변경하는 DAO클래스의 메서드 호출
				int rows = StudentDAOImpl.getDAO().updateStudent(student);
				System.out.println("==================================================");
				System.out.println("[메세지]학생 정보가 변경되었습니다.");
				System.out.println("==================================================");
				System.out.println("학번\t이름\t전화번호\t주소\t\t생년월일");
				System.out.println("==================================================");
				System.out.println(student);
				System.out.println("==================================================");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// 3.학생정보 삭제
	public void removeStudent() {
		System.out.println("### 학생목록 출력###");
		try {
			int no;
			while (true) {
				System.out.print("2. 학번 입력 >> ");
				String noTemp = in.readLine();	
				
				if(noTemp == null || noTemp.equals("")) {//입력값이 없는 경우
					System.out.println("[입력오류]학번을 반드시 입력해 주세요.");
					continue;//반복문 재실행 - 비정상적인 값 입력 : 재입력
				}
				
				//학번에 대한 입력패턴의 정규표현식을 작성하여 변수에 저장
				String noReg="^[1-9][0-9]{3}$";
				if(!Pattern.matches(noReg, noTemp)) {//정규표현식과 입력값의 입력패턴이 다른 경우
					System.out.println("[입력오류]학번은 4자리 숫자로만 입력해 주세요.");
					continue;	
				}
				
				no=Integer.parseInt(noTemp);
				break;
			}
			int rows = StudentDAOImpl.getDAO().deleteStudent(no);
			
			if(rows > 0 ) {//키보드로 입력된 학번의 학생정보가 검색된 경우 - 학번 중복
				System.out.println("[메세지] 해당 학생 정보를 삭제하였습니다.");
			} else {
				System.out.println("[메세지] 삭제할 학번의 학생정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
	

	// 4.학생정보 검색
	public void searchStudent() {
		System.out.println("### 학생정보 검색 ###");

		try {
			String name;
			while(true) {
				System.out.print("이름 입력 >> ");
				name=in.readLine();
				
				if(name == null || name.equals("")) {
					System.out.println("[입력오류]이름을 반드시 입력해 주세요.");
					continue;
				}
				
				String nameReg="^[가-힣]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("[입력오류]이름은 2~5 범위의 한글로만 입력해 주세요.");
					continue;	
				}
				
				break;
			}
			
			//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환
			//하는 DAO 클래스의 메소드 호출
			List<StudentDTO> studentList=StudentDAOImpl.getDAO().selectNameStudentList(name);
			
			
			if(studentList.isEmpty()) {
				System.out.println("[처리결과]검색된 학생정보가 없습니다.");
				return;
			}
			
			System.out.println("==============================================================");
			System.out.println("학번\t이름\t전화번호\t주소\t\t생년월일");
			System.out.println("==============================================================");
			for(StudentDTO student : studentList) {
				System.out.println(student);
			}
			System.out.println("==============================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// 5.학생목록 출력
	public void displayAllStudent() {
		System.out.println("### 학생목록 출력###");

		// Student 테이블에 저장된 모든 학생정보를 검색하여 반환하는 DAO 클래스의 메서드 호출
		List<StudentDTO> studentList = StudentDAOImpl.getDAO().selectAllStudentList();

		if (studentList.isEmpty()) {
			System.out.println("[처리결과] 저장된 학생정보가 없습니다.");
			return;
		}
		System.out.println("==================================================");
		System.out.println("학번\t이름\t전화번호\t주소\t\t생년월일");
		System.out.println("==================================================");
		// list 객체 요소를 제공받아 반복처리
		for (StudentDTO student : studentList) {
			System.out.println(student); // StudentDTO클래스의 toString 메서드 사용 -> 아까 오버라이딩했던 toSring의 return 형식으로 반환됨.

		}
	}
}
