package edu.java.homework;

public class printer {
//	1. 함수 총 4종류 (int, double, String, boolean) 만들기
	public int println(int a){// int 값의 매개변수가 입력되면 출력
		System.out.println(a);
		return a;
	}
	
	public double println(double a){// double 값의 매개변수가 입력되면 출력
		System.out.println(a);
		return a;
	}
	
	public boolean println(boolean a){// boolean 값의 매개변수가 입력되면 출력
		System.out.println(a);
		return a;
	}
	
	public String println(String b) {// String 값의 매개변수가 입력되면 출력
		System.out.println(b);
		return b;
	}
	
	
	
}// printer
//느낌점: 많이 쉬움, 같은 오버 메소드을 사용경우 입력된 메소드 종류에 따라 자동으로 변환하여 출력
