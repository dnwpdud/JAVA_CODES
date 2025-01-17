package edu.java.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JDBCMain02 {
	// 2. DB완 연동하기 위해 필요한 상수들을 정의
		public static final String URL =
				"jdbc:oracle:thin:@localhost:1521:xe";// 접속할 오라클 DB 경로
		public static final String USER = "scott";
		public static final String PASSWORD = "tiger";
		
		public static final String TABLE_NAME = "EX_CONTACT";
		public static final String COL_CONTACT_ID = "CONTACT_ID";
		public static final String COL_NAME = "NAME";
		public static final String COL_PHONE = "PHONE";
		public static final String COL_EMAIL = "EMAIL";
		
	public static void main(String[] args) {
		System.out.println("JDBC 2 - update");
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 3. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 5. Connection 객체를 사용하여 STratement 객체를 생성
			stmt = conn.createStatement();
			
			// 6. SQL 문장 작성
//			  UPDATE EX_CONTACT
			//SET NAME = '둘리',
			//PHONE = '010-3333-3333',
			//EMAIL = 'dooli@test.com'
			//WHERE CONTACT_ID = 2;
			
			String sql_update = "UPDATE " + TABLE_NAME 
					+ " SET NAME = '둘리'," 
					+ "PHONE = '010-3333-3333',"
					+ "EMAIL = 'dooli@test.com' "// 공백 부분은 문장이 끝나기 때문이다.
					+ "WHERE " + COL_CONTACT_ID + " = 2";
				
					System.out.println(sql_update);
					
					
					// 7. SQl 문장을 실행(DB 서버로 SQL 전송
					// executeUpdate() : INSERT, UPDATE, DELETE를 처리할 때 사용
					// executeQuery() : SELECT를 처리할 때 사용
					
					int result = stmt.executeUpdate(sql_update);

					// 8. DB 서버가 보내준 결과를 확인/처리
					System.out.println(result +"행이 수정 됐습니다.");
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}// end main()

}// end JDBCMain02
