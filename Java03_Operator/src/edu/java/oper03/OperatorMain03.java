package edu.java.oper03;

// 중감 연산자
// - 변수의 값을 1 증가 또는 감소할 때 사용하는 연산자
// - 변수의 앞(prefix)과 뒤(suffix)에 사용
// - ++, --
public class OperatorMain03 {

	public static void main(String[] args) {
		System.out.println("증감 연산자(++, --)");
		
		int num1 = 100;
		num1++;
		// num1 += 1;
		// num1 = num1 +1;
		System.out.println("num1 = " + num1);
		
		int num2 = 100;
		++num2;
		System.out.println("num2 =" +num2);
		
		int num3 = 100;
		int result = ++num3 + 5;
		System.out.println("num3 = "+ num3);
		System.out.println("result = " + result);
		
		int num4 = 100;
		result = num4 ++ +5;
		// num4(100) + 5가 먼저 실행되고, result에 값을 저장
		// num4를 1 증가시켜서 num4 = 101이 저장됨
		System.out.println("num4 ="+ num4);
		System.out.println("result ="+ result);
		
		int x = 10;
		result = x ++ +5 + ++x;
		// 퀴즈) result의 값과 그 이유 설명하기
		// 힌트) 연산 구조는 순차적으로 이루어진다.
		// 예) 1 + 2 + 3 -> (1 + 2 = 3) + = 6
		
		// x++ 먼저 수행되어 x 는 10이되어 10 + 5 가 먼저 계산된다. 
		// 15 + ++x 는 전 15 + 부터 순차적으로 수행된다음 ++x 가 수행된기전에 
		// x++ 먼저 수행 된서 11이 되고 ++x 수행 되어 12가 된다.
		
		
	}// end main()

}// end OperatorMain03
