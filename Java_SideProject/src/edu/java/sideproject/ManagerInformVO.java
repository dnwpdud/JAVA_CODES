package edu.java.sideproject;

import java.util.Date;

public class ManagerInformVO {
	// 멤버 변수
	int managerIndex;
	String managerId;
	String managerPassword;
	String managerName;
	String managerPhone;
	String managerEmail;
	Date managerInforTiem;
	
	public ManagerInformVO() {}
	public ManagerInformVO(int managerIndex, String managerId, String managerPassword, String managerName,
			String managerPhone, String managerEmail, Date managerInforTiem) {
		this.managerIndex = managerIndex;
		this.managerId = managerId;
		this.managerPassword = managerPassword;
		this.managerName = managerName;
		this.managerPhone = managerPhone;
		this.managerEmail = managerEmail;
		this.managerInforTiem = managerInforTiem;
	}
	
	public int getManagerIndex() {
		return managerIndex;
	}
	public void setManagerIndex(int managerIndex) {
		this.managerIndex = managerIndex;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public Date getManagerInforTiem() {
		return managerInforTiem;
	}
	public void setManagerInforTiem(Date managerInforTiem) {
		this.managerInforTiem = managerInforTiem;
	}
	
	@Override
	public String toString() {
		return "ManagerInformVO [managerIndex=" + managerIndex + ", managerId=" + managerId + ", managerPassword="
				+ managerPassword + ", managerName=" + managerName + ", managerPhone=" + managerPhone
				+ ", managerEmail=" + managerEmail + ", managerInforTiem=" + managerInforTiem + "]";
	}
	
	
	
	
}// end ManagerInforVO
