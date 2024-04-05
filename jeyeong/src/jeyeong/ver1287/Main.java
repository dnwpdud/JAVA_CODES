package jeyeong.ver1287;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j ++) {
				System.out.print("*");
			}// for j end
			System.out.println();
		}// for i end
		
	}// end main

}// end Main
