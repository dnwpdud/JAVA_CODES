package edu.java.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class 우제영_HW6 {

	public static void main(String[] args) {
		//(- displayInfo() 함수 만들어서 위의 변수의 값을 출력) 메소드 못 만들었습니다.
		// 의외로 displayInfo() 그냥 만들었으면 되었고 출력하는것도 그냥 규칙에 맟게 했으면 되었음
		Scanner sc = new Scanner(System.in);
		
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		System.out.println("데이터 입력 및 저장하는 코드 작성");
		try {
			out = new FileOutputStream("temp/[우제영].java");// 파일 만들기
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			List<Student> list = new ArrayList<>();
			for(int i = 0; i < 2; i++) {//여러 학새의 점수 입력
//				Scanner sc = new Scanner(System.in); 강사님 / 아마도 이코드는 한정된 코드라서 
				System.out.println(i + "이름 입력>");// Scanner이 for문만 사용되니까 작성하신것 같다.
				String num = sc.next(); 
				System.out.println(i + "수학점수 입력>");
				int math = sc.nextInt();
				System.out.println(i + "영어점수 입력>");
				int eng = sc.nextInt();
				Student m = new Student(num, math,eng);
				list.add(m);
			}
			oout.writeObject(list);// list는 현재 저장된 모든 배열을 출력해준다.
			System.out.println("데이터 저장 완료");
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("==============================================");
		System.out.println("데이터 불러와서 출력하는 코드 작성");
		
		try {
			in = new FileInputStream("temp/[우제영].java");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			ArrayList<Student> list = (ArrayList<Student>) oin.readObject();// 배열
			
			for(Student m : list) {// 현재 저장되었는 학생 수 만큼 반복출력
				m.displayInfo();// sysout을 안해서 오류가 고쳐짐 / 오류 나는 이유는 sysout는 void가 들어가면 안되기 때문인것 같다. 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		sc.close();//
		
	}// end main()

}// end 우제영_HW6

// 피드백 문제을 보았을 때 어떻게 작성해야 될지 생각 되지만 생각이 안되고 이해가 안 될때는
// 코드을 작성하기전에 '왜 이 코드가 사용되는지'을 생각하고 그 문제점외 코드을 작성하고 
// 코드을 전체적으로 바라바서 이 문제가 왜 생기는 지? 어떤 역할을 하는지 확인 해야 한다.
// 그외 File 에서 배운 내용은 어느정도 이해하고 사용 할수 있을 것 같다.
// 하지만 역시 List에서 막혀서 응용할때 어려움을 꺽는다.