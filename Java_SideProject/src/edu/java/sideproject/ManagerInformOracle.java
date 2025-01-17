package edu.java.sideproject;

public interface ManagerInformOracle {
	// 2. DB완 연동하기 위해 필요한 상수들을 정의
	public static final String URL = "jdbc:oracle:thin:@192.168.0.113:1521:xe";// 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
//	테이블명 : EX_MANAGER_INFOR
//	MANAGER_INDEX(NUMBER)- 관리자 번호 - PK// 나중에 능력이 되면 VARCHAR2로 바뀌어 사번 만들기
//	MANAGER_ID(VARCHAR2) : 아이디 - NOT NULL
//	MANAGER_PASSWORD(VARCHAR2) : 비밀번호 - NOT NULL
//	MANAGER_NAME(VARCHAR2) : 관리자 이름 - NOT NULL
//	MANAGER_PHONE(VARCHAR2) : 부품 관리자 전화 번호 - NOT NULL
//	MANAGER_EMAIL(VARCHAR2) : 부품 관리자 이메일 - NOT NULL
//	MANAGER_INFOR_TIME(TIMESTAMP) : 관리자 회원정보 등록 시간
	
	public static final String MANAGER_INFORM_TABLE = "EX_MANAGER_INFORM";
	public static final String COL_MANAGER_INDEX = "MANAGER_INDEX";
	public static final String COL_MANAGER_ID = "MANAGER_ID";
	public static final String COL_MANAGER_PASSWORD = "MANAGER_PASSWORD";
	public static final String COL_MANAGER_NAME = "MANAGER_NAME";
	public static final String COL_MANAGER_PHONE = "MANAGER_PHONE";
	public static final String COL_MANAGER_EMAIL = "MANAGER_EMAIL";
	public static final String COL_MANAGER_INFOR_TIME = "MANAGER_INFOR_TIME";

	//- 회원정보 등록
	// INSERT INTO EX_MANAGER_INFOR
	// VALUES (?, ?, ?, ?, ?, ?, sysdate);
	public static final String SQL_MANAGER_INFORM_INSERT = 
			"INSERT INTO " + MANAGER_INFORM_TABLE 
			+ " VALUES (?, ?, ?, ?, ?, ?, sysdate)";
	
//	로그인 
//	"SELECT * FROM users WHERE username = ? AND password = ?"
	
}// end ManagerInforOracle
