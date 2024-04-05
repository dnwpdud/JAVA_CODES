package edu.java.homework;

public class MemberService {
//	1. login, logut 메소드 선언
//	2. login는 매개 값 ,id, password
//	3. logout는 매개 값 id 
//	4. login, ,id = hong , password == 12345 값이 맞을 경우
//	ex)
//	true
//	틀리경우
//	false
//	5. logout는 사용한 id을  "로그아웃이 되었습니다." 출력
	
	// id, password는 주소값이 전송됨
	// id == "hong" : 주소값 데이터 비교
	// id.epuals("hong") : 실제 데이터 비교
	
	
	String id; // 멤버변수
	String password;// 멤버변수
	
	public boolean login(String id, String password) {// 매개변수 입력
	if(id.equals("hong") && password.equals("12345")) {// 매개변수와 정해저있는 id와 password가 같을경우 true로 return
		return true;
	}else{// 매개변수와 정해저있는 id와 password가 같지 않을 경우 false로 return
		return false;
	}
	}
	
	public void logout(String id) {// 사용된 id을 로그아웃 
		System.out.println(id + "로그아웃 되었습니다.");
	}
	
}// end MemverService
//느낀점 : 변수가 영어로 되어 있오 입려과 출력만 확인 하영 작성 하였지만 출력이 잘 나오기는 했다.
//근데 맞는지 확인 안되서 확인 해봤는데 구족을 알았던니 쉬워졌다.
