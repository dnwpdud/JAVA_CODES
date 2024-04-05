package edu.java.sideproject;

public interface UserOracle {
	// 2. DB완 연동하기 위해 필요한 상수들을 정의
		public static final String URL = "jdbc:oracle:thin:@192.168.0.113:1521:xe";// 접속할 오라클 DB 경로
		public static final String USER = "scott";
		public static final String PASSWORD = "tiger";
		
//		테이블명 : EX_USER_INFOR
//		USER_INDEX(NUMBER) : 사용자 번호 - PK
//		USER_ID(VARCHAR2) : 아이디 - NOT NULL
//		USER_PASSWORD(VARCHAR2) : 비밀번호 - NOT NULL
//		USER_NAME(VARCHAR2) : 사용자 이름 - NOT NULL
//		USER_PHONE(VARCHAR2) : 사용자 전화 번호 - NOT NULL
//		USER_EMAIL(VARCHAR2) : 사용자 이메일 - NOT NULL
//		MANAGER_INFOR_TIME(TIMESTAMP) : 사용자 회원정보 등록 시간

		
		public static final String USER_INFOR_TABLE = "EX_USER_INFORM";
		public static final String COL_USER_INDEX = "USER_INDEX";
		public static final String COL_USER_ID = "USER_ID";
		public static final String COL_USER_PASSWORD = "USER_PASSWORD";
		public static final String COL_USER_NAME = "USER_NAME";
		public static final String COL_USER_PHONE = "USER_PHONE";
		public static final String COL_USER_EMAIL = "USER_EMAIL";
		public static final String COL_USER_INFOR_TIME = "USER_INFOR_TIME";

		//- 회원정보 등록
		// INSERT INTO EX_USER_INFOR
		// VALUES (?, ?, ?, ?, ?, ?, sysdate);
		public static final String SQL_USER_INFOR_INSERT = 
				"INSERT INTO " + USER_INFOR_TABLE 
				+ " VALUES (?, ?, ?, ?, ?, ?, sysdate)";
		
//		로그인 
//		"SELECT * FROM users WHERE username = ? AND password = ?"

} // end UserOracle
