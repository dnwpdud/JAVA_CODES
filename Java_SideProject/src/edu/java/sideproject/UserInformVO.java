package edu.java.sideproject;

import java.util.Date;

public class UserInformVO {
	// 멤버 변수
	int userIndex;
	String userId;
	String userPassword;
	String userName;
	String userPhone;
	String userEmail;
	Date userInforTiem;
	
	public UserInformVO() {}
	
	public UserInformVO(int userIndex, String userId, String userPassword, String userName, String userPhone,
			String userEmail, Date userInforTiem) {
		this.userIndex = userIndex;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userInforTiem = userInforTiem;
	}
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getUserInforTiem() {
		return userInforTiem;
	}
	public void setUserInforTiem(Date userInforTiem) {
		this.userInforTiem = userInforTiem;
	}
	
	@Override
	public String toString() {
		return "UserInformVO [userIndex=" + userIndex + ", userId=" + userId + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", userInforTiem=" + userInforTiem + "]";
	}
	
	
}// end UserInforVO
