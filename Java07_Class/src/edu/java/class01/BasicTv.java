package edu.java.class01;

// 클래스(Class)
// - 만들고자 하는 대상의 상태(속성) 정보들을 "멤버 변수(필드)"로 선언하고,
// 	 대상이 가져야 할 기능들을 "메소드"로 정의한는,
//	 새로이 만드는 "데이터 타입"
public class BasicTv {
	// TV가 가져야 할 상태(속성, 성질) => 멤버 변수(필드, 프로퍼티)
	boolean powerOn; // TV의 전원 상태(true : on, false : off)
	int channel = 1; 	 // TV의 채널 정보. 1로 초기화
	int volume; // TV의 소리 정보. 0으로 초기화
	
	// TV가 가져야 할 기능 => 메소드
	
	// 전원(powerOn) on/off 기능
	public void turnOnOff() {
		if(powerOn == false){
			powerOn = true;
			System.out.println("TV가 커졌습니다.");
		} else {
			powerOn = false;
			System.out.println("TV가 꺼졌습니다.");
		}
	}
	
	// 체널 증가 기능 메소드
	public void channer1Up() {
		// 이 메소드를 호출하면 channel 변수가 1씩 증가
		// 1, 2, 3, 4, 5, 1, 2, .. 순환 구조를 갖는다.
		channel++;
		if(channel == 6) {
			channel = 1;
		}
		System.out.println("shannel Up : " + channel);
	}
	
	// 체널 감소 기능 메소드
	public void channer1Down() {
		channel--;
		// 5, 4, 3, 2, 1, 0 = > 5
		if(channel == 0) {
			channel = 5;
		}
		System.out.println("shannel Down : " + channel);
	}
	
	// 소리 증가 기능 메소드(소리 최대4)
	public void volumeUp() {
		if(volume < 4) {
			volume++;
		}
		System.out.println("volumeUp : " + volume);
	}
	// 소리 증가 기능 메소드(소리 최소0)
	public void volumeDown() {
		if(volume > 0) {
			volume--;
		}
		System.out.println("volumeDown : " + volume);
	}
	
	public void displayInfo() {
		System.out.println("--- TV 현재 상태 ---");
		System.out.println("전원 : " + powerOn);
		System.out.println("체널 : " + channel);
		System.out.println("체널 : " + volume);
	}
	
	
	
}// end BasicTv
