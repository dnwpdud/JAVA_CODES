package edu.java.contact04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOImple implements ContactDAO {

	// 싱글톤 디자인 패턴 적용
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() {
		initDataDir();
		initDataFile();
		
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	// 회원 정보를 저장할 배열
	private ArrayList<ContactVO> list = new ArrayList<>();

	// 데이터를 저장할 폴더와 파일 이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";

	// data 폴더의 contact.data 파일을 관리할 File 객체 선언

	private File dataDir;
	private File dataFile;

	// TODO : data 폴더가 있는지 검사하고, 없으면 생성하는 함수
	private void initDataDir() {
		System.out.println("initDataDir()");
		dataDir = new File(DATA_DIR);
		System.out.println("폴더 경로 : " + dataDir.getParent());
		if (!dataDir.exists()) {// 폴더가 없으면 생성
			if (dataDir.mkdirs()) {
				System.out.println("폴더가 생성 되었습니다.");
			} else {
				System.out.println("폴더 생성이 실패 되었습니다.");
			}
		} else {
			System.out.println("이미 있는 폴더 입니다.");
		}

	}// end initDataDir()
		
	// TODO : 데이터 파일이 존재하는지 검사하고,
	// 없는 경우 - 새로운 데이터 파일 생성
	// 있는 경우 - 기존 파일에서 데이터를 읽어서 ArrayList에 추가
	private void initDataFile() {
		System.out.println("initDataFile()");
		String filePath = DATA_DIR + File.separator + DATA_FILE; //역시 data\contact.data 경로에 맞게 하는게 맞다.
		dataFile = new File(filePath);
		
		if(!dataFile.exists()) {
			System.out.println("파일이 없습니다.");
			try {
				if(dataFile.createNewFile()) {
					System.out.println("파일이 생성 되었습니다.");
				} else {
					System.out.println("파일 생성이 실패 되었습니다.");
				}
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		} else {
			System.out.println("이미 있는 파일 입니다.");
			if(dataFile.length() != 0) {
				readDataFromFile();// 같은 거라서 메소드 자체을 집어 넣는다.
			}
		}
	}// end initDataFile()

	// TODO : 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
	private void writeDataToFile() {
		System.out.println("writeDataToFile()");
		
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream(dataFile);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			oout.writeObject(list);
			System.out.println("데이터 저장 완료");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // end writeDataToFile()

	// TODO : data\contact.data 파일에서 ArrayList 객체를 읽어와서
	// 멤버 변수 list에 저장(읽기)
	private void readDataFromFile() {
			System.out.println("readDataFromFile()");
			InputStream in = null;
			BufferedInputStream bin = null;
			ObjectInputStream oin = null;
			
			try {
				in = new FileInputStream(dataFile);
				bin = new BufferedInputStream(in);
				oin = new ObjectInputStream(bin);
				
				list = (ArrayList<ContactVO>) oin.readObject();
				System.out.println("데이터 불러옴");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					oin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
	}// end readDataFromFile()

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public int insert(ContactVO vo) {
		System.out.println("insert()");
		System.out.println("vo = " + vo);
		list.add(vo);
		writeDataToFile();
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ArrayList<ContactVO> select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmai(vo.getEmai());
		writeDataToFile();
		return 1;
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		writeDataToFile();
		return 1;
	}

}// end ContactDAOImple
