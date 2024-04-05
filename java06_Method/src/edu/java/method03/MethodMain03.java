package edu.java.method03;

import java.util.Scanner;

public class MethodMain03 {

	public static void main(String[] args) {
		// 1. 국어, 영어, 수학 점수를 입력받아서 3개의 변수에 저장
		// 2. 메소드를 정의하여 입력받은 점수를 출력
		// 3. 메소드를 정의하여 세 과목의 총점을 출력
		// 4. 메소드를 정의하여 세 과목의 평균을 출력
		// 5. 메소드를 정의하여 평균에 따른 등급을 출력
		Scanner sc = new Scanner(System.in);
		
		int korean = sc.nextInt();
		int english = sc.nextInt();
		int math = sc.nextInt();
		//국어, 영어, 수학 점수를 입력받아서 3개의 변수에 저장
		
		System.out.println("각 과목 점수");
		printScores(korean, english, math);
		
		
		int sum1 = calcTotal(korean, english, math);
		System.out.println("총점 : " + sum1);
		
		double sum =calcAverage(korean, english, math);
		System.out.println("평균 : " + sum);
		
		int ve = selectHrade(sum);
		System.out.println("등급 : " + ve);
		

	}// end main()
	
	// 국/영/수 점수를 출력하는 메소드
	// 메소드 이름 : printScores()
	public static void printScores(int korean, int english, int math) {
		System.out.println(korean);
		System.out.println(english);
		System.out.println(math);
	}
	
	// 국/영/수 총점을 리턴하는 메소드
	// 메소드 이름 : calcTotal()
	public static int calcTotal(int korean, int english, int math) {
		return korean + english + math;
	}
	
	// 국/영/수 평균을 리턴하는 메소드
	// 메소드 이름 : calcAverage()
	public static double calcAverage(int korean, int english, int math) {
		return (korean + english + math) / 3.0;
		// (sum)
		// return sum / 3.0;
		// main 에서 sum = korean + english + math;
	}
	
	// 등급을 리턴하는 메소드
	// 메소드 이름 : selectHrade() 
	
	public static char selectHrade(double sum) {
		    char result;
			if(90 <= sum && sum >= 100) {
				result = 'A';
			}else if(80 <= sum) {
				result = 'B';
			}else if(70 <= sum) {
				result = 'C';
			}else {
				result = 'F';
			}
		return result;
	}
	
	//100 ~ 90 => 'A'
	//89 ~ 80 => 'B'
	//79 ~ 70 => 'C'
	//69 미만 => 'F'
	
	//public static char selectHrade(double avg) {
	// if(90 <= avg && avg >= 100){
	// return 'A';}
	 //else if(80 <= avg){
	// return 'B';}
	//else if(80 <= avg){
		// return 'B';}
	//else {
		// return 'F';}
	//}
}// end MethodMain03

// 피드백 
// 변수명을 제대로 안하고 있다. (정말 중요!!)
// 변수명 전부 강사님과 같이 수정 함(내가 한건 a, b, c임)
// 문제 파악을 제대로 하지 않음 (나의 단점 문제을 정확히 파악 하지않고 빨리 만들려고 함)
