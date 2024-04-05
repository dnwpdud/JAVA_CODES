package edu.java.for03;

public class ForMain03 {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		//1 ~ 100까지 정수 중에서 10의 배수들만 출력
		for(int x = 1; x <= 100; x++) {
			if(x % 10 == 0) {
				System.out.println(x + " ");
			}
		}
		
		for(int x = 1; x <=100; x++) {
		    if(x % 10 == 0){// x가 10의 배수가 되었을때 줄바꿈
			System.out.println(x);
			}
			else {
				System.out.print(x + " ");// x 출력 후 1칸 뒤기
			}
		}
		
		
	}// end main()

}// end ForMain03
