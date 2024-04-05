package edu.java.contact01;

import java.util.Scanner;


public class ContactMain01 {
	public static final int MENU_QUIT = 0; // 종료
	public static final int MENU_INSERT = 1; // 등록
	public static final int MENU_SELECT_ALL = 2; // 전체 검색
	public static final int MENU_SELECT = 3; // 상세 검색
	public static final int MENU_UPDATE = 4; // 수정

	public static final int MAX = 100; // 연락처 최대 저장 개수
	// 연락처 저장 배열
	public static Contact[] contactList = new Contact[MAX];
	
	public static int count = 0; // 배열에 데이터를 저장하면 증가

	public static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		Contact contact = new Contact();// 클래스 인스턴스
		
		contactList[count] = contact;// 배열에 저장
		boolean start = true;
		
		System.out.println("연락처 프로그램");

		while (start) {

			System.out.println("-------------------------------------------------");
			System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
			System.out.println("-------------------------------------------------");
			System.out.println("선택>");
			int choice = sc.nextInt();
			
			switch (choice) {
			case MENU_INSERT:
				insertContact();
				break;
			case MENU_SELECT_ALL:
				selectallContact();
				break;
			case MENU_SELECT:
				select();
				break;
			case MENU_UPDATE:
				updateContact();
				break;
			case MENU_QUIT:
				start = false;
				System.out.println("종료되었습니다.");
				break;
			default:
				System.out.println("그 외 선택");
				break;
			}
			
		}
	}// end main()
	
	// contact 배열에 contact 인스턴스를 저장
	public static void insertContact() {
		System.out.println("-------------");
		System.out.println("연락처 등록 메뉴");
		System.out.println("-------------");
		System.out.println("이름 입력>");
		String name = sc.next();
		System.out.println("전화번호 입력>");
		String phone = sc.next();
		System.out.println("이메일 입력>");
		String emai = sc.next();
		
		Contact contact = new Contact(name, phone, emai);
		// 배열에 저장(인덱스 0부터 순서대로)
		contactList[count] = contact;// count 번에 데이터 저장
		count++; // 등록이 수행될 때마다 1씩 증가
		System.out.println("등록된 연락처 개수 : " + count);
		System.out.println("연락처 등록 완료!");
	}
	
	public static void selectallContact() {
		for (int i = 0; i < count; i++) {
			System.out.println("---연락처 " + i + "---");
            System.out.println(contactList[i].toString());
        }
	}
	public static void select() {
		System.out.println("검색과 인덱스 입력>");
		int index = sc.nextInt();
				
		if(index >= 0 && index < count) {
			System.out.println(contactList[index].toString()); 
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
		
	}
	public static void updateContact() {
		System.out.println("수정할 인덱스 입력>");
		int index = sc.nextInt();
		if(index <= 0 && index < count) {
			System.out.println("이름 입력>");
			String name = sc.next();
			System.out.println("전화번호 입력>");
			String phone = sc.next();
			System.out.println("이메일 입력>");
			String emai = sc.next();
			
			contactList[index].setName(name);
			contactList[index].setPhone(phone);
			contactList[index].setEmai(emai);
			System.out.println("연락처 수정 완료!");
			
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
		
	}
	

}// end ContactMain01

// 클래스 메소드 배열을 제대로 이해을 못함 기본기가 가장 중요함
