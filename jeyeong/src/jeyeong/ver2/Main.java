package jeyeong.ver2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		1. 입력값 설정(1~10)
//		2. 입력값 1~10까지 반복될떄 
//		3. 3, 6, 9 만 X가 출력이 되어야 한다.
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();// 입력값
		for(int i = 1; i <=a; i++) {// 1~a까지 출력 하는 반복 문
			if(i % 3 == 0) {// 3의 배수일떄 'X'가 출력 되는 조건문
				System.out.print( "X" +" ");
			} else {
			System.out.print(i + " ");
			}
		}

//{강사님 예시
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		
//		for(int i = 1; i <=n; i++) {
//			if(i % 3==0) {
//				System.out.print("X ");
//			}else {
//			System.out.print(i+ " ");
//			}
//		}
		
//}
		// 조건에 맡게 일일이 출력 해보고 확인 해봐야 한다.
		//ex) 1~9까지 먼저 출력하고 확인 되면/ 그 다음에 3의 배수를 'X'로 만든다.

	}// end main()

}// end Main
