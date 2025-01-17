package edu.java.sideproject;

import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserInform extends JFrame {
	private JFrame UserInformFrame;
	private JPanel userInform;
	private JTextField txtUserIndex, txtUserId
	, txtUserPassword, txtUserName, txtUserPhone
	, txtUserEmail;
	
	private static UserInformDAO userInformDao;
	
	public UserInform() {
		
		UserInformFrame = this;
		userInformDao = UserInformDAOImple.getUserInformgetInstance();
		userInform = new JPanel();
		UserInformFrame.getContentPane().setBackground(new Color(0, 153, 0));
		UserInformFrame.getContentPane().setLayout(null);
		
		JLabel lblUserInform = new JLabel("사용자 회원 가입");
		lblUserInform.setFont(new Font("궁서", Font.PLAIN, 30));
		lblUserInform.setForeground(new Color(0, 0, 0));
		lblUserInform.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserInform.setBounds(72, 31, 291, 36);
		UserInformFrame.getContentPane().add(lblUserInform);
		
		JLabel lblUserIndex = new JLabel("사용자 번호");
		lblUserIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserIndex.setFont(new Font("궁서", Font.PLAIN, 20));
		lblUserIndex.setBounds(12, 77, 144, 41);
		UserInformFrame.getContentPane().add(lblUserIndex);
		
		JLabel lblUserId = new JLabel("아이디");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setFont(new Font("궁서", Font.PLAIN, 20));
		lblUserId.setBounds(12, 150, 144, 41);
		UserInformFrame.getContentPane().add(lblUserId);
		
		JLabel lblUserPassword = new JLabel("비밀번호");
		lblUserPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPassword.setFont(new Font("궁서", Font.PLAIN, 20));
		lblUserPassword.setBounds(12, 223, 144, 41);
		UserInformFrame.getContentPane().add(lblUserPassword);
		
		JLabel lblUserName = new JLabel("사용자 이름");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("궁서", Font.PLAIN, 20));
		lblUserName.setBounds(12, 298, 144, 41);
		UserInformFrame.getContentPane().add(lblUserName);
		
		JLabel lblUserPhone = new JLabel("사용자 전화번호");
		lblUserPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPhone.setFont(new Font("궁서", Font.PLAIN, 20));
		lblUserPhone.setBounds(12, 381, 147, 41);
		UserInformFrame.getContentPane().add(lblUserPhone);
		
		JLabel lblUserEmail = new JLabel("사용자 이메일");
		lblUserEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserEmail.setFont(new Font("궁서", Font.PLAIN, 20));
		lblUserEmail.setBounds(12, 459, 147, 41);
		UserInformFrame.getContentPane().add(lblUserEmail);
		
		txtUserIndex = new JTextField();
		txtUserIndex.setBounds(168, 77, 254, 41);
		UserInformFrame.getContentPane().add(txtUserIndex);
		txtUserIndex.setColumns(10);
		
		txtUserId = new JTextField();
		txtUserId.setColumns(10);
		txtUserId.setBounds(168, 150, 254, 41);
		UserInformFrame.getContentPane().add(txtUserId);
		
		txtUserPassword = new JTextField();
		txtUserPassword.setColumns(10);
		txtUserPassword.setBounds(168, 223, 254, 41);
		UserInformFrame.getContentPane().add(txtUserPassword);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(168, 298, 254, 41);
		UserInformFrame.getContentPane().add(txtUserName);
		
		txtUserPhone = new JTextField();
		txtUserPhone.setColumns(10);
		txtUserPhone.setBounds(168, 381, 254, 41);
		UserInformFrame.getContentPane().add(txtUserPhone);
		
		txtUserEmail = new JTextField();
		txtUserEmail.setColumns(10);
		txtUserEmail.setBounds(171, 459, 254, 41);
		UserInformFrame.getContentPane().add(txtUserEmail);
		
		JButton btnOkButton = new JButton("완료");
		btnOkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String userId = txtUserId.getText();
					String userPassword = txtUserPassword.getText();
					String userName = txtUserName.getText();
					String userPhone = txtUserPhone.getText();
					String userEmail = txtUserEmail.getText();
					
					if(userId.isBlank() || userPassword.isBlank() || 
							userName.isBlank() || userPhone.isBlank() || userEmail.isBlank()) {
				JOptionPane.showMessageDialog(UserInformFrame, "모든 빈칸을 입력해주세요");
				return;	
				}
				insertUserInform();
			}
		});
		btnOkButton.setFont(new Font("궁서", Font.PLAIN, 20));
		btnOkButton.setBounds(12, 510, 410, 41);
		UserInformFrame.getContentPane().add(btnOkButton);
		
		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPane loginPaneNew = new LoginPane();
				loginPaneNew.setVisible(true);
				UserInformFrame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("궁서", Font.PLAIN, 15));
		btnNewButton.setBounds(12, 10, 89, 27);
		getContentPane().add(btnNewButton);
		UserInformFrame.setBounds(100, 100, 450, 600);
		UserInformFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}// end UserInform
	
	private void insertUserInform() {
		try {
		int userIndex = Integer.parseInt(txtUserIndex.getText());
		String userId = txtUserId.getText();
		String userPassword = txtUserPassword.getText();
		String userName = txtUserName.getText();
		String userPhone = txtUserPhone.getText();
		String userEmail = txtUserEmail.getText();
		
		UserInformVO vo = new UserInformVO(userIndex, userId
				, userPassword, userName, userPhone, userEmail, null);
		
		int result = userInformDao.UserInforminsert(vo);
		if(result == 1) {
			System.out.println(result + "사용자 회원 등록 완료");
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(UserInformFrame, "사용자 번호가 숫자가 아닙니다.");
	}
	}// end insertUserInform
	
}// end UserInform
