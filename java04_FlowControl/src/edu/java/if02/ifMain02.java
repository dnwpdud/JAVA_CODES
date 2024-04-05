package edu.java.if02;

import java.util.Scanner;

public class ifMain02 {

	public static void main(String[] args) {
		System.out.println("if - else");
		//if(조건){본문}
		// else{본문}
		// - 조건이 참이면 본문 A가 실행 되고 거짓이면 본문B가 실행
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if(x > 0) {// 만약 x가 0보다 크면
			System.out.println("양수");
		} else {// 그게 아니면 (x <=0)
			System.out.println("0보다 크지 않음");
			
		}
		
	}// end main()

}// end ifMain02
