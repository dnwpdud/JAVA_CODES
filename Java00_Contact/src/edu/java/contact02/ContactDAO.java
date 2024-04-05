package edu.java.contact02;

// - 데이터의 전소을 담당하는 역할DAO
public interface ContactDAO {
	
		// 연락처 정보 등록
		public abstract int insert(ContactVO dto);
		
		// 연락처 정보 전체 검색
		public abstract ContactVO[] select();
		
		// 연락처 정보 인덱스 검색
		public abstract ContactVO select(int index);
		
		// 연락처 정보 인덱스 수정
		public abstract int update(int index, ContactVO dto);// index 변수명 어떻게 할지 생각 해야함
		
		// 연락처 정보 저장 카운트
		public abstract int getCount();
	
}// end ContactDAO
