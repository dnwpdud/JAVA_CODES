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

public class PartManagementDAOImple implements PartManagementDAO, PartManagementOracle{
	
	Frame frame;
	
//	1. 인테페이스 상속 받기

//	3. 싱클톤 생성
	// 싱글톤 멤버 변수 
	private static PartManagementDAOImple instance = null;
	
	// 기본 생성자
	private PartManagementDAOImple() {}
	// 인스턴스를 리턴하는 메소드 구현
	public static PartManagementDAOImple getInstance() {
		if(instance == null) {
			instance = new PartManagementDAOImple();
		}
		return instance;
	}
	

	public int getSize() {
		return selectALL().size();
	}// 데이터의 인덱스을 저장
//	4. 각 메소드 구현
//	2. 인터페이스 메소드 구현
//	- 부품 등록
	@Override
	public int insert(PartManagementVO vo) {
		// 3. DB완 연동하기 위해 필요한 상수들을 정의
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		int result = 0;
		
		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			
			pstmt = conn.prepareStatement(SQL_PART_MANAGEMENT_INSERT);
			// 6. SQL 문장을 생성
//			- 부품 등록
			// INSERT INTO EX_PART_MANAGEMENT
			// VALUES (?, ?, ?, ?, ?, sysdate, ?, ?, ?);
			try {
				pstmt.setString(1, vo.getPartType());
				pstmt.setString(2, vo.getPartNo());
				pstmt.setString(3, vo.getPartName());
				pstmt.setString(4, vo.getPartRating());
				pstmt.setString(5, vo.getManagerIndex());
				pstmt.setInt(6, vo.getPartUse());

				
				result = pstmt.executeUpdate();
				System.out.println(result + "행이 삽입됐습니다.");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "번호가 중복 됩니다.");
			}
			
			// 7. Statement 객체를 사용하여 SQl 문장을 실행(DB 서버로 SQL 문장을 전송)
			
			// 8. DB 서버가 보내준 결과를 확인/처리
			
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
	}// end insert()
	//부품 리스트 전체 검색 // 무조건 오류 발생
	@Override
	public ArrayList<PartManagementVO> selectALL() {
		ArrayList<PartManagementVO> list = new ArrayList<>();
		// 3. DB완 연동하기 위해 필요한 상수들을 정의
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			
			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_PART_MANAGEMENT_SELECT_ALL);
			
			// 7. Statement 객체를 사용하여 SQl 문장을 실행(DB 서버로 SQL 문장을 전송)
			rs = pstmt.executeQuery();
			// 8. DB 서버가 보내준 결과를 확인/처리
			while(rs.next()) { 
				String partNo = rs.getString(1);
				String partType = rs.getString(2);
				String partName = rs.getString(3);
				String partRating = rs.getString(4); // 무조건 오류 발생
				Date manufacturing = rs.getDate(5);
				String managerIndex = rs.getString(6); 
				int partUse = rs.getInt(7); 
			
				PartManagementVO vo = new PartManagementVO(partType, partNo, partName
						, partRating, manufacturing, managerIndex, partUse);
				list.add(vo);
//				System.out.println(list); 고침 위에 list에 vo을 넣지않아 인식이 안된거임
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
	}// end selectALL()
	
	//부품 리스트 검색
	@Override
	public PartManagementVO select(String partNo) {// 월래 boolean이 아닌고PartManagementVO였음 DAO도 수정 해야함
		PartManagementVO vo = new PartManagementVO();
		// 3. DB완 연동하기 위해 필요한 상수들을 정의
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 4. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 5. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 6. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_SELECT_BY_COL_PART_INDEX);
			
			// 6. SQL 문장 작성
			pstmt.setString(1, partNo);
			
			
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
			
			// 8. DB 서버가 보내준 결과를 확인/처리
			if(rs.next()) {// 입력값이 DB에 있으면 list에 있는 VO값을 출력해준다.
				partNo = rs.getString(1);
				String partType = rs.getString(2);
				String partName = rs.getString(3);
				String partRating = rs.getString(4); // 무조건 오류 발생
				Date manufacturing = rs.getDate(5);
				String managerIndex = rs.getString(6); 
				int partUse = rs.getInt(7); 
				vo = new PartManagementVO(partType, partNo, partName
						, partRating, manufacturing, managerIndex, partUse);
				System.out.println(vo);
		
			} else {
				JOptionPane.showMessageDialog(frame, "입력한 번호가 없습니다.");
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
//		return a;// 3.15 야자 여기까지 함 나머지는 야자 메모장 참고하여 작성 순서 
		// 앞으로 할 내용 기능 추가등 적어 놓을 것이다.
		return vo;
	}// end select(String)
	
	//부품 수정
	@Override
	public int update(String partNo, PartManagementVO vo) {
		int result = 0;
		// 3. DB완 연동하기 위해 필요한 상수들을 정의
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 4. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			// 5. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_PART_MANAGEMENT_UPDATE);
			// 6. SQL 문장 작성
			try {
				pstmt.setString(1, vo.getPartType());
				pstmt.setString(2, vo.getPartName());
				pstmt.setString(3, vo.getPartRating());
//				pstmt.setDate(6,(java.sql.Date) vo. getOutTime());
				pstmt.setString(4, vo.getManagerIndex());
				pstmt.setInt(5, vo.getPartUse());
				pstmt.setString(6, vo.getPartNo());// 번호의 인텍스 순서을 잘못하여 논리적 오류 발생
				
				
				// 7. SQL 문장 실행(DB 서버로 SQL 전송)
				result = pstmt.executeUpdate();
				
				// 8. DB 서버가 보내준 결과를 확인/처리
				if(result == 1) {
					System.out.println(result + "행이 수정됐습니다.");
				} else {
					JOptionPane.showMessageDialog(frame, "입력하신 부품번호가 없습니다.");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "모든 빈칸을 확인해 주세요.");
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
	}// end update()
	
	//부품 삭제
	@Override
	public int delete(String partNo) {
		int result = 0;
		// 3. DB완 연동하기 위해 필요한 상수들을 정의
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 6. SQL 문장 작성
		// 7. SQL 문장 실행(DB 서버로 SQL 전송)
		// 8. DB 서버가 보내준 결과를 확인/처리
		
		try {
			// 4. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			// 5. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			
			pstmt = conn.prepareStatement(SQL_PART_MANAGEMENT_DELETE);
			
			
			pstmt.setString(1, partNo);
			
				result = pstmt.executeUpdate();
				if(result == 1) {
					System.out.println(result + "행이 삭제됐습니다.");
				} else {
					JOptionPane.showMessageDialog(frame, "입력하신 부품번호가 없습니다.");
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
	}// end delete()
	
}// end PartManagementDAOImple
