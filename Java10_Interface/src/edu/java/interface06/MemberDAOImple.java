package edu.java.interface06;

// DAOData Access Object) :
// - 데이터의 전송을 담당하는 역할
// 
public class MemberDAOImple implements MemberDAO {
	
	// 싱글톤 디자인 패턴 적용
	
	// 1. private static 자기 자신 타입의 변수 선언
	private static MemberDAOImple instance = null;

	// 2. private 생성자 
	private MemberDAOImple() {}
	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static MemberDAOImple getInstance() {//MemberVO가 인스턴스로 구현이 안된이유는 아마도 3가지의 정보을 각각의 배열에 따로 저장해야되기 떄문에 그런거 같다.
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	
	private final int MAX = 100;
	private MemberVO[] list = new MemberVO[MAX];// 회원 정보를 저장할 배열
	private int count; // 배열에 저장될 데이터 개수
	
	public int getCount() {
		return count;
	}
	
	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert()");
		System.out.println("vo = " + vo.toString());
		list[count] = vo;
		count++;
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public MemberVO[] select() {
		return list;
	}

	@Override
	public MemberVO select(int index) {// 수정될 인덱스의
		return list[index];
	}

	@Override
	public int update(int index, MemberVO vo) {// 수정될 Pw, Email 값을 리턴
		list[index].setPw(vo.getPw());
		list[index].setEmail(vo.getEmail());
		return 1;
	}

}// end MemberDAOImple
// 인터페이스을 통해 main에서 작동되는 메소드을 미리 정의 할 수 있다.
// 
