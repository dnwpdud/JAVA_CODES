package jeyeong.ver1089;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		1089
//		수열 : 규칙에 따라 나열된 수
//		문제 : 시작 값(a), 등차(d), 몇 번째인지를 나타내는 정수(n)가 입력될 때
//		n번째 수를 출력하는 프로그램을 만들어보자.
//		등차값: 규칙적으로 변하는 값
//		1. 입력 변수 : a 시작값, b 등차값, c n번째 값
//		2. a~100 범위 // a~100까지 for이용하여 등수차 만큼만 더 하여 출력하여 수열를 만든다.
//		3. for이 몇 번 반복된는지 카운트 해야한다. 
//		4. n번째수와 출력수가 같아지면 출력
		Scanner sc = new Scanner(System.in);
		//입력 변수 : a 시작값, b 등차값, c n번째 값
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = 1;// 몇 번 더 해졌는지 확인 값
		for(int i = a; i <= 100; i += b) {//a~100까지 만큼 더 하여 수열를 만든다.
			//System.out.println(i);
			if(d==c){// n번째수와 출력수가 같아지면 출력
				System.out.println(i);
			}
			d++;//카운트 값
		}
	}//end main()
}//end Main
//무한 루프가 일어나 시간초가 어디가 잘못되는지 모르겠음
