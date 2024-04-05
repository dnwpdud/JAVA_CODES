package jeyeong.ver3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();//long 
		int m = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();
		
		for(int i = 0; i < n - 1; i++) {//for1
//			System.out.println(a); 과정 설명
			a = a * m + d;
		}//for1
		System.out.println(a);
	}//

}//
// for문에서 후반에 가서 값이 이상해지면 계산해야 한다.