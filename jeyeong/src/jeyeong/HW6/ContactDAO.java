package jeyeong.HW6;

import java.util.ArrayList;

public interface ContactDAO {
	// 연락처 정보 등록
	public abstract int insert(ContactVO vo);
	
	// 연락처 정보 전체 검색
	public abstract ArrayList<ContactVO> select();
	
	// 연락처 정보 인덱스 검색
	public abstract ContactVO select(int contactId);
	
	// 연락처 정보 인덱스 수정
	public abstract int update(int contactId, ContactVO vo);
	
	// 연락처 정보 인덱스 삭제
	public abstract int delete(int contactId);
	
}// end ContactDAO
