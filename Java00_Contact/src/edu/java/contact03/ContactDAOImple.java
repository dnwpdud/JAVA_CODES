package edu.java.contact03;

import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO {

	// 싱글톤 디자인 패턴 적용
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() {
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	private ArrayList<ContactVO> list = new ArrayList<>();// 회원 정보를 저장할 배열
	
	
	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public int insert(ContactVO vo) {
		System.out.println("insert()");
		System.out.println("vo = " + vo);
		list.add(vo);
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ArrayList<ContactVO> select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmai(vo.getEmai());
		return 1;
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		return 1;
	}



}// end ContactDAOImple
