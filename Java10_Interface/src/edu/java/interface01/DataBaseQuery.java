package edu.java.interface01;

public interface DataBaseQuery {
	// 인터페이스 멤버 변수 : public static final
	public static final int DATABASE_VERSION = 1;
	//int DATABASE_VERSION = 1; 위에 코드와 같음
	
	// 인터페이스의 메소드 : public abstract
	public abstract int insert(String id, String pw);
	// 위에와 같이 생략 가능
	
}// end DataBaseQuery
