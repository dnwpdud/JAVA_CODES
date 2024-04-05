package edu.java.interface06;

import java.util.Scanner;

// MVC 디자인 패턴에서 View 클래스
// - UI를 담당하는 역할
// * 현재 시스템은 규모가 작으므로 Controller 역할도 수행

public class MemberMain {
	private static Scanner sc; // 클래스 맞는 변수 선언 main 선언 하면 main에 있는 메소드들이 입력할수 없으므로 main 바깥쪽에 인스턴스함
	private static MemberDAO dao; // MemberDAOImple 인스턴스를 저장할 변수 (위에 이유로같은 이유) 
	
	public static void main(String[] args) {
		System.out.println("회원 관리 프로그램");
		sc = new Scanner(System.in); // main에 인스턴스하여 사용
		dao = MemberDAOImple.getInstance();// 다형성. 싱글톤 인스턴스 생성
		
		boolean run = true;
		while(run) {
			showMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case Menu.INSERT:
				insertMember();
				break;
			case Menu.SELECT_ALL:
				selectAll();
				break;
			case Menu.SELECT_BY_INDEX:
				selectByIndex();
				break;
			case Menu.UPDATE:
				updateMember();
				break;
			case Menu.QUIT:
				run = false;
				break;
			default:
				System.out.println("다시 선택해세요.");
				break;
			}
		}
		sc.close();
	}// end main()

	private static void updateMember() {
		System.out.println("인덱스 입력>");
		int index = sc.nextInt();
		
		int count = ((MemberDAOImple)dao).getCount();
		if(index >= 0 && index < count) {
			System.out.println("비밀번호 입력>");
			String pw = sc.next();
			System.out.println("이메일 입력>");
			String email = sc.next();
			
			MemberVO vo = new MemberVO("", pw, email);// "" 수정되지 않았음으로 데이터을 그대로 출력한다.
			int result = dao.update(index, vo);// index번의 toString 수정 메소드
			if(result == 1) {
				System.out.println("회원 정보 수정 완료");
			}
			
		}
	}// end updateMember()

	private static void selectByIndex() {
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();
		
		int count = ((MemberDAOImple)dao).getCount();//각 중가로 바디에
		if(index >= 0 && index < count) {
			MemberVO vo = dao.select(index);
			System.out.println(vo);
		}else {
			System.out.println("존재하지 않는 인덱스입니다.");
		}
	}// end selectByIndex

	private static void selectAll() {
		MemberVO[] list = dao.select();// list(MAX) 리턴 해주어서 사용 가능하게 한것같다.
		
		int count = ((MemberDAOImple)dao).getCount();// count main이 아닌 MemberDAOImple class에 작업이 진행 됨으로 메소드을 불려올떼 get을 해야 한다.
		for(int i = 0; i < count; i++) {
			System.out.println("회원 정보 [" + i + "]");
			System.out.println(list[i]);
		}
	}// end selectAll()

	private static void insertMember() {
		System.out.println("--- 회원 정보 등록 ---");
		System.out.println("아이디 입력>");
		String id = sc.next(); // sc 변수가 메인에서 인스턴스에서 사용가능? or 메인 영역이 아니니까 그냥 사용?
		System.out.println("비밀번호 입력>");
		String pw = sc.next();
		System.out.println("이메일 입력>");
		String email = sc.next();
		
		MemberVO vo = new MemberVO(id, pw, email);
		int result = dao.insert(vo);// toString 출력
		if(result == 1) {// 메소드에 result 1 까지 출력되면 성공으로 출력된다.
			System.out.println("회원 정보 등록 완료");
		}
	}// end insertMember

	private static void showMainMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체 검색 | 3. 상세 검색 | 4. 수정 | 0. 종료");
		System.out.println("---------------------------------------------------");
		System.out.println("선택>");
	}// end showMainMenu
	

}// end 
