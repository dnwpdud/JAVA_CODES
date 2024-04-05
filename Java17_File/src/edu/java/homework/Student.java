package edu.java.homework;

import java.io.Serializable;

public class Student implements Serializable {
	
	String num;
	int math;
	int eng;

	public Student() {
	}

	public Student(String num, int math, int eng) {
		super();
		this.num = num;
		this.math = math;
		this.eng = eng;
	}
	// get/set 필요없음
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void displayInfo() {
		System.out.println("이름 : " + num);
		System.out.println("수학 : " + math);
		System.out.println("영어 : " + eng);
	}
	@Override
	public String toString() {// toString 필요 없어음
		return "Student [num=" + num + ", math=" + math + ", eng=" + eng + "]";
	}

}// end Student
