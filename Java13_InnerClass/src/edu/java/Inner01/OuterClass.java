package edu.java.Inner01;

public class OuterClass {
	// 멤버 변수
	private int value1;
	
	// 생성자
	public OuterClass(int value1) {
		this.value1 = value1;
	}
	
	//메소드 
	public void display() {
		System.out.println("value1 = " + value1);
	}
	
	class InnerClass{
		private int value2;
		
		public InnerClass(int value2) {
			this.value2 = value2;
			
		}
		// 외부 클래스의 멤버 변수는 내부 클래스에서 직접 사용이 가능
		public void setOuterValue(int value) {
			value1 = value;
		}
		public void printValues() {
			// 외부클래스의 멤버 변수 출력
			System.out.println("outer value : " + value1);
			// 내부클래스의 멤버 변수 출력
			System.out.println("inner value : " + value2);
		}
	}
}// end OuterClass
