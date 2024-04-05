package jeyeong.HW6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;


//JDBC : Java Database Connection
	//	  Java와 DB를 연결하기 위한 Java API
	//0. 데이터베이스 라이브러리를 프로젝트에 추가
	//- 프로젝트 오른쪽 클릭 
	//-> Build Path 
	//->Add External Archives to Java Build Path
	//-> C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
	//-> ojdbc6.jar 파일 선택
	// 1. 데이터 저장을 위한 DB 테이블 생성
	// 2. DB완 연동하기 위해 필요한 상수들을 정의
	// 3. Oracle JDBC 드라이버를 메모리에 로드
	// 4. DB와 Connection(연결)을 맺음
	// 5. Connection 객체를 사용하여 PreoaredStatement 객체를 생성
	// 6. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
	// 7. Statement 객체를 사용하여 SQL 문장을 실행(DB 서버로 SQL 문장을 전송)
	// 8. DB 서버가 보내준 결과를 확인/처리
	

//DAO(Data Access Object :
// - 데이터의 전소을 담당하는 역할
public class ContactDAOImple implements ContactDAO, OracleQuery001 {
	
	// 싱글톤 디자인 패턴 적용
	
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;
	
	// 2. private 생성자
	private ContactDAOImple() {
	}
	
	// 3. public static 메소드 - 인스터스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if(instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}
	
	// 전체 검색 데이터 list에서 size를 리턴
	public int getSize() {
		return select().size();
	}
	
	@Override
	public int insert(ContactVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		//						Statement와 상속 관계
		int result = 0;
		// 3. Oracle JDBC 드라이버를 메모리에 로드
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			// 6. SQL 문장 완서 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();
			System.out.println("로드");
			
			// 8. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삽입됐습니다.");
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

	@Override
	public ArrayList<ContactVO> select() {
		ArrayList<ContactVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// SELECT * FROM EX_CONTACT ORDER BY CONTACT_ID
			
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int contactId = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				
				ContactVO vo = new ContactVO(contactId, name, phone, email);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}// end select()

	@Override
	public ContactVO select(int contactId) {
		ContactVO vo = new ContactVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SLELCT_BY_CONTACT_ID);
			
			pstmt.setInt(1, contactId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				contactId = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				
				vo = new ContactVO(contactId, name, phone, email);
				System.out.println(vo);
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
	}// end select()

	@Override
	public int update(int contactId, ContactVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, contactId);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result + "행이 수정됐습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}

	@Override
	public int delete(int contactId) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_DELETE);
			
			pstmt.setInt(1, contactId);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result + "행이 삭제됐습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	

}// end ContactDAOImp
