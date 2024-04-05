package jeyeong.contactMain003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ContactMain03{
	private static Scanner sc; // 클래스 맞는 변수 선언
	private static ContactDAO dao; // ContactDAO 인스턴스를 저장할 변수
	public static List<ContactDTO> list = new ArrayList<>();// List<ContactDTO> 인스턴스
	
	public static void main(String[] args) {
		System.out.println("연락처 관리 프로그램 version 0.3");
		
		sc = new Scanner(System.in); // main에 인스턴스하여 사용
//		dao = ContactDAOImple.getInstance();// 다형성. 싱글톤 인스턴스 생성
		
		boolean run = true;
		while (run) {
			showMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case Menu.MENU_INSERT:
				insertContact();
				break;
			case Menu.MENU_SELECT_ALL:
				selectallContact();
				break;
			case Menu.MENU_SELECT:
				select();
				break;
			case Menu.MENU_UPDATE:
				updateContact();
				break;
			case Menu.MENU_QUIT:
				run = false;
				break;
			case Menu.MENU_DELETE:
				selectContact();
				break;
			default:
				System.out.println("다시 선택해세요.");
				break;
			}
		}
		
		sc.close();
	}//end main()

	private static void selectContact() {
		int index = sc.nextInt();
		list.remove(index);
	}

	private static void updateContact() {// 완료
		System.out.println("수정할 인덱스 입력>");
		
		int index = sc.nextInt();
		System.out.println("이름 입력>");
		String nameCorrection = sc.next();
		list.get(index).setName(nameCorrection);
		System.out.println("전화번호 입력>");
		String phoneCorrection = sc.next();
		list.get(index).setPhone(phoneCorrection);
		System.out.println("이메일 입력>");
		String emaiCorrection = sc.next();
		list.get(index).setEmai(emaiCorrection);
		System.out.println("연락처 정보 수정 완료");
//		int index = sc.nextInt();
//		
//		int count = ((ContactDAOImple)dao).getCount();
//		if(index >= 0 && index < count) {
//			System.out.println("전화번호 입력>");
//			String phone = sc.next();
//			System.out.println("이메일 입력>");
//			String emai = sc.next();
//			
//			ContactDTO dto = new ContactDTO("", phone, emai);
//			int result = dao.update(index, dto);
//			if(result == 1) {
//				System.out.println("연락처 정보 수정 완료");
//			}
//			
//		}
		
	}

	private static void select() {
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();
		System.out.println(list.get(index).toString());
		
	}// end select

	private static void selectallContact() {
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("연락처 정보 [" + i + "]");
			System.out.println(list.get(i));
		}
		
	}// end selectallContact

	private static void insertContact() {// 완료
		System.out.println("--- 연락처 정보 등록 ---");
		System.out.println("이름 입력>");
		String name = sc.next(); // sc 변수가 메인에서 인스턴스에서 사용가능? or 메인 영역이 아니니까 그냥 사용?
		System.out.println("전화번호 입력>");
		String phone = sc.next();
		System.out.println("이메일 입력>");
		String emai = sc.next();
		
		ContactDTO dto = new ContactDTO(name, phone, emai);
		list.add(dto);
		if(list.size() == 1) {
			System.out.println("연락처 등록 완료");
		}
		
	}// end insertContact

	private static void showMainMenu() {
		System.out.println("----------------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제 | 0. 종료");
		System.out.println("----------------------------------------------------------");
		System.out.println("선택>");
	}// end showMainMenu
	

}//end ContactMain02

// 그냥 복사하고 붙어넣이 밖에 안함 의미없음
// 다시 만들어야 함
