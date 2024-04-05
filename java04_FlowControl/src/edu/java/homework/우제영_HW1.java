package edu.java.homework;

import java.util.Scanner;

public class 우제영_HW1 {

	public static void main(String[] args) {
		//1번 문제
		for(int i = 'A'; i <= 'Z'; i++) {// A부터 Z까지 출력하는 반복문
			System.out.println((char)i);
		}// 피드백 바로 int말고 바로char 사용해서 출력 가능
		//1번 문제 end
		
		//2번 문제
		
		while(true) {
			int a = (int)(Math.random() * 6 + 1);//1 ~ 6까지 출력
			int b = (int)(Math.random() * 6 + 1);//1 ~ 6까지 출력
			if(a+b == 5) {// a + b = 5일때 출력 후 break; 아닐 경우 반복
				System.out.print("("+a+","+b+")");
				break;
			}else{
				System.out.print("("+a+","+b+")");
			}
		}
		//2번 문제 end
		
		//3번 문제
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();// 정해지지않는 n의 수 입력
//		int sum = 0;// 1 ~ n 까지의 합의 변수
//		for(int i = 1; i <= n; i++) {
//			if(i % 2 == 0) {//짝수일때 음수로 출력
//				System.out.println(i * -1);
//				sum += i * -1;
//			}else {//홀수일때 양수로 출력
//				System.out.println(i);
//				sum += i;
//			}
//		}
//		System.out.println("정해진값 = " + n);
//		System.out.println("100까지의 합의 값 = " + sum);
		//3번 문제 end
		//3번 강사님 
		int n = 1;
		int sum = 0;
		while(true) {
			if(n % 2 == 1) {
				sum = sum + n;
			}else {
				sum = sum - n;
			}
			if(sum >= 100) {
				break;
			}
			n++;
		}
		System.out.println("sum = "+ sum + ", n = "+ n);
		//3번 강사님
		
		//4번 
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//
		for(int i = 0; i <= 5; i++) {
			for(int j = 0; j <= 5; j++) {
				if(i >= j) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i > j) {
					System.out.print(" ");
				}else{
					System.out.println("*");
			}
			System.out.println();
		}
	}
		
	}// end main()

}// end 우제영_HW1

