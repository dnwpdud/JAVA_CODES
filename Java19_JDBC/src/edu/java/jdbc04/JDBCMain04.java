package edu.java.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.java.jdbc03.ContactVO;
import oracle.jdbc.OracleDriver;

public class JDBCMain04 {
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
		System.out.println("JDBC 4 - select by contact_id");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs  = null; // select query 결과 저장할 클래스
		
		try {
			// 3. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 5. Connection 객체를 사용하여 Stratement 객체를 생성
			stmt = conn.createStatement();
			
			// 6. SQL 문장 작성
			// SELECT * FROM EX_CONTACT WHERE CONTACT_ID = 2;
			String sql_select_by_contact_id =
					"SELECT * FROM " + TABLE_NAME +
					" WHERE " + COL_CONTACT_ID + " = 2";
			System.out.println(sql_select_by_contact_id);
			
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = stmt.executeQuery(sql_select_by_contact_id);
			
			// 8. DB 서버가 보낸 결과 확인/처리
			// ResultSet.next() :
			// REsultSet에서 다음 행(row or record)이 있으면
			// true를 리턴하고, ResultSet이 가리키는 위치를 다음 위치로 변경
			
			
			if(rs.next()) {// 레코드가 존재할 떄까지
				int contactId = rs.getInt(1); // CONTACT_ID 컬럼
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4); // EMAIL 컬럼
				
				ContactVO vo = new ContactVO(contactId, name, phone, email);
				System.out.println(vo);
			}
			
			
			
					
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

}// end JDBCMain03
