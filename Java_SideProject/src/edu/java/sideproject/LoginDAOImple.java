package edu.java.sideproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import oracle.jdbc.OracleDriver;

public class LoginDAOImple implements LoginDAO, LoginOracle {
//	0. 인테페이스 상속 받기
//	1. 인터페이스 메소드 불러오기
	JFrame loginPaneFrame;
	
	private static LoginDAOImple LoginInstance = null;
	
//	1. 기본 생성자 만들기
	private LoginDAOImple() {}
	
	//	2. 싱글톤 만들기
	public static LoginDAOImple getLoginInstace() {
		if(LoginInstance == null) {
			LoginInstance = new LoginDAOImple();
		}
		return LoginInstance;
	}
	
//	4. 인터페이스 메소드 구현 하기

	@Override
	public boolean selectLoginManager(int no, String id, String pw) {
		
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_COL_MANAGER_INDEX);
			
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			
			rs = pstmt.executeQuery();
			//여기서 입력한 데이터가 없으니 실패가 출력된다.
			if(rs.next()) {// 여기 나중에 복습해야 함 이해가 잘 안 됨
				result = true;
			} else {
				result = false;
			}
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
	}

	@Override
	public boolean selectLoginUser(int no, String id, String pw) {
		
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_COL_USER_INDEX);
			
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			} else {
				result = false;
			}
			
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
	}// end selectLoginUser
}// end LoginDAOImple
