package edu.java.array04;

public class ArrayMain04 {

	public static void main(String[] args) {
		System.out.println("배열 초기화 연습");
		
		int[] english = {100, 90, 80};
		System.out.println(english.length);
		
		// for문을 사용한 출력
		for(int i = 0; i < english.length; i++) {
			System.out.println(english[i]);
		}
		
		
		
		for(int x : english) {
			System.out.println(x);
		}
		//단점 시작끝을 몰라 컨트롤하기 힘들다.
		
	}// end main()

}// end ArrayMain04
