package edu.java.contact04;

import java.util.ArrayList;

public interface ContactDAO {
	
		// 연락처 정보 등록
		public abstract int insert(ContactVO vo);
		
		// 연락처 정보 전체 검색
		public abstract ArrayList<ContactVO> select();
		
		// 연락처 정보 인덱스 검색
		public abstract ContactVO select(int index);
		
		// 연락처 정보 인덱스 수정
		public abstract int update(int index, ContactVO vo);// index 변수명 어떻게 할지 생각 해야함
		
		// 연락처 정보 저장 개수 확인
		public abstract int getSize();
		
		// 연락처 정보 인덱스 삭제
		public abstract int delete(int index);

}// end ContactDAO
