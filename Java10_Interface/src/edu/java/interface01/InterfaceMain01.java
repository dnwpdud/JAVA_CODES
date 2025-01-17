package edu.java.interface01;

import java.util.Scanner;

// 인터페이스(Interface) :
// 1. 인터패이스의 보든 메소드는 public abstract로 선언(Java 7버번까지)
// 	-> public abstract 수식어 생략 가능
// 2. 인터페이스의 모든 멤버 변수는 public static final로 선언
// 	-> public static final 수식어 생략 가능
// 3. 인터페이스를 선언 할때는 interface 키워드 사용
// 4s. 인터페이스를 구현(상속)하는 클래스는 implements 키워드 사용
// 5. 클래스는 다중 상속이 불가능
// 	(예) Class Child extends Parent1, Parent2(x)
// 6. 인터페이스는 다중 구현이 가능
// 	(예) class Child implements Inter1, Inter2(o)
public class InterfaceMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력>");
		String id = sc.next();
		System.out.println("비밀번호 입력>");
		String pw = sc.next();
		sc.close();
		
//		DataBaseQuery db = new DataBaseQuery(); 
		// 인터페이스는 인스턴스 생성이 불가능
		
		DataBaseQuery db = new OracleDatabaseQuery(); // 다형성
		int result = db.insert(id, pw);
		if(result > 0) {
			System.out.println("insert 성공");
		} else {
			System.out.println("intsert 실패");
		}
		
		
	}// end main()

}// end InterfaceMain01
