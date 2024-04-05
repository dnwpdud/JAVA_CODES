package edu.java.exception08;

import java.util.Scanner;

public class ExceptionMain08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			// try-catch를 사용하여 숫자가 정상적으로 입력되면 종료되도록
			// 코드 작성
			System.out.println("메뉴 선택");
			try {
				int choice = Integer.parseInt(sc.next());
				System.out.println("choice : " + choice);
				break;
			} catch (Exception e) {
				System.out.println("예외 : " + e.toString());
			}
		}
		System.out.println("프로그램이 종료 되었습니다.");
		sc.close();
		
		
	}// end main()

}// end ExceptionMain08
