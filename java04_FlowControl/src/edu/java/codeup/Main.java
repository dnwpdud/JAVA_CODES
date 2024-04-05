package edu.java.codeup;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int first  = 0;
		int second = 0;
		int third= 0;

		if (a <= b && a <= c) {
			if (b <= c) {
				first = a;
				second = b;
				third= c;
			} else {
				first = a;
				second = c;
				third= b;
			}
		} else if (b <= c && b <= a) {
			if (a <= c) {
				first = b;
				second = a;
				third= c;
			} else {
				first = b;
				second = c;
				third= a;
			}
		} else if (c <= a && c <= b) {

			if (b <= a) {
				first = c;
				second = b;
				third= a;
			} else {
				first = c;
				second = a;
				third= b;
			}

		}
		System.out.println(first + " "+second+" "+ third);

	} // end main()

} // end Main
