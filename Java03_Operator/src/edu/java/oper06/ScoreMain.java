package edu.java.oper06;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		System.out.println("총점 및 평균 계산 프로그램");
		// 1. 입력받은 준비 : Scanner 생성
		// 2. 국어, 영어, 수학 점수를 정수로 입력받아서 변수에 저장
		// 3. 국어, 영어, 수학 점수를 출력 
		// 4. 총점을 계산하여 출력
		// 5. 평균을 계산하여 출력(소수점 셋째자리까지)
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요 :");
		int a = sc.nextInt();
		System.out.println("수학 점수를 입력하세요 :");
		int b = sc.nextInt();
		System.out.println("영어 점수를 입력하세요 :");
		int c = sc.nextInt();
		System.out.println("국어 점수 :" + a);
		System.out.println("수학 점수 :" + b);
		System.out.println("영어 점수 :" + c);
		System.out.println("총점 점수 :" + (a+b+c));
		System.out.printf("총 평균 점수 : %.3f", (a+b+c) / 3.0);
		
	}// end main()

}// end 
