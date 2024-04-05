package edu.java.if07;

import java.util.Scanner;

public class IfMain07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		// Ctrl + Shifr + f : 코드 자동 정렬
		
		System.out.println("숫자 3개 입력>");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		// 입력된 3개의 숫자 중 가장 큰 수를 출력하시오.
		if(a>= b) {// a가 b보다 크거나 같은가?
			if (a >= c){// a가 c보다 크거나 같은가?
			System.out.println(a);
		}else{
			System.out.println(c);
		}
		}else if(b>=c){
				if(b>=a) {
					System.out.println(b);
				}else {
					System.out.println(a);
				}
			}else if(c>=a) {
				if(c>=b) {
					System.out.println(c);
				}else {
					System.out.println(b);
				}
			}
	}// end main()

}// end IfMain0
