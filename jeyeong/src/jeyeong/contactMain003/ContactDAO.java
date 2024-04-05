package jeyeong.contactMain003;

import java.util.ArrayList;

public interface ContactDAO {
	
		// 연락처 정보 등록
		public abstract int insert(ContactDTO dto);
		
		// 연락처 정보 전체 검색
		public abstract ArrayList<ContactDTO> select();
		
		// 연락처 정보 인덱스 검색
		public abstract ContactDTO select(int index);
		
		// 연락처 정보 인덱스 수정
		public abstract int update(int index, ContactDTO dto);// index 변수명 어떻게 할지 생각 해야함
		
		// 연락처 정보 저장 카운트
		public abstract int getCount();
		
		// 연락처 삭제 
		public abstract void selectContact();
	
}// end ContactDAO
