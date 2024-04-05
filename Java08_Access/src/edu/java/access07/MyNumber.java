package edu.java.access07;

public class MyNumber {
	
	//멤버 변수
	private int number;
	
	// 생성자
	public MyNumber(int number) {
		this.number = number;
		
	}
	
	// private 멤버 변수를 간접 적으로 읽어오는 메소드 - getter
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	// private 멤버 변수를 간접 적으로 변경하는 메소드 - setter
	
	// 기능 : 현재 객체(this : MyNumber)의 number 변수와
	//		 매개변수 number를 더한 후, 현재 객체의 number에 저장
	//		 현재 객체의 number에 저장
	// 리턴차입 : MyNumber
	// 함수 이름 : add
	// 매개변수 : NyNumber number
	
	public MyNumber add(MyNumber number){
		this.number = this.number + number.number;
		return this;
		
	}
	
	
	
}// end MyNumber
