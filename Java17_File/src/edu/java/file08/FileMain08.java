package edu.java.file08;

import java.io.File;

// File 클래스 :
// 		파일(txt, doc, mp4, jpg, png, ...) 객체와
// 		디렉토리(폴더) 객체를 다루기 위한 클래스
// File 클래스의 인스턴스 생성 : new File();
// 		메모리(힙)에 File 클래스의 인스턴스를 생성한다는 의미
//		실제 하드디스크에 있는 물리적인 파일/폴더(디렉토리)를 생성하는 것은 아님
// 		실제 파일/폴더를 만들기 위해서는 File 클래스의 메소드를 호출해야 함 

// 파일(디렉토리)의 경로 : 절대 경로, 상대 경로
// 절대 경로 : 루크(C:\, D:\)부터 파일(폴더)의 위치까지 전체 이름
// 		(예)C:\Users\sdedu\Desktop\JAVA_CODES\Java17_File/\temp\test.txt
// 상대 경로 : 현재 작업 디렉토리를 기준으로 파일(폴더)의 위치를 표시
//		(예) temp/test.txt
//		. : 현재 디렉토리(폴더)
// 		.. : 상위 디렉토리(폴더)

// 파일 구분자(file separator) - 운용체제(OS)마다 다르게 사용
// 		MS Windows - \      //폴더 밑에 라는 뜻
// 		Unis, Linux, Android, ... - / 사용       //폴더 밑에 라는 뜻
// 자바에는 file,separator 변수를 제공     //OS 상관 없이 밑에 라는 뜻

public class FileMain08 {
	public static final String TEST_DIR1 = "D:\\test1";
	public static final String TEST_DIR2 = "test2"; // 상대 경로
	public static final String TEST_DIR3 = 
			"C:" + File.separator + "Study" + File.separator + "test1";

	public static void main(String[] args) {
		System.out.println(TEST_DIR1);
		System.out.println(TEST_DIR2);
		System.out.println(TEST_DIR3);
	
		
		File f = new File(TEST_DIR3);// 파일, 폴더를 다루기 위한 객체
		
		// exists() : 파일, 폴더 존재 여부 확인
		if(!f.exists()) { // 파일, 폴더가 없는 경우
			System.out.println("폴더가 없습니다.");
			// mkdir() : 디렉토리를 생성하는 메소드. 성공하면 true, 실패하면 false
			// mkdirs() : 상위디렉토리를 포함하여 생성하는 메소드.
			if(f.mkdirs()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		} else { // 파일, 폴더가 있는 경우
			System.out.println("폴더가 이미 존재 합니다.");
		}
	} // end main()

}// end FileMain08
