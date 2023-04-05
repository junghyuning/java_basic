package example;

public class ArrayExample {
	public static void main(String[] args) {
		//사람들의 나이를 저장한 배열 생성하여 참조변수에 저장		
		int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
		int tot=0;
		double ave = 0;
		//배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.
		for(int temp : age) {
			tot += temp;
		}
		ave = (double)tot/age.length;
		System.out.println("평균나이 = " + ave);
		
		System.out.println("===============================================================");
		//배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
		//ex) 10대 = 3명
		//    20대 = 4명
		//    ...
		//    60대 = 1명
		
		
		//우선 오름차순 정렬함
/*		for (int i=0; i<age.length; i++) {
			for(int j = i+1; j<age.length;j++) {
				if(age[i]>age[j]) {
					int temp = age[i];
					age[i] = age[j];
					age[j]= temp;
				}
			}
			System.out.print(age[i]+" ");
		}
		System.out.println(); */
		
		int[] count = new int[6];
		for(int i = 0; i<count.length; i++) {
			int cnt = 0;
			for(int j = 0; j<age.length; j++) {
				if(age[j]>=10*(i+1) && age[j]<10*(i+2)) {
					cnt ++;
				}
				count[i]=cnt;
			}
			System.out.println((i+1)*10 + "대 = " + count[i] +"명");
		}
		System.out.println("===============================================================");
		
		// 선생님풀이 (switch문)
		int[]cntt = new int[6];
		for(int nai : age) {
			/*ch (nai /10) {
			case 1 : cntt[0]++; break;
			case 2 : cntt[1]++; break;
			case 3 : cntt[2]++; break;
			case 4 : cntt[3]++; break;
			case 5 : cntt[4]++; break;
			case 6 : cntt[5]++; break; 이것 역시 규칙성을 찾으면 1줄로 완성 가능*/
			
			cntt[nai/10-1]++;
			
			}
		
		for(int i = 0; i<cntt.length;i++) {
			System.out.println((i+1)+"0대 ="+cntt[i]+"명");
		}
		
		
		System.out.println("===============================================================");
	}
	
}