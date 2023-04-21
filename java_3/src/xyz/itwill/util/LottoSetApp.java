package xyz.itwill.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45범위 정수 난수값 6개 제공받아 출력하는 프로그램 작성
//=> 6개의 난수값은 서로 중복되지 않도록 작성하며 오름차순 정렬하여 출력
public class LottoSetApp {
	public static void main(String[] args) {
		Set<Integer> lottoSet= new HashSet<Integer>();
		Random random = new Random();
		
		while(true) {
			//1~45 범위의 난수값(Integer 객체)를 Set 객체의 요소로 저장
			//=> Set 객체에는 동일한 객체를 요소로 저장 불가.
			lottoSet.add(random.nextInt(45)+1);
			
			if(lottoSet.size()==6) break;
		}
		
		Integer[] lottoIntegers = lottoSet.toArray(new Integer[0]);
		
		Arrays.sort(lottoIntegers);
		
		System.out.print("행운의 숫자 =" + Arrays.toString(lottoIntegers));
		
	}

}
