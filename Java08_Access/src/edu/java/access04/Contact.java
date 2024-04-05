package edu.java.access04;

//데이터 클래스(번호, 이름, 전화번호, 이메일)
public class Contact {
	// 멤버 변수
	private int no;
	private String name;
	private String pgone;
	private String email;

	public Contact() {
	}

	public Contact(int no, String name, String pgone, String email) {// 클래스을 사용하여 멤버변수 대입
		this.no = no;
		this.name = name;
		this.pgone = pgone;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPgone() {
		return pgone;
	}

	public void setPgone(String pgone) {
		this.pgone = pgone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [no=" + no + ", name=" + name + ", pgone=" + pgone + ", email=" + email + "]";
	}

}// Contact
