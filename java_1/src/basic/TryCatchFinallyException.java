package basic;

public class TryCatchFinallyException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class c = Class.forName("java.lang.String2");
		}
		catch(ClassNotFoundException e){
			System.out.println("클래스가존재하지않습니다.");
		}
	}

}
