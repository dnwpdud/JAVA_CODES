package jeyeong.ver1407;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//강사님 풀이 
			String str = sc.nextLine();// 공백까지 입력 가능
			
			//for문을 이용하여 문자열을 문자 하나씩 확인 하여 공백(' ')일 경우 
			//if문을 활용 하여 공백이 없는 문자만 출력 한다.
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != ' ') {
					System.out.print(str.charAt(i));
				}
			}
//강사님 풀이 end
	}// end main()

}

//피드백 
//문자열을 문자 하나씩 확인 하여 공백(' ') 확인 하는 방법을 생각하지 못 했을 것이다.
//그리고 공백을 아닌 것만 출력 하는 생각 못 했을것 같다.