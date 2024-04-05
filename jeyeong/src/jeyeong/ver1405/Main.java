package jeyeong.ver1405;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
// 강사님 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[(i + j) % n] + " ");
			}
			System.out.println();
		}
// 강사님 end
	}// end main()

}// end Main
