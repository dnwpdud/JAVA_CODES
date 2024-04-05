package edu.java.homework;

public class Homework05_1 {

	public static void main(String[] args) {
		String str = "2024년 02월 19일 16:37:53";
		String[] result = str.split("년| |월| |일| |:");// 문자열 구분
//		String[] result = str.split("[^0-9+");
		int sum = 0;
		for(String x : result) {
			System.out.println(x); 
			sum += Integer.parseInt(x);
		}
		System.out.println(sum);
		
	}// end main()

}// end Homework05
