package edu.java.sideproject;

public interface PartManagementOracle {
	// 2. DB완 연동하기 위해 필요한 상수들을 정의
		public static final String URL =
				"jdbc:oracle:thin:@192.168.0.113:1521:xe";// 접속할 오라클 DB 경로
		public static final String USER = "scott";
		public static final String PASSWORD = "tiger";
		
		public static final String PART_MANAGEMENT_TABLE_NAME = "EX_PART_MANAGEMENT";
		public static final String COL_PART_NO = "PART_NO";
		public static final String COL_PART_NAME = "PART_NAME";
		public static final String COL_PART_TYPE = "PART_TYPE";
		public static final String COL_PART_RATING = "PART_RATING";
		public static final String COL_MANUFACTURING_TIME = "MANUFACTURING_TIME";
		public static final String COL_MANAGER_INDEX = "MANAGER_INDEX";
		public static final String COL_PART_USE = "PART_USE";
//		- 부품 등록
//		- 부품 리스트 전체 검색(구매된 현황, 위치, 상품이동 중, 제작 중)
//		- 부품 삭제(페기 잘못 등록 삭제)
//		- 부품 수정(수리거나 부품 확인하여 수정)
//		- 부품 사용(사용중 리스트로 넘어간다) // 해야함
//		- 부품 리스트 검색(사용중 부품 리스트)
//		- 카테고리 //해야함 
//		========================================================
//		- 부품 등록
		// INSERT INTO EX_PART_MANAGEMENT
		// VALUES (?, ?, ?, ?, ?, sysdate, ?, ?);
		
		// VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
		public static final String SQL_PART_MANAGEMENT_INSERT = // 무조건 오류
				"INSERT INTO " + PART_MANAGEMENT_TABLE_NAME
				+ " VALUES (?, ?, ?, ?, sysdate, ?, ?)";
		//SELECT * FROM EX_PART_MANAGEMENT
		//ORDER BY PART_INDEX;
//		- 부품 리스트 전체 검색(구매된 현황, 위치, 상품이동 중, 제작 중) // 전체검색
		public static final String SQL_PART_MANAGEMENT_SELECT_ALL = 
				"SELECT * FROM " + PART_MANAGEMENT_TABLE_NAME + " ORDER BY " + COL_PART_NO;
		
//		- 부품 리스트 검색(사용중 부품 리스트) // 검색
		// SELECT * FROM EX_CONTACT WHERE CONTACT_ID = ?
		public static final String SQL_SELECT_BY_COL_PART_INDEX = 
				"SELECT * FROM " + PART_MANAGEMENT_TABLE_NAME + 
				" WHERE " + COL_PART_NO + " = ?";
		
//		- 부품 수정(수리거나 부품 확인하여 수정) // 데이터 수정
		// UPDATE EX_PART_MANAGEMENT
		// SET 
		// PART_NO = 1, PART_NAME = 'a', PART_CATEGORY = 'a', PART_RATING = 'a',
		// OUT_TIME = sysdate,
		// USER_INDEX = 1, MANAGER_INDEX = 1
		// WHERE PART_INDEX = ?
		public static final String SQL_PART_MANAGEMENT_UPDATE = 
				"UPDATE " + PART_MANAGEMENT_TABLE_NAME + " SET " +
						COL_PART_TYPE + " = ?, " +
						COL_PART_NAME + " = ?, " + 
						COL_PART_RATING + " = ?, " + 
						COL_MANUFACTURING_TIME + " = sysdate, " +
						COL_MANAGER_INDEX + " = ?, " + 
						COL_PART_USE + " = ? " + 
						"WHERE " + COL_PART_NO + " = ?";
		
//		- 부품 삭제(페기 잘못 등록 삭제) // 데이터 삭제
		// DELETE EX_PART_MANAGEMENT WHERE COL_PART_NO = ?
		public static final String SQL_PART_MANAGEMENT_DELETE = 
				"DELETE " + PART_MANAGEMENT_TABLE_NAME + " WHERE "
					+ COL_PART_NO + " = ?";
		
		
//		// - 카테고리 // 실험해봐야함
//		public static final String SQL_PART_CATEHORY = 
//				"SELECT " + COL_PART_INDEX + ", " + COL_PART_NAME + ", " 
//		+ COL_PART_CATEGORY + "FORM " + TABLE_NAME;
		
		
				
		
}// end PartManagementOracle
