package edu.java.sideproject;

public interface EquipmentInformOracle {
	// 2. DB완 연동하기 위해 필요한 상수들을 정의

	public static final String EQUIPMENT_INFOMR_TABLE_NAME = "EX_EQUIPMENT_INFOMR";
	public static final String COL_EQUIPMENT_NAME = "EQUIPMENT_NAME";
	public static final String COL_EQUIPMENT_TYPE = "EQUIPMENT_TYPE";
	public static final String COL_PART_USE = "PART_USE";
	public static final String COL_PART_RATING = "PART_RATING";
	public static final String COL_PART_OUT_TIME = "PART_OUT_TIME";
	public static final String COL_EQUIPMENT_LOCATION = "EQUIPMENT_LOCATION";
	public static final String COL_USER_ID = "USER_ID";


	// INSERT INTO EX_PART_MANAGEMENT
	// VALUES (?, ?, ?, ?, ?, sysdate, ?, ?);

	// VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
	public static final String SQL_EQUIPMENT_INFOMR_INSERT = // 무조건 오류
			"INSERT INTO " + EQUIPMENT_INFOMR_TABLE_NAME
			+ " VALUES (?, ?, ?, ?, sysdate, ?, ?)";
	// SELECT * FROM EX_PART_MANAGEMENT
	// ORDER BY PART_INDEX;
//	- 부품 리스트 전체 검색(구매된 현황, 위치, 상품이동 중, 제작 중) // 전체검색
	public static final String SQL_EQUIPMENT_INFOMR_SELECT_ALL = 
			"SELECT * FROM " + EQUIPMENT_INFOMR_TABLE_NAME
			+ " ORDER BY " + COL_EQUIPMENT_NAME;

//	- 부품 리스트 검색(사용중 부품 리스트) // 검색
	// SELECT * FROM EX_CONTACT WHERE CONTACT_ID = ?
	public static final String SQL_SELECT_BY_COL_EQUIPMENT_INDEX = 
			"SELECT * FROM " + EQUIPMENT_INFOMR_TABLE_NAME + " WHERE "
			+ COL_EQUIPMENT_NAME + " = ?";

//	- 부품 수정(수리거나 부품 확인하여 수정) // 데이터 수정
	// UPDATE EX_PART_MANAGEMENT
	// SET
	// PART_NO = 1, PART_NAME = 'a', PART_CATEGORY = 'a', PART_RATING = 'a',
	// OUT_TIME = sysdate,
	// USER_INDEX = 1, MANAGER_INDEX = 1
	// WHERE PART_INDEX = ?
	public static final String SQL_EQUIPMENT_INFOMR_UPDATE = 
			"UPDATE " + EQUIPMENT_INFOMR_TABLE_NAME + " SET "
			+ COL_EQUIPMENT_TYPE + " = ?, " 
			+ COL_PART_USE + " = ?, " + COL_PART_RATING + " = ?, " 
			+ COL_PART_OUT_TIME + " = sysdate, " 
			+ COL_EQUIPMENT_LOCATION + " = ?, "
			+ COL_USER_ID + " = ? " 
			+ "WHERE " + COL_EQUIPMENT_NAME + " = ?";

//	- 부품 삭제(페기 잘못 등록 삭제) // 데이터 삭제
	// DELETE EX_PART_MANAGEMENT WHERE COL_PART_NO = ?
	public static final String SQL_EQUIPMENT_INFOMR_DELETE = "DELETE " + EQUIPMENT_INFOMR_TABLE_NAME + " WHERE "
			+ COL_EQUIPMENT_NAME + " = ?";

}// end EquipmentInformOracle
