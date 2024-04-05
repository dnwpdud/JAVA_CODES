package edu.java.contact02;

public interface Menu {
	// 연락처을 기능을 선택 할수있는 멤버 변수
	static final int MENU_QUIT = 0; // 종료
	static final int MENU_INSERT = 1; // 등록
	static final int MENU_SELECT_ALL = 2; // 전체 검색
	static final int MENU_SELECT = 3; // 상세 검색
	static final int MENU_UPDATE = 4; // 수정
}// end Menu
// 피드백 MENU_QUIT 이름안바꺼서 전에 했던 코드와 중복이 될수 있다. 나중에 수정해야함(MANU)
