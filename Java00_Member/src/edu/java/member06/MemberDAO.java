package edu.java.member06;

import java.util.ArrayList;

// * 인터페이스 DAO 메소드 설계 방식
// - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
// - 함수의 매개변수 : 전송되는 데이터 형태에 따라 선언
// - 함수의 이름 : 역할에 따라 이름 작성
public interface MemberDAO {
	
	// 회원 정보 등록
	public abstract int insert(MemberVO vo);
	
	// 회원 정보 전체 검색
	public abstract ArrayList<MemberVO> select();
	
	// 회원 정보 상세(아이디) 검색
	public abstract MemberVO select(String id);
	
	// 회원 정보 상세(아이디) 수정
	public abstract int update(String id, MemberVO vo);
	
	// 회원 정보 상세(아이디) 삭제
	public abstract int delete(String id);
	
}







