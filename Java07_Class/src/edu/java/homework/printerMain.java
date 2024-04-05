package edu.java.homework;

public class printerMain {

	public static void main(String[] args) {
		printer printer = new printer();
		
		printer.println(10);//int 매개변수 입력
		printer.println(true);//boolean 매개변수 입력
		printer.println(5.7);//double 매개변수 입력
		printer.println("홍길동");//String 매개변수 입력
	}// end main()

}// end printerMain
