package edu.java.sideproject;

import java.util.ArrayList;

public interface ManagerMyPageDAO {
////	- 부품 리스트 전체 검색(구매된 현황, 위치, 상품이동 중, 제작 중) //정보 전체 검색
//	public abstract ArrayList<PartManagementVO> selectALL();
//	
////	- 부품 리스트 검색(사용중 부품 리스트) // 연락처 정보 인덱스 검색
//	public abstract PartManagementVO select(int partIndex);
//	
	
//	- 부품 수정(수리거나 폐기 부품 확인하여 수정) // 연락처 정보 인덱스 수정
	public abstract int update(int partIndex, PartManagementVO vo);

//	- 부품 삭제(페기 잘못 등록 삭제) // 연락처 정보 인덱스 삭제
	public abstract int delete(int partIndex);
}// end ManagerMyPageDAO
