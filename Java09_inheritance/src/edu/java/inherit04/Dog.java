package edu.java.inherit04;

public class Dog extends Animal{
	// 멤버 변수
	private String type;
	
	// 생성자 overloading
	public Dog() {}
	public Dog(String name,String type) {
		super(name);
		this.type = type;
	}
	
	// 메소드 제정의(override)
	// - 부모 클래스가 가지고 있는 메소드를 자식 클래스에서 재중의(다시 정의)
	// - 메소드의 리턴 타입, 이름, 매개변수 모두 부모 클래승의 메소드와 일치해야함
	
	@Override
	public void spaek() {
		System.out.println("멍멍");
	}
	
}// end Dogs
