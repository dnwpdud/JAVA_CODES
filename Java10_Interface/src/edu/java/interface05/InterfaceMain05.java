package edu.java.interface05;

// 상속 : IS -A 관계가 성립할 때
// - 스마트 TV는 TV이다.(SmatrTv is a TV)
// - class SmartTv extends BasicTv {..}

// 구현(인터페이스) : HAS-A 관계가 성립할 때
// - TV는 리모콘을 가지고 있다. (TV has a remote controller)
// - class BasicTv implements RemoteController

public class InterfaceMain05 {
	
	public static void main(String[] args) {
		
		  Tv tv = new Tv();
	      tv.turnOn();
	      tv.turnOff();
	      
	      Audio audio = new Audio();
	      audio.turnOn();
	      audio.turnOff();
	      
	      System.out.println();
	      RemoteController rc1 = new Tv();
	      rc1.turnOn();
	      
	      RemoteController rc2 = new Audio();
	      rc2.turnOn();
		
	}// end main()

}// end InterfaceMain05
