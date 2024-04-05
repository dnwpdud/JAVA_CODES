package edu.java.sideproject;

import java.util.Date;

public class EquipmentInformVO {
//	EQUIPMENT_INDEX(NUMBER) 설비 인덱스 - PK
//	EQUIPMENT_NAME(VARCHAR2) 설비 이름 NOT NULL UNIQUE
//	EQUIPMENT_TYPE(VARCHAR2) 설비 종류 NOT NULL 
//	PART_USE(NUMBER) 부품 사용회수(가스회수와 같은 개념) 
//	PART_RATING(VARCHAR2) : 부품 등급 - NOT NULL (사용회수에 따라 달라짐
//	PART_TIME(TIMESTAMP) : 부품이 들어간 시간 NOT NULL 
//	EQUIPMENT_LOCATION(VARCHAR2) 설비 위치 NOT NULL 
//	USER_ID(VARCHAR2) 사용자 아이디(외래키) NOT NULL UNIQUE
//	MANAGER_ID(VARCHAR2)관리자 아이디(외래키) NOT NULL UNIQUE
	// 멤버 변수
	
	private String equipmentName;
	private String equipmentType;
	private int partUse;
	private String partRating;
	private Date partOutTime;
	private String equipmentLocation;
	private String userId;
	public EquipmentInformVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EquipmentInformVO(String equipmentName, String equipmentType, int partUse, String partRating,
			Date partOutTime, String equipmentLocation, String userId) {
		super();
		this.equipmentName = equipmentName;
		this.equipmentType = equipmentType;
		this.partUse = partUse;
		this.partRating = partRating;
		this.partOutTime = partOutTime;
		this.equipmentLocation = equipmentLocation;
		this.userId = userId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public int getPartUse() {
		return partUse;
	}
	public void setPartUse(int partUse) {
		this.partUse = partUse;
	}
	public String getPartRating() {
		return partRating;
	}
	public void setPartRating(String partRating) {
		this.partRating = partRating;
	}
	public Date getPartOutTime() {
		return partOutTime;
	}
	public void setPartOutTime(Date partOutTime) {
		this.partOutTime = partOutTime;
	}
	public String getEquipmentLocation() {
		return equipmentLocation;
	}
	public void setEquipmentLocation(String equipmentLocation) {
		this.equipmentLocation = equipmentLocation;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "EquipmentInformVO [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", partUse="
				+ partUse + ", partRating=" + partRating + ", partOutTime=" + partOutTime + ", equipmentLocation="
				+ equipmentLocation + ", userId=" + userId + "]";
	}
	
}// end EquipmentInformVO
