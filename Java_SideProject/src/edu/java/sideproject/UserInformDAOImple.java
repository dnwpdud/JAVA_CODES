package edu.java.sideproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class UserInformDAOImple implements UserInformDAO, UserOracle{
//	0. 인테페이스 상속 받기
//	3. 인터페이스 메소드 불러오기
//	1. 기본 생성자 만들기
	
//	2. 싱글톤 만들기
	private static UserInformDAOImple userInstance = null;
	
	private UserInformDAOImple() {}
	
	public static UserInformDAOImple getUserInformgetInstance() {
		if(userInstance == null) {
			userInstance = new UserInformDAOImple();
		}
		return userInstance;
	}
	
//	4. 인터페이스 메소드 구현 하기
	@Override
	public int UserInforminsert(UserInformVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareCall(SQL_USER_INFOR_INSERT);
			
			// INSERT INTO EX_USER_INFOR
			// VALUES (?, ?, ?, ?, ?, ?, sysdate);
			pstmt.setInt(1, vo.userIndex);
			pstmt.setString(2, vo.userId);
			pstmt.setString(3, vo.userPassword);
			pstmt.setString(4, vo.userName);
			pstmt.setString(5, vo.userPhone);
			pstmt.setString(6, vo.userEmail);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result + "행이 삽이 됐습니다.");
			
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
	}// end UserInforminsert


}// end UserInformDAOImple
