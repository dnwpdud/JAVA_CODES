package edu.java.inherit08;

public class InheritMain08 {

	public static void main(String[] args) {
		
		Employee[] emps = {
				new Employee("홍길동"),
				new Manager("고길동", "과장")
		};
		emps[0].print();
		emps[1].print();
		
		EmployeeUtil.printEmployeeInfo(emps);
		
		
		
	}// end main()

}// end InheritMain08
