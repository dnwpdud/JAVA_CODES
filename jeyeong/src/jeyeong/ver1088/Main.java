package jeyeong.ver1088;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
// 		문제 :1부터 입력한 정수까지 1씩 증가시켜 출력하는 프로그램을 작성하되,
//		3의 배수인 경우는 출력하지 않도록 만들어보자.
//		1. 입력변수 (1~100)
//		2. 1부터 계속 출력하여 입력된 변수까지 출력
//		3. 단 3의 배수일 경우 출력하지않는다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//입력변수 (1~100)
		for(int i = 1; i <= n; i++ ) {//1부터 계속 출력하여 입력된 변수까지 출력
			if(i % 3 == 0) {
				System.out.print("");//단 3의 배수일 경우 출력하지않는다.
			}else {
				System.out.print(i+" ");
			}
		}
	}//end
}//end
//첫 번째로 스스로 성공
