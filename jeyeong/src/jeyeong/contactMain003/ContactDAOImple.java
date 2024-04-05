package jeyeong.contactMain003;

import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO{
	
	// 싱글톤 디자인 패턴 적용
		// 1. private static 자기 자신 타입의 변수 선언
		private static ContactDAOImple instance = null; 

		// 2. private 생성자 
		private ContactDAOImple() {}
		// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
		public static ContactDAOImple getInstance() {
			if(instance == null) {
				instance = new ContactDAOImple();
			}
			return instance;
		}
		
		private final int MAX = 100;
		private ArrayList<ContactDTO> list = new ArrayList<>();// 회원 정보를 저장할 배열
		private int count; // 배열에 저장될 데이터 개수 // size
		
		
	@Override
	public int insert(ContactDTO dto) {
		System.out.println("insert()");
		System.out.println("dto = " + dto);
		list.add(dto);
		count++;
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ArrayList<ContactDTO> select() { // 배열
		return list;
	}

	@Override
	public ContactDTO select(int index) {// 가져오다.
		return list.get(index);
	}

	@Override
	public int update(int index, ContactDTO dto) {
		list.get(index).setPhone(dto.getPhone());
		list.get(index).setEmai(dto.getEmai());
		return 1;
	}

	@Override
	public int getCount() {
		return count;
	}
	@Override
	public void selectContact() {
		
	}
	
	

}// end ContactDAOImple
