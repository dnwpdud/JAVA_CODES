package edu.java.contact02;

public class ContactVO {
	// 멤버 변수
	private String name;
	private String phone;
	private String emai;
	
	//기본 생성자
	public ContactVO() {}
	
	//매개 생성자
	public ContactVO(String name, String phone, String emai) {
		super();
		this.name = name;
		this.phone = phone;
		this.emai = emai;
	}
	
	// getter/setter 캡술화
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
		return "ContactDTO [name=" + name + ", phone=" + phone + ", emai=" + emai + "]";
	}
	
	
}//end ContactDTO
