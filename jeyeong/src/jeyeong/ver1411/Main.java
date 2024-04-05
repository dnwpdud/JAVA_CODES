package jeyeong.ver1411;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[51];// 가드 번호를 저장할 배열(최대 50 인데 여유럽개 51개로 한다.)
		
		int n = sc.nextInt();// 카드 개수
		
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			arr[a]++;
		}
		
		for(int i = 1; i < n; i++) {
				if(arr[i] == 0) {
					System.out.println(i);
				}
		}
		

	}// end main()

}// end Main
//피드백
//