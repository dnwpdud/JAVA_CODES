package edu.java.inherit07;

class paretClass{
	private int x;
	public paretClass(int x) {
		System.out.println("paretClass(x) 생성자");
	}
	
	public int getX() {
		return x;
	}
}// end ParentClass

class ChildClass extends paretClass{
	private int y;
	
	public int getY() {
		return y;
	}
	
	public ChildClass(int x, int y) {
		super(x);
		this.y = y;
		System.out.println("ChildClass(x,y) 생성자");
	}
}

public class InheritMain07 {

	public static void main(String[] args) {
		
		paretClass class1 = new ChildClass(100, 200);// 다형성
		
		ChildClass class2 = new ChildClass(300, 400);
		
		paretClass class3 = new paretClass(100);
		
		class2.getX();
		class2.getY();
		
		class1.getX();
//		class1.getY();
		
		//class1은 ParentClass 타입으로 선언 했기 때문에
		// ChildClass에서 정의한 getY() 메소드를 사용할 수 없음
		// 다만, 실제 인스턴스는 ChildClass 타입이기 때문에
		// 강제 형 변환 (casting)을 하면, ChildClass가 가지고 있는 메소드 사용가능
		
		System.out.println(((ChildClass) class1).getY());
		ChildClass c = (ChildClass) class1;
		System.out.println(c.getY());
		
		
		
		

	}// end main()

}// end InheritMain07
