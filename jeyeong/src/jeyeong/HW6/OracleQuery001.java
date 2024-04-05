package jeyeong.HW6;

public interface OracleQuery001 {
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:xe";// 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";
	
	// 데이터 등록
	// INSERT INTO EX_CONTACT
	// VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?);
	
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME
			+ " VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?)";
	
	public static final String SQL_SELECT_ALL =
			"SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_CONTACT_ID;
	
	// 모든 데이터 중 검색한 CONATACT_ID 데이터 출력
	// SELECT * FROM EX_CONTACT WHERE CONTACT_ID = ?
	public static final String SQL_SLELCT_BY_CONTACT_ID =
			"SELECT * FROM " + TABLE_NAME +
			" WHERE " + COL_CONTACT_ID + " = ?";

	// 데이터 수정
	// UPDATE EX_CONTACT
	// SET NAME = ?, PHONE = ?, EMAIL = ?
	// WHERE CONTACT_ID = ?
	public static final String SQL_UPDATE = 
			"UPDATE " + TABLE_NAME + " SET " +
				COL_NAME + " = ?, " +
				COL_PHONE + " = ?, " +
				COL_EMAIL + " = ? " +
				"WHERE " + COL_CONTACT_ID + " = ?";
	
	// 데이터 삭제
	// DELETE EX_CONTACT WHERE CONTACT_ID = ?
	public static final String SQL_DELETE = 
			"DELETE " + TABLE_NAME + " WHERE " 
			+ COL_CONTACT_ID + " = ?";
	
}// end OracleQuery001
