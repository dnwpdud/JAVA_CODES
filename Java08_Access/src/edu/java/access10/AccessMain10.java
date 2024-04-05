package edu.java.access10;


public class AccessMain10 {

	public static void main(String[] args) {
		
		PublicToilet toilet1 = PublicToilet.getInstance();// 이게 아마도 인스턴스 한것 같다.
		toilet1.setLocation("캠핑장");
		
		System.out.println(toilet1);
		System.out.println(toilet1.getInstance());
		
		System.out.println("---------------");
		PublicToilet toilet2 = PublicToilet.getInstance();
		
		System.out.println(toilet2);
		System.out.println(toilet2.getInstance());
		
		toilet2.setLocation("공연장");
		System.out.println(toilet1.getLocation());
		System.out.println(toilet2.getLocation());
		
	}// end main()

}// end AccessMain10
