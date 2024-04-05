package edu.java.loop03;

import java.util.Scanner;

public class LoopMain03 {

	public static void main(String[] args) {
		
//		1. 선택화면 출력한다.
//		2. 선택화면 출력을 반복한다.
//		ㄴ 종료를 선택하면 출력이 종료
//		3. 사용자가 선택할 수 있도록 변수 선언
//		ㄴ 변수의 타입 : 숫자
//		ㄴ 선택지 개수 : 4개
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("JAVA 은행");//1. 선택화면 출력한다.
		
		int balance = 0;
		boolean run = true; // while문 종료 여부
		
		while(run) {//2. 선택화면 출력을 반복한다.
			System.out.println("---------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("---------------------------------");
			System.out.println("선택>");
			
			int choice = sc.nextInt();//ㄴ 변수의 타입 : 숫자
			int money = 0;
			switch(choice){//3. 사용자가 선택할 수 있도록 변수 선언
//			ㄴ 선택지 개수 : 4개
			case 1:
				System.out.println("예금액>");
				money = sc.nextInt();
				balance += money;
				break;
			case 2: 
				System.out.println("출금액>");
			    money = sc.nextInt();
				balance -= money;
				break;
			case 3: 
				System.out.println("잔고>" + balance);
				break;
			case 4:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("선택지에 없는 번호 입니다. 다시 선택해 주세요.");
					break;
			}
		}
	}// end main()

}// end LoopMain03
