package edu.java.homework;

public class HW3 {

	public static void main(String[] args) {
		MyCircle sc = new MyCircle();// 매개변수
		System.out.println("반지름 : " + sc.radius);// 멤버변수 출력
		System.out.println("반지름 넓이 : " + sc.a());// 반지름 넓이 메소드 출력
		
		sc.radius = 5;
		System.out.println("반지름 : " + sc.radius);// 멤버변수 출력
		System.out.println("반지름 넓이 : " + sc.a());// 반지름 넓이 메소드 출력
		
		MyCircle sc2 = new MyCircle(10.0);// 매개변수
		System.out.println("반지름 : " + sc2.radius);// 멤버변수 출력
		System.out.println("반지름 넓이 : " + sc2.a());// 반지름 넓이 메소드 출력
		
	}// end main()

}// end HW3
