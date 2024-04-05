package jeyeong.ver4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(i % 10 == 1) {
				count++;
			}//if 1.9
		}//for1
		System.out.println(count);
	}// end main()

}// end Main
