package realization;

public class JdbcOracle implements Jdbc{
//	public void add() {
//		System.out.println("[Oracle]학생정보를 삽입하는 기능을 제공하는 메서드");
//	}                        
//	public void modify() {   
//		System.out.println("[Oracle]학생정보를 변경하는 기능을 제공하는 메서드");
//	}                       
//	public void remove() {  
//		System.out.println("[Oracle]학생정보를 삭제하는 기능을 제공하는 메서드");
//	}                        
//	public void search() {   
//		System.out.println("[Oracle]학생정보를 검색하는 기능을 제공하는 메서드");
//	}
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("[Oracle]학생정보를 삽입하는 기능을 제공하는 메서드");		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("[Oracle]학생정보를 변경하는 기능을 제공하는 메서드");
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("[Oracle]학생정보를 삭제하는 기능을 제공하는 메서드");
	}
	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("[Oracle]학생정보를 검색하는 기능을 제공하는 메서드");
	}
}
