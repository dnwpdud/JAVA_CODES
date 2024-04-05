package jeyeong.HW6;

public class ContactVO {
	// 멤버 변수
	private int contacId;
	private String name;
	private String phone;
	private String email;
	
	// 기본 생성자
	public ContactVO() {}
	
	// 매개변수 생성자
	public ContactVO(int contacId, String name, String phone, String email) {
		super();
		this.contacId = contacId;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	// get/set
	public int getContacId() {
		return contacId;
	}
	public void setContacId(int contacId) {
		this.contacId = contacId;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// toString
	@Override
	public String toString() {
		return "ContactVO [contacId=" + contacId + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}// end ContactVO
