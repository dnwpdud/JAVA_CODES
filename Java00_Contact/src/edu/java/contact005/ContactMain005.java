package edu.java.contact005;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class ContactMain005 {
	
	private JFrame frame;
	
	public static Scanner sc = new Scanner(System.in);
	public static ContactDAO dao;
	private static JTextField textName;
	private static JTextField textPhone;
	private static JTextField textEmail;
	private static JTextField txtIndex;
	private static JTextArea textArealnfo;
	private static JTextArea textAreaLog;
	

	public static void main(String[] args) {
		dao = ContactDAOImple.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ContactMain005 window = new ContactMain005();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	
	
	public ContactMain005() {
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Font letterType = new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 30);
		int listWidth = 128;
		int listLength = 42;
		
		JLabel lblNewLabel = new JLabel("연락처 프로그램 Version 0.5");
		lblNewLabel.setFont(letterType);
		lblNewLabel.setBounds(12, 10, 560, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(letterType);
		lblName.setBounds(12, 62, listWidth, listLength);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(letterType);
		lblPhone.setBounds(12, 114, listWidth, listLength);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(letterType);
		lblEmail.setBounds(12, 166, listWidth, listLength);
		frame.getContentPane().add(lblEmail);
		
		textName = new JTextField();
		textName.setFont(letterType);
		textName.setBounds(152, 62, 213, 42);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setFont(letterType);
		textPhone.setBounds(152, 114, 213, 42);
		frame.getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(letterType);
		textEmail.setBounds(152, 166, 213, 42);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnlnsert = new JButton("등록");
		btnlnsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertContact();
			}
		});
		btnlnsert.setBounds(12, 218, 100, 30);
		frame.getContentPane().add(btnlnsert);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectContact();
			}
		});
		btnSearch.setBounds(247, 218, 97, 23);
		frame.getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnUpdate.setBounds(12, 266, 97, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteContact();
			}
		});
		btnDelete.setBounds(121, 266, 97, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAllContact();
			}
		});
		
		btnAllSearch.setBounds(247, 266, 97, 23);
		frame.getContentPane().add(btnAllSearch);
		
		txtIndex = new JTextField("번호입력");
		txtIndex.setBounds(121, 218, 116, 21);
		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 299, 350, 50);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 359, 350, 63);
		frame.getContentPane().add(scrollPane_1);
		
		textArealnfo = new JTextArea();
		textArealnfo.setBounds(12, 299,200, 30);
		scrollPane.setViewportView(textArealnfo);
		
		textAreaLog = new JTextArea();
		textAreaLog.setBounds(12, 299,350, 63);
		scrollPane_1.setViewportView(textAreaLog);
		

		
		
	}
	// contact 배열에 contact 인스턴스를 저장
		private static void insertContact() {
			
			String name = textName.getText();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			
			ContactVO vo = new ContactVO(name, phone, email);

			int result = dao.insert(vo);
			
			int size = ((ContactDAOImple) dao).getSize();
			
			if(result == 1) {
				textAreaLog.setText("등록된 연락처 개수 : " + size + "\n");
				textAreaLog.append("연락처 등록 완료!" + "\n");	
			}
			
//			textArealnfo.setText(vo.toString());
			
			
		} // end insertContact

		private static void selectAllContact() {
			ArrayList<ContactVO> list = dao.select();
			
			int size = ((ContactDAOImple) dao).getSize();
			System.out.println("연락처 개수 : " + size);
			
			for(int i = 0; i < size; i++) {
				textArealnfo.append("--- 연락처 " + i + " ---" + "\n");
				textArealnfo.append((list.get(i).toString() + "\n"));
			}
		} // end selectAllContact()

		private static void selectContact() {
		
			int index = Integer.parseInt(txtIndex.getText());
			int size = ((ContactDAOImple) dao).getSize();
			if(index >= 0 && index < size) {
				textArealnfo.append(dao.select(index).toString() + "\n");			
			} else {
				textAreaLog.setText("해당 인덱스에 연락처가 없습니다."); 
			}
		} // end selectContact()

		private static void updateContact() {
			System.out.println("수정할 인덱스 입력>");
			String indexIn = txtIndex.getText(); 
			int index = Integer.parseInt(indexIn);
			
			int size = ((ContactDAOImple) dao).getSize();
			if(index >= 0 && index < size) {

				String phone = textPhone.getText();

				String email = textEmail.getText();
				
				ContactVO vo = new ContactVO("", phone, email);
				
				int result = dao.update(index, vo);
				if(result == 1) {
					textAreaLog.append("연락처 수정 완료!");						
				}
			} else {
				textAreaLog.append("해당 인덱스에 연락처가 없습니다.");
			}
		} // end updateContact()
		
		private static void deleteContact() {

			int index = Integer.parseInt(txtIndex.getText());
			
			int size = ((ContactDAOImple) dao).getSize();
			if(index >= 0 && index < size) {
				int result = dao.delete(index);
				
				if(result == 1) {
					textAreaLog.setText("연락처 삭제 완료");
				}
			} else {
				textAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
			}
			
		} // end deleteContact()
} // end ContactMain01
