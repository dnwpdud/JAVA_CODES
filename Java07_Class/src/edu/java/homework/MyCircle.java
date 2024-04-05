package edu.java.homework;

public class MyCircle {
//	 1) 멤버 변수: double radius
//	 2) 생성자: 기본 생성자, 매개변수(double radius)가 있는 생성자
//	 3) 메소드: 원의 면적을 계산 (3.14 * radius * radius)
//	 4) MyCircle 인스턴스를 ClassMain03에서 생성하여 반지름 및 원 넓이 출력
	double radius;// 멤버변수
	public MyCircle() {
		
	}
	
	public MyCircle(double radius) {
		this.radius = radius;// 멤버변수를 기본메소드에 사용할수 있도록 작성
	}
	
	public double a() {
		return 3.14 * radius * radius;// 원의 넓이 공식
	}
	
}// end MyCircle
//피드백 : 문제 제대로 안 잃음!! 문제을 풀때나 코드을 작성할때 주석 작성!
