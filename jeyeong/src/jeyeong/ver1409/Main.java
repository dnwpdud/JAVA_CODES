package jeyeong.ver1409;

import java.io.File;

public class Main {

	
	
	public static void main(String[] args) {
		
//
//		그럼 파일도 2개?
//
//		1. data 폴더의 contact.data 파일을 관리할 File 객체 선언// 완료
//		2. data 폴더가 있는지 검사하고, 없으면 생성하는 함수 
//		3.  데이터 파일이 존재하는지 검사하고,
//			// 없는 경우 - 새로운 데이터 파일 생성
//			// 있는 경우 - 기존 파일에서 데이터를 읽어서 ArrayList에 추가
//		4. 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
//		5. data\contact.data 파일에서 ArrayList 객체를 읽어와서
			// 멤버 변수 list에 저장(읽기)
		final String DATA_DIR = "data";
		final String DATA_FILE = "contact.data";
	
		File dataDir;
		File dataFile;
		
			dataDir = new File(DATA_DIR);
			try {
				if(!dataDir.exists()) {
					System.out.println("폴더가 없습니다");
					if(dataDir.mkdirs()) {
						System.out.println("폴더가 생성 되었습니다.");
					} else {
						System.out.println("폴더 생성에 실패 하였습니다.");
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception	
		}
			
			dataFile = new File(DATA_FILE);
				try {
					if(!dataFile.exists()) {
						System.out.println("파일이 없습니다.");
						
						if(dataFile.createNewFile()) {
							System.out.println("파일이 생성 되었습니다.");
						} else {
							System.out.println("파일이 생성에 실패 되었습니다.");
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			
	}//end main()
} // main
