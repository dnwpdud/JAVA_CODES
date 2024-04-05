package edu.java.sideproject;

public interface LoginOracle {
	// 2. DB완 연동하기 위해 필요한 상수들을 정의
	public static final String URL =
			"jdbc:oracle:thin:@192.168.0.113:1521:xe";// 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String MANAGER_INFORM_TABLE = "EX_MANAGER_INFORM";
	public static final String COL_MANAGER_INDEX = "MANAGER_INDEX";
	public static final String COL_MANAGER_ID = "MANAGER_ID";
	public static final String COL_MANAGER_PASSWORD = "MANAGER_PASSWORD";
	
	public static final String USER_INFOR_TABLE = "EX_USER_INFORM";
	public static final String COL_USER_INDEX = "USER_INDEX";
	public static final String COL_USER_ID = "USER_ID";
	public static final String COL_USER_PASSWORD = "USER_PASSWORD";
	
	
//	SELECT * FROM EX_MANAGER_INFORM
//	WHERE MANAGER_INDEX = ? AND MANAGER_ID = ? AND MANAGER_PASSWORD = ?;
	
	public static final String SQL_SELECT_BY_COL_MANAGER_INDEX = 
			"SELECT * FROM " + MANAGER_INFORM_TABLE + 
			" WHERE " + COL_MANAGER_INDEX + " = ? " + "AND "
			+ COL_MANAGER_ID + " = ? " + "AND " 
			+ COL_MANAGER_PASSWORD + " = ?";
//	SELECT * FROM EX_MANAGER_INFORM
//	WHERE MANAGER_INDEX = ? AND MANAGER_ID = ? AND MANAGER_PASSWORD = ?;
	
	public static final String SQL_SELECT_BY_COL_USER_INDEX = 
			"SELECT * FROM " + USER_INFOR_TABLE + 
			" WHERE " + COL_USER_INDEX + " = ? " + "AND "
			+ COL_USER_ID + " = ? " + "AND " 
			+ COL_USER_PASSWORD + " = ?";
}// end LoginOracle
