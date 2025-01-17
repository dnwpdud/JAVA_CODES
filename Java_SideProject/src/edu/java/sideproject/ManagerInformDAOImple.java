package edu.java.sideproject;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class ManagerInformDAOImple implements ManagerInformDAO, ManagerInformOracle {
//	0. 인테페이스 상속 받기
//	3. 인터페이스 메소드 불러오기
//	1. 기본 생성자 만들기
	private static ManagerInformDAOImple managerInstance = null;
	
	private ManagerInformDAOImple() {}
//	2. 싱글톤 만들기
	
	
	public static ManagerInformDAOImple getManagerInformInstance() {
		if(managerInstance == null) {
			managerInstance = new ManagerInformDAOImple();
		}
		return managerInstance;
	}

//	4. 인터페이스 메소드 구현 하기
	@Override
	public int ManagerInforminsert(ManagerInformVO vo) {
		// 3. DB완 연동하기 위해 필요한 상수들을 정의
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		System.out.println("성공");
		
		try {
			// 4. Oracle JDBC 드라이버를 메모리에 로드
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			// 5. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성(업그레이드)
			pstmt = conn.prepareStatement(SQL_MANAGER_INFORM_INSERT);
			
			// 6. SQL 문장 작성
			// INSERT INTO EX_MANAGER_INFOR
			// VALUES (?, ?, ?, ?, ?, ?, sysdate);
			pstmt.setInt(1, vo.getManagerIndex());
			pstmt.setString(2, vo.getManagerId());
			pstmt.setString(3, vo.getManagerPassword());
			pstmt.setString(4, vo.getManagerName());
			pstmt.setString(5, vo.getManagerPhone());
			pstmt.setString(6, vo.getManagerEmail());
			
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();
			
			// 8. DB 서버가 보내준 결과를 확인/처리
			System.out.println(result + " 행이 삽입됐습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}// end ManagerInforminsert
	
}// end ManagerInformDAOImple
