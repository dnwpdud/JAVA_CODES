package edu.java.homework;

public class 우제영_HW2 {

	public static void main(String[] args) {
// 1번 문제
		System.out.println("과제 1번");
		int[] a = {6, 8, 4, 2, 5};
		
		int max = 0;// 최대값 변수
		
		for(int i = 0; i < a.length; i++) {// 배열을 전부 비교하는 반복문
			if(max < a[i]) {//max 값과 비교하여 값이 a[i]크면 max 저장
				max = a[i];
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("--------------------------");
// 1번 문제 end	
// 2번 문제
		System.out.println("과제 2번");
		int sum = 0;// a[] 점수 총합
		for(int i = 0; i < a.length; i++) {// a[] 총합을 구하기 위한 for
			sum += a[i];
		}
		double average = (double)sum / a.length;// a[] 평균값
		System.out.println("a의 배열의 총합 : " + sum);
		System.out.println("평균값 : " + average);
		System.out.println("--------------------------");
// 2번 문제 end
// 3번 문제
		System.out.println("과제 3번");
		int[] fibonacci = new int[20];
		for(int i = 0; i < fibonacci.length; i++){
			if(i < 2) {//fibonacci[0~1]인 경우 1로 만든다.
			fibonacci[i] = 1;
			System.out.print(fibonacci[i] + " ");
			}else {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];// 피보나치 수열
			System.out.print(fibonacci[i] + " ");
			}
		}
		System.out.println();
		System.out.println("--------------------------");
// 3번 문제 end
// 4번 문제
		System.out.println("과제 4번");
		int[][] array = {
				{95, 86},
				{44, 22, 96},
				{78, 83, 93, 87, 88}
		};
		int max1 = 0;// array 최대값 변수
		int sum1 = 0;// array 총 합 변수
		int counter = 0;// 배열의 개수을 확인 하는변수
		
		for(int[] group : array) {//array[][]의 배열 확인 하기 위한 for
			for(int name : group) {//array[]의 배열을 sum변수에 전부 더하기위한 for과 카운터
				sum1 += name;
				counter++;
				if(max1 < name) {//max1 값과 비교하여 값이 name크면 max1변수에 저장
					max1 = name;
				}
			}
		}
		double average1 = (double)sum1 / counter;// array 평균값
		System.out.println("array의 배열의 총합 : " + sum1);
		System.out.println("평균값 : " + average1);
		System.out.println("최대값 : " + max1);
		System.out.println("--------------------------");
		
// 4번 문제 end
		//강사님 4번
//		int[][] array2 = {
//				{95, 86},
//				{44, 22, 96},
//				{78, 83, 93, 87, 88}
//		};
//		
//		System.out.println();
//		int count = 0;
//		int sum2 = 0;
//		int max2 = Integer.MIN_VALUE;
//		for(int i = 0; i < array2.length; i++) {
//			for(int j = 0; j < array2.length; j++) {
//				System.out.print(array2[i][j] + " ");
//				sum2 += array2[i][j];
//				count++;
//			}
//			System.out.println();
//		}
//		System.out.println("전체 합 = " + sum2);
//		System.out.println("평균 = " + ((double)sum2) / count);
//		
//		for(int i = 0; i < array2.length; i++) {
//			for(int j = 0; j < array2.length; j++) {
//				if(array[i][j] > max2) {
//					max2 = array2[i][j];
//				}
//			}
//		}
//		System.out.println("최대값 = " + max2);
		//강사님 4번 end
	}// end main()

}// end 우제영_HW2

//피드백 
// 1. 문제 max 패던 기억이 안나서 전꺼 확인 함
// 2. 평균값 실수로 표현하는거 기억이 안나서 전꺼 확인 함
// 3. 힌트을 정확히 확인 하지 못하여 오래걸림
// 4. 포이치문을 응용하여 배열의 처음 부터 끝까지 출력 후 나머지는 전부 응용으로 1 ~ 3 문제
// 그리고 다차원의 길이구하는 함수사용법은 몰라서 그냥 for문에 카운터 함
// Chat GPT의 물어본거 변수이름, 다차원 배열의 길이을 나태내는 함수, 최대값 코드

