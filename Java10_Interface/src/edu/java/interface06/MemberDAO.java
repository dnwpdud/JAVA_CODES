package edu.java.interface06;

// 인터페이스 DAO 메소드 설계 방식
// - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
// - 함수의 매개변수 : 전송되는 데이터 형태에 따라 선언
// - 함수의 이름 : 역할에 따라 이름 작성

public interface MemberDAO {// implements에서 작업이 진행 되고 main 입력과 출력등 사용 할 수 있는 메소드 정의
	// 회원 정보 등록
	public abstract int insert(MemberVO vo); // toString
	
	// 회원 정보 전체 검색
	public abstract MemberVO[] select();// 배열 선언
	
	// 회원 정보 인덱스 검색
	public abstract MemberVO select(int index); // 배열의 인덱스
	
	// 회원 정보 인덱스 수정
	public abstract int update(int index, MemberVO vo);// 수정할 인덱스(index), toString(vo)
	
	// 회원 정보 카운트 변수 선언 
	public abstract int getCount();// 
	
	
}// end MemberDAO
