package jeyeong.ver1403;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
//		문제:k개의 숫자를 입력받고 그 숫자들을 두번 출력하시오.
//		입력 예) 
//		2
//		5 7
//		출력 예)
//		5
//		7
//		5
//		7
//		내가 설정한 목록
//		1. 숫자 몇번 입력 하는 변수
//		2. 몇번이나 입력 할 수 있도록 반복문 만들기
//		2. 입력 받는 변수을 배열에 대입 하기
//		3. 배열을 반복문을 사용 하여 2번 반복하기
		
		
		Scanner z = new Scanner(System.in);
		
		int n = 2;//배열이 2번 반복하기 위한 변수
		int a = z.nextInt();// 숫자 몇번 입력 하는 변수
		int[] x = new int[a];
		int b = 0;// 배열에 들어가는 변수
		for(int i = 0; i < a; i++) {
			int c = z.nextInt();
			x[i] = c;//입력 받는 변수을 배열에 대입 하기
		}
		
		for(int j = 0; j < n; j++) {//반복문을 사용 하여 배열을 2번 반복하기
			for(int i = 0; i < a; i++) {
				System.out.println(x[i]);
			}
		}
		
		
		
	}//end main()

}// end Main
// 두 번째로 통과 됨
