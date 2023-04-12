package nested;

import nested.OuterOne.InnerOne;

public class OuterOneApp {
	public static void main(String[] args) {
		OuterOne outerOne = new OuterOne(100);
		outerOne.outerDisplay();
		System.out.println("============================================");
		//객체 내부클래스의 생성자 호출하는 객체 생성 불가
		//InnerOne innerOne = new InnerOne(200); // 불가
		
		//innerclass 사용하고 싶다면?
		
		InnerOne innerOne = outerOne.new InnerOne(200); //외부클래스의 객체 통해 내부클래스객체 생성.
		//but 원래 innerclass는 외부클래스에서 사용하기 위한 class 이므로 굳이 사용하지 않는것이 좋음.
		
		innerOne.innerDisplay();
		System.out.println("================================================");
		
		
	}

}
