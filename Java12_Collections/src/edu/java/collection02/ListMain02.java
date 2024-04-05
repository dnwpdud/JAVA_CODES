package edu.java.collection02;

import java.util.ArrayList;

class Student{
	// 멤버 변수
	private int stuNo;
	private String name;
	
	public Student() {}
		public Student(int stuNO, String name) {
			this.stuNo = stuNO;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "Student [stuNo=" + stuNo + ", name=" + name + "]";
		}
}// end Student

public class ListMain02 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(100);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("test");
		
		// Student 타입을 지정할 수 있는 ArrayList 인스턴스 생성
		ArrayList<Student> list3 = new ArrayList<>();
		
		list3.add(new Student(1, "kim"));
		Student stu1 = new Student(2,"park");
		list3.add(stu1);
		
		for(int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}
		
	}// end main()

}// end ListMain02
