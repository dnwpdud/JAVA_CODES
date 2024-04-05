package edu.java.inherit04;

public class Animal {
	// 멤버 변수
	private String name;
	
	// 생성자
	public Animal() {
	}

	public Animal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void spaek() {
		System.out.println("동물이 말합니다.");
	}
	
	
}// end Animal
