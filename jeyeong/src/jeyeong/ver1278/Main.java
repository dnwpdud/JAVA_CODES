package jeyeong.ver1278;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();// 입력 값
		int b = 1;
		int c = 0;
		for(int i = 1; 1 > c; i++) {
			if(a / b >= 10) {
				System.out.println(i);
				c++;
			}else {
				b *=10;
			}
		}
	}//end main()
}//end
//실패 시간날때 해야함
