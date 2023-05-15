package jdbc;

/*
Class 객체(Clazz) 수동으로  생성하는 방법
1. Class.forName(String className) 메소드를 호출하여 반환받는 방법
2. Object.getClass() 메소드를 호출하여 현재 사용중인 Class 객체를 반환받는 방법
3. [클래스명.class] 형식으로 표현하는 방법
*/


public class Jdbc02_StaticBlockApp {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		  1.JVM은 ClassLoader 프로그램을 이용하여 클래스(Class 파일)를 읽어 메모리(Method영역)에 저장
		  2. new연산자로 메모리에 저장된 클래스(Class 객체 - Clazz)의 생성자를 호출 -> 객체(Object - Instance) 생성 - 메모리의 Heap영역에 객체 생성
		  => heap 영역의 경우 메모리에 이름을 부여 할 수 없음
		  3. 따라서 생성된 객체의 메모리주소(HashCode)를 제공받아 참조변수를 생성하여 저장 -> 참조변수는 메모리의 Stack 영역에 생성됨.
		 */
//		StaticBlock sb = new StaticBlock();
		
		//참조변수에 저장된 메모리주소로 객체를 참조하여 메소드를 호출 함.
//		sb.display();
		
//		1.JVM은 ClassLoader 프로그램을 이용하여 클래스(Class 파일)를 읽어 메모리(Method영역)에 저장 
//		=> but 수동으로 직접 파일을 불러와 메모리에 저장하는 방법이 있음 
//		=> Class. forName(String className) : 문자열로 표현된 패키지가 포함된 클래스를 전달받아 ClassLoader 프로그램을 사용하여 클래스를 읽어 메모리에 저장하는 메서드 ->  Class객체(Clazz) 반환
//		해당 패키지에 클래스가 없는경우 , ClassNotFoundException 발생함 -> try-catch (일단 귀찮으니 떠넘김)
		Class.forName("jdbc.StaticBlock");
		//스태틱 블럭 내에서 수행 함.
//		StaticBlock sb = new StaticBlock();
//		sb.display();
		
	}
}
