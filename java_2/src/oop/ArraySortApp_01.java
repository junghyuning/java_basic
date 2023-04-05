package oop;


//배열의 요소값을 오름차순 정렬되도록 저장하고 출력하는 프로그램
public class ArraySortApp_01 {
	public static void main(String[] args) {
		int[] array = {30,50,10,40,20};
		System.out.print("정렬 전>> ");
		for(int num : array) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		
		
		//배열 요소값을 선택 정렬 알고리즘을 사용하여 오름차순 정렬 - 저장
		//selection sort => 절차지향 프로그램 적 방법
		for(int i=0;i<array.length;i++) {
			for(int j =i+1; j<array.length;j++) {
				if(array[i]>=array[j]) {
					int temp = array[i];
					
					array[i]= array[j];
					array[j]=temp;
				}
			}
		}
		
		System.out.print("정렬 후>> ");
		for(int num : array) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		
		//객체지향 프로그램방식으로 작성해보기
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
