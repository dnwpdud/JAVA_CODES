package edu.java.homework;

import java.util.Scanner;

public class MemberServiceMain {

	public static void main(String[] args) {
		MemberService MemberServie = new MemberService();
		
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String password = sc.next();
		
		boolean result = MemberServie.login(id, password);// 매개변수 입력
		if(result) {//id와 password가 같을 경우 출력
			System.out.println("로그인 되었습니다.");
			MemberServie.logout("hong");
		}else {//id와 password가 다른 경우 출력
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
	}// end main()

}// end MemberSerbiceMain
