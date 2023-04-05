//oop = Object Oriented Programming
//현실에 존재하는 대상들을 모델링하여 클래스로 선언 -> 클래스로 객체를 생성 -> 객체의 요소(변수/메서드)로 프로그램을 작성하는 방법
//추상화 / 캡슐화 / 다형성 / 상속성
//객체 모델링 : 현실에 존재하는 대상을 속성(변수/필드)과 행위(메서드)로 구분하여 설계
//추상화(Abstraction) : 객체 모델링된 대상을 클래스로 선언 
//클래스는 배포 가능 -> 프로그램의 생산성 향상 / 유지보수 효율성 향상
//단점 : 클래스에서 기본으로 제공해주는 메서드만 사용 가능함.

package oop;


import java.util.Arrays;

//객체지향 방식으로 해보기  : 객체를 가지고 프로그램을 만들어주는 것을 말함 -> 우선 클래스와 클래스 내부에 정의된 메서드 및 변수가 필요.
//Arrays의 경우 이클립스에서 기본적으로 배포하는 클래스이므로 우리는 Arrays 클래스의 객체를 만들어 사용하면 됨.
public class ArraySortApp_02 {
	public static void main(String[] args) {
		int[] array = {30,50,10,40,20};
		//Arrays 클래스 : 배열의 요소를 제어하는 기능의 메소드를 제공하는 클래스
		//Arrays.toSting( Object[] array) : 매개변수를 통해 배열을 전달받아 배열의 모든 요소 값들을 문자열로 변환하여 반환하는 메서드.
		System.out.print("정렬 전>> " + Arrays.toString(array));
		System.out.println();
		//Arrays.sort(Object[] array) : 배열을 전달받아 배열의 모든 요소값들을 오름차순으로 정렬하는 메서드.
		Arrays.sort(array);
		System.out.print("정렬 후>> " + Arrays.toString(array));
	}

}
