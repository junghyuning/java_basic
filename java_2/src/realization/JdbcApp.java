package realization;

public class JdbcApp {
	public static void main(String[] args) {
		Jdbc mysql = new JdbcMysql();

		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		
		/*
		 * //클래스변경시, 메서드 이요부 또한 모두 다시 작성해야함 => 인터페이스로 작성시 편리해질수 있음. JdbcOracle oracle =
		 * new JdbcOracle();
		 * 
		 * oracle.add(); oracle.modify(); oracle.remove(); oracle.search();
		 */
		
		//객체간 결합도를 낮추기 위해 참조변수는 인터페이스를 사용하여 선언
		Jdbc jdbc = new JdbcMysql();
		
		//참조변수로 인터페이스의 추상메서드를 호출하면, 묵시적 객체 형변환에 의해 자식클래스의 객체를 참조하여 자식클래스의 메서드를 호출.
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
		
		//오라클 명령하고싶을시? => 참조변수는 그대로 - 참조하는 자손 객체만 변경 -> 느슨한 연결의 장점.
		jdbc = new JdbcOracle();
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
		
	}
}
