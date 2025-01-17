package edu.java.sideproject;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import oracle.jdbc.OracleDriver;

public class EquipmentInformDAOImple implements EquipmentInformDAO, EquipmentInformOracle, PartManagementOracle{
//	0. 인테페이스 상속 받기
//	1. 인터페이스 메소드 불러오기
//	1. 기본 생성자 만들기
	Frame Equipmentframe;

	
//	1. 기본 생성자 만들기
	private EquipmentInformDAOImple() {}
	
//	2. 싱글톤 만들기
	private static EquipmentInformDAOImple EquipmentInformInstance = null;
	public static EquipmentInformDAOImple getEquipmentInform() {
		if(EquipmentInformInstance == null) {
			EquipmentInformInstance = new EquipmentInformDAOImple();
		}
		return EquipmentInformInstance;
	}
	
	public int getEquipmentInformSize() {
		return EquipmentInformSelectALL().size();
	}// 데이터의 인덱스을 저장
	
//	4. 인터페이스 메소드 구현 하기
	@Override
	public int EquipmentInformInsert(EquipmentInformVO vo) {
		// 3. DB완 연동하기 위해 필요한 상수들을 정의
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		try {
			// 4. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			// 5. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성(업그레이드)
			
			pstmt = conn.prepareStatement(SQL_EQUIPMENT_INFOMR_INSERT);
			
			try {
				pstmt.setString(1, vo.getEquipmentName());
				pstmt.setString(2, vo.getEquipmentType());
				pstmt.setInt(3, vo.getPartUse());
				pstmt.setString(4, vo.getPartRating());
				pstmt.setString(5, vo.getEquipmentLocation());
				pstmt.setString(6, vo.getUserId());
				
				// 7. SQL 문장 실행(DB 서버로 SQL 전송)
				result = pstmt.executeUpdate();
				
				// 8. DB 서버가 보내준 결과를 확인/처리
				System.out.println(result + "행이 삽이됐습니다.");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(Equipmentframe, "설비이름이 중복 됩니다.");
			}
			// 6. SQL 문장 작성
			
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
	}// end EquipmentInformDAOImple()

	@Override
	public ArrayList<EquipmentInformVO> EquipmentInformSelectALL() {
		ArrayList<EquipmentInformVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 완료");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 완료");
			
			pstmt = conn.prepareStatement(SQL_EQUIPMENT_INFOMR_SELECT_ALL);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String equipmentName = rs.getString(1);
				String equipmentType = rs.getString(2);
				int partUse = rs.getInt(3);
				String partRating = rs.getString(4);
				Date partOutTime = rs.getDate(5);// 중간에 이거 빠짐
				String equipmentLocation = rs.getString(6);
				String userId = rs.getString(7);
				
				EquipmentInformVO vo = new EquipmentInformVO(equipmentName, equipmentType
						, partUse, partRating, partOutTime, equipmentLocation, userId);
				list.add(vo);
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
		return list;
	}// end EquipmentInformSelectALL()

	@Override
	public EquipmentInformVO EquipmentInformSelect(String equipmentName) {
		EquipmentInformVO vo = new EquipmentInformVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_COL_EQUIPMENT_INDEX);
			
			pstmt.setString(1, equipmentName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String equipmentType = rs.getString(1);
				int partUse = rs.getInt(2);
				String partRating = rs.getString(3);
				String equipmentLocation = rs.getString(4);
				String userId = rs.getString(5);
				equipmentName = rs.getString(6);
				
				vo = new EquipmentInformVO(equipmentName, equipmentType
						, partUse, partRating, null, equipmentLocation, userId);
				System.out.println(vo);
			}  else {
				JOptionPane.showMessageDialog(Equipmentframe, "입력한 번호가 없습니다.");
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
		return vo;
	}// end EquipmentInformSelect

	@Override
	public int EquipmentInformUpdate(String equipmentName, EquipmentInformVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_EQUIPMENT_INFOMR_UPDATE);
			System.out.println("성공");
			try {
				pstmt.setString(1, vo.getEquipmentName());
				pstmt.setString(2, vo.getEquipmentType());
				pstmt.setInt(3, vo.getPartUse());
				pstmt.setString(4, vo.getPartRating());
				pstmt.setString(5, vo.getEquipmentLocation());
				pstmt.setString(6, vo.getUserId());
				
				result = pstmt.executeUpdate();
				System.out.println(result);
				if(result == 1) {
					System.out.println(result + "행이 수정됐습니다.");
				} 
//				else {
//					JOptionPane.showMessageDialog(Equipmentframe, "입력하신 설비이름이 없습니다.");
//				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(Equipmentframe, "모든 빈칸을 확인해 주세요.");
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
	}// end EquipmentInformUpdate

	@Override
	public int EquipmentInformDelete(String equipmentName) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_EQUIPMENT_INFOMR_DELETE);
			
			pstmt.setString(1, equipmentName);
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println(result + "행이 삭제됐습니다.");
			} else {
				JOptionPane.showMessageDialog(Equipmentframe, "입력하신 부품번호가 없습니다.");
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
	}// end EquipmentInformDelete
//	public int PaetUseSize{
//		
//		return
//	}
	
}// end EquipmentInformDAOImple
