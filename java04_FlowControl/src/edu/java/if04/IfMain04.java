package edu.java.if04;

import java.util.Scanner;

public class IfMain04 {

	public static void main(String[] args) {
		System.out.println("if - else if - else 연습");
		//점수를 정수로 입력받아서 score 변수에 저장
		System.out.println("점수를 입력 하세요 :");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		if(score>=90) {
			System.out.println("A");//score가 90점 이상이면 "A"를 출력
		}else if(score>=80) {
			System.out.println("B");//score가 80점 이상이면 "B"를 출력
		}else if(score>=70) {
			System.out.println("C");//score가 70점 이상이면 "C"를 출력
		}else {
			System.out.println("F");//score가 60점 미만이면 "F"를 출력
		}
	}//end main()

}// end IfMain04
