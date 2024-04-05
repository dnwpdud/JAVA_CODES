package edu.java.access04;

public class AccessMain04 {

	public static void main(String[] args) {
		// 객체 생성 및 데이터 저장 방식 1
		
		Contact c1 = new Contact(0, "유재석", "010-2222-2222", "you@gmail.com");
		System.out.println(c1.toString());
		
		System.out.println();
		// 전화번호를 변경하라!
		
		c1.setPgone("010-4444-5555");
		System.out.println(c1.toString());
		
		// 객체 생성 및 데이터 저장 방식 2
		Contact c2 = new Contact();
		System.out.println(c2.toString());
		c2.setNo(1);
		c2.setName("박명수");
		c2.setPgone("010-3333-3333");
		c2.setEmail("park@gmail.com");
		System.out.println(c2.toString());
		
		// 3명의 연락처 정보를 배열로 묶음
		Contact[] contacts = new Contact[3];
		// 유재석 정보를 contacts[0]에 저장
		contacts[0] = c1;
		// 박명수 정보를 contacts[1]에 저장
		contacts[1] = c2;
		// 아이유 정보를 contacts[2]에 저장
		contacts[2] = new Contact(2, "아이유" , "010-2222-3333" , "iu@gmail,com");
		
//		for(Contact c : contacts) {
//			System.out.println(c.getNo());
//			System.out.println(c.getName());
//			System.out.println(c.getPgone());
//			System.out.println(c.getEmail());
//		}
		
		System.out.println("===================");
		for(Contact c : contacts) {// 포이치 문을 활용하여 Contact class의 배열을 전부 출력
			System.out.println(c.toString());
		}
		
	}// end main()

}// end AccessMain04
