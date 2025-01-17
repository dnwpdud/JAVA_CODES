package edu.java.sideproject;

import java.util.Date;

public class PartManagementVO {
//	컬럼
//	PART_INDEX(NUMBER) - 부품 인덱스 - PK
//	PART_NO(NUMBER) : 부품 번호 - 
//	PART_NAME(VARCHAR2) : 부품 이름 - NOT NULL
//	PART_CATEGORY(VARCHAR2) : 부품 종류 - NOT NULL
//	PART_RATING(VARCHAR2) : 부품 등급 - NOT NULL 
//	OUT_TIME(TIMESTAMP) : 나간 시간 
//	MANUFACTURING_TIME(VARCHAR2) : 제조일자 
//	USER_INDEX(VARCHAR2) : 사용자 번호 - FK
//	MANAGER_INDEX(VARCHAR2)- 관리자 번호 - FK
	// 멤버 변수
	private String partNo;
	private String partType;
	private String partName;
	private String partRating;
	private Date manufacturing;
	private String managerIndex;
	private int partUse;
	public PartManagementVO() {
	}
	public PartManagementVO(String partNo, String partType, String partName, String partRating, Date manufacturing,
			String managerIndex, int partUse) {
		this.partNo = partNo;
		this.partType = partType;
		this.partName = partName;
		this.partRating = partRating;
		this.manufacturing = manufacturing;
		this.managerIndex = managerIndex;
		this.partUse = partUse;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getPartType() {
		return partType;
	}
	public void setPartType(String partType) {
		this.partType = partType;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartRating() {
		return partRating;
	}
	public void setPartRating(String partRating) {
		this.partRating = partRating;
	}
	public Date getManufacturing() {
		return manufacturing;
	}
	public void setManufacturing(Date manufacturing) {
		this.manufacturing = manufacturing;
	}
	public String getManagerIndex() {
		return managerIndex;
	}
	public void setManagerIndex(String managerIndex) {
		this.managerIndex = managerIndex;
	}
	public int getPartUse() {
		return partUse;
	}
	public void setPartUse(int partUse) {
		this.partUse = partUse;
	}
	@Override
	public String toString() {
		return "PartManagementVO [partNo=" + partNo + ", partType=" + partType + ", partName=" + partName
				+ ", partRating=" + partRating + ", manufacturing=" + manufacturing + ", managerIndex=" + managerIndex
				+ ", partUse=" + partUse + "]";
	}
	
	
	
}// end PartManagementVO
