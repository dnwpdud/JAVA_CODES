package edu.java.for01;

public class ForMain01 {

	public static void main(String[] args) {
		System.out.println("for 반복문");
		
		// 1~10까지 출력
		for(int x = 1; x<=10; x++) {
			System.out.println(x);
		}
		
		System.out.println("=========");
		
		for(int x = 1; x <= 9; x++) {
			if(x % 2 == 1) {
			System.out.println(x);
			}
		}
		
		// 15, 14, 13, 12, ... 1을 출력
		for(int x = 15; x >= 1; x--) {
			System.out.println(x);
		}
		
		

	}// end main

}// end ForMain01
