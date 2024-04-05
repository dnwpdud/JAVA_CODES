package edu.java.array03;

import java.util.Scanner;

public class ArrayMain03 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		// n명의 학생 점수를 입력받아
		// 모든 점수, 총합, 평균을 출력(점수는 직접 입력)
		
		// 보너스) 최대값 최소값도 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("n명의 입력>");
		
//		int sum = 0;
//		int a = 0; // 입력변수 선언
//		int n = sc.nextInt();
//		int[] scores = new int[n];// n명의 학생 점수를 입력받아
//		
//		for(int i = 0; i < n; i++) {
//			a = sc.nextInt();//변수 입력
//			scores[i] = a;// 입력된 변수을 배열 0 ~ i까지 저장
//			sum += scores[i];
//			System.out.println(scores[i]);
//		} 
//		System.out.println("모든 학생의 총 점수 = " +sum);
//		System.out.println("학생들의 평균 값 = " +sum / n);
//		System.out.println("모든 학생들 중 1등 점수 = ");
		//내가 한거
		
		int n = sc.nextInt();
		int[] scores = new int[n];// n명의 학생 점수를 입력받아
		
		for(int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextInt();//변수 입력
		} 
		
		for(int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] = " + scores[i]);
		}
		
		// 모든 점수의 합 출력
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("모든 학생의 총 점수 = " +sum);
		
		// 평균 출력하기(소수점까지 표현)
		double avg = ((double)sum) / n;
		System.out.println("학생들의 평균 값 = " + avg);
		
		// 점수 최대값 출력
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] > max) {// 배열에 저장된 값이 max보다 큰 경우
				max = scores[i];
			}
		}
		System.out.println("최대값 = " + max);
		
		// 점수 최소값 출력
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] < min) {
				min = scores[i];
			}
		}
		System.out.println("최소값 = " + min);
		
		
	}// end main()

}// end ArrayMain03
