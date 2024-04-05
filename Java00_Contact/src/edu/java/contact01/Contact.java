package edu.java.contact01;

// 데이터 클래스(이름, 전화번화, 이메일)
public class Contact {

	// 멤버 변수
	public String name;
	public String phone;
	public String emai;
	
	// 기본 생성자
	public Contact() {
		
	}

	
	// 매개 변수 생성자
	public Contact(String name, String phone, String emai) {
		this.name = name;
		this.phone = phone;
		this.emai = emai;
	}

	// getter/setter

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmai() {
		return emai;
	}


	public void setEmai(String emai) {
		this.emai = emai;
	}


	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", emai=" + emai + "]";
	}

	

}// end contact
