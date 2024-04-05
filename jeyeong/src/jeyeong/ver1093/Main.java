package jeyeong.ver1093;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();// 입력
//		int[] a = new int[23];// 배열 1~23
//		for(int i = 0; i <n; i++) {// 입력만큼 반복
//			int b = (int)(Math.random() * a.length + 1);// 랜덤 수 
//			a[b-1] += 1;// 랜덤수을 배열에 저장
//			System.out.print(b + " ");
//		}
//		
//		System.out.println();
//		
//		for(int j = 0; j < a.length; j++) {
//		System.out.print(a[j] + " ");
//		}
		
//강사님 풀이
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();// 입력
		
		int[] arr = new int[24];// 0은 그냥 생약 하고 사용 함
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			arr[a] += 1;// 0은 그냥 생약 하고 1부터 더해진다.
		}
		
		for(int i = 1; i <= 23; i++) {//0은 
			System.out.print(arr[i] + " ");
		}
//강사님 풀이 end
		
// 피드백
// 전체적인 흐름은 비슷하게 갔지만 가장 큰 문제인 문제을 제대로 안 읽어서 
// 무작위 수을 입력하는 건데 무작위수가 나올수 있도록 코드을 만들었다.
// 배열은 0부터 시작하는게 맞지만 1부터 시작하는 문제들이 많아서 구지 0의 인덱스을 사용하지 않고
// 1부터 사용 하여 출력 할때 1부터 출력 하면된다.
		
		
	}//end main()

}//end Main
