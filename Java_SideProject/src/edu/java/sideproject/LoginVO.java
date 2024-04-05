package edu.java.sideproject;

public class LoginVO {
	int Index;
	String Id;
	String Password;
	public LoginVO() {}
	
	public LoginVO(int index, String id, String password) {
		Index = index;
		Id = id;
		Password = password;
	}
	
	public int getIndex() {
		return Index;
	}
	public void setIndex(int index) {
		Index = index;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "LoginVO [Index=" + Index + ", Id=" + Id + ", Password=" + Password + "]";
	}
	
	
}// end LoginVO
