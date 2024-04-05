package edu.java.Inner06;

interface PersonInterface {
	public abstract void showInfo();

	public abstract void hello();
}


class Person {
	private String name;// 멤버 변수
	
	// 생성자
	public Person(String name) {
		this.name = name;
	}

	// 메소드
	public PersonInterface setAge(int age) {// 리턴 타입 : PersonInteface
		class PersonWithAge implements PersonInterface {//인터페이스 상속 받을수 있는 이유는 인터페이스가 상위 클래스여서
			private int age; // 지역 클래스의 멤버 변수			//사용이되고 내부에서 코드을작성 하면 문제없다.
			
			public PersonWithAge(int age) {
				this.age = age;
			}
			@Override
			public void showInfo() {
				System.out.println("이름 : " + name);
				System.out.println("나이 : " + age);
				

			}

			@Override
			public void hello() {
				System.out.println("안녕하세요!");
			}

		}// end PersonWithAge
		
		// 지역 클래스 객체(내용)을 모두 저장
		PersonWithAge instance = new PersonWithAge(age);// 조금 이해 안됨
		
		return instance;
	}// end setAge
}// end Person

public class InnerMain06 {

	public static void main(String[] args) {
		// 지역 클래스의 메소드들을 외부에서 사용하는 방법 :
		// 1. 지역 클래스의 메소드들을 선언한 인터페이스를 정의
		// 2. 지역 클래스가 인터페이스를 구현하도록 정의
		// 3. 다형성을 사용하여 메소드의 리턴타입으로 인터페이스를 사용할 수 있음
		Person p = new Person("목쌤");
		PersonInterface instance = p.setAge(24);
		instance.showInfo();
		instance.hello();

	}// end main()

}// end INnerMain06
