package edu.java.method02;

public class MethodMain02 {
	
	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
	// 메소드 이름 : add
	// 리턴타입 : int 
	// 매개변수 : int x, int y
	public static int add(int x, int y) {
//		int result = x + y;
		return x + y;
	}// end add()
	
	// 기능 : 두 개의 정수를 매개변수로 전달받아서 , 두 정수의 차를 리턴
	// 메소드 이름 : sub
	// 리턴타입 : int
	// 매개변수 : int x, int y
	
	public static int sub(int x, int y) {
		return x - y;
//		return Math.abs(x - y);
	}// end sub()

	// 기능 : 두 개의 실수를 매개변수로 전달받아서, 두 실수의 곱을 리턴
	// 매소드 이름 : mu1
	// 리턴타입 : double
	// 매개변수 : double x, double y
	
	public static double mu1(double x, double y) {
		return x * y;
	}// end mu1
	
	// 기능 : 두 개의 실수를 매개변수로 전달받아서, x를 y로 나눈 값을 리턴
	// 매소드 이름 : div
	// 리턴타입 : double
	// 매개변수 : double x, double y
	
	public static double div(double x, double y) {
		return x / y;
	}
	
	public static void main(String[] args) {
		
		System.out.println("메소드 연습");
		
		int result = add(10, 20);
		System.out.println("result = " + result);
		
		result = sub(20, 10);
		System.out.println("result = " + result);
		
		double m = mu1(1.5, 2.0);
		System.out.println("m = " + m);
		
		double d =div(3, 2);// 자동 형 변환 가능성을 염두
		System.out.println("d = " + d);
		
	}// end main()

}// MethodMain02
