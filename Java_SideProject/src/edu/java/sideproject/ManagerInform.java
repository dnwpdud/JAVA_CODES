package edu.java.sideproject;

import javax.swing.JFrame;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
	

public class ManagerInform extends JFrame{
	private JFrame managerInformFrame;
	private JPanel managerInform;
	private JTextField txtmanufacturingIndex, txtmanufacturingId
	, txtmanufacturingPassword, txtmanufacturingName, txtmanufacturingPhone
	, txtmanufacturingEmail;
	private static ManagerInformDAO managerDao;
	
	public ManagerInform() {
		
		managerDao = ManagerInformDAOImple.getManagerInformInstance();
		managerInformFrame = this;
		managerInform = new JPanel();
		managerInformFrame.getContentPane().setBackground(new Color(51, 255, 51));
		managerInformFrame.getContentPane().setLayout(null);
		
		JLabel lblManagerInfor = new JLabel("관리자 회원 가입");
		lblManagerInfor.setFont(new Font("궁서", Font.PLAIN, 30));
		lblManagerInfor.setForeground(new Color(0, 0, 0));
		lblManagerInfor.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerInfor.setBounds(72, 31, 291, 36);
		managerInformFrame.getContentPane().add(lblManagerInfor);
		
		JLabel lblManufacturingIndex = new JLabel("관리자 번호");
		lblManufacturingIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblManufacturingIndex.setFont(new Font("궁서", Font.PLAIN, 20));
		lblManufacturingIndex.setBounds(12, 77, 144, 41);
		managerInformFrame.getContentPane().add(lblManufacturingIndex);
		
		JLabel lblManagerId = new JLabel("아이디");
		lblManagerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerId.setFont(new Font("궁서", Font.PLAIN, 20));
		lblManagerId.setBounds(12, 150, 144, 41);
		managerInformFrame.getContentPane().add(lblManagerId);
		
		JLabel lblManagerPassword = new JLabel("비밀번호");
		lblManagerPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerPassword.setFont(new Font("궁서", Font.PLAIN, 20));
		lblManagerPassword.setBounds(12, 223, 144, 41);
		managerInformFrame.getContentPane().add(lblManagerPassword);
		
		JLabel lblManagerName = new JLabel("관리자 이름");
		lblManagerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerName.setFont(new Font("궁서", Font.PLAIN, 20));
		lblManagerName.setBounds(12, 298, 144, 41);
		managerInformFrame.getContentPane().add(lblManagerName);
		
		JLabel lblManagerPhone = new JLabel("관리자 전화번호");
		lblManagerPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerPhone.setFont(new Font("궁서", Font.PLAIN, 20));
		lblManagerPhone.setBounds(12, 381, 147, 41);
		managerInformFrame.getContentPane().add(lblManagerPhone);
		
		JLabel lblManagerEmail = new JLabel("관리자 이메일");
		lblManagerEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerEmail.setFont(new Font("궁서", Font.PLAIN, 20));
		lblManagerEmail.setBounds(12, 459, 147, 41);
		managerInformFrame.getContentPane().add(lblManagerEmail);
		
		txtmanufacturingIndex = new JTextField();
		txtmanufacturingIndex.setBounds(168, 77, 254, 41);
		managerInformFrame.getContentPane().add(txtmanufacturingIndex);
		txtmanufacturingIndex.setColumns(10);
		
		txtmanufacturingId = new JTextField();
		txtmanufacturingId.setColumns(10);
		txtmanufacturingId.setBounds(168, 150, 254, 41);
		managerInformFrame.getContentPane().add(txtmanufacturingId);
		
		txtmanufacturingPassword = new JTextField();
		txtmanufacturingPassword.setColumns(10);
		txtmanufacturingPassword.setBounds(168, 223, 254, 41);
		managerInformFrame.getContentPane().add(txtmanufacturingPassword);
		
		txtmanufacturingName = new JTextField();
		txtmanufacturingName.setColumns(10);
		txtmanufacturingName.setBounds(168, 298, 254, 41);
		managerInformFrame.getContentPane().add(txtmanufacturingName);
		
		txtmanufacturingPhone = new JTextField();
		txtmanufacturingPhone.setColumns(10);
		txtmanufacturingPhone.setBounds(168, 381, 254, 41);
		managerInformFrame.getContentPane().add(txtmanufacturingPhone);
		
		txtmanufacturingEmail = new JTextField();
		txtmanufacturingEmail.setColumns(10);
		txtmanufacturingEmail.setBounds(171, 459, 254, 41);
		managerInformFrame.getContentPane().add(txtmanufacturingEmail);
		
		JButton btnOkButton = new JButton("완료");
		btnOkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String managerId = txtmanufacturingId.getText();
				String managerPassword = txtmanufacturingPassword.getText();
				String managerName = txtmanufacturingName.getText();
				String managerPhone = txtmanufacturingPhone.getText();
				String managerEmail = txtmanufacturingEmail.getText();
				if(managerId.isBlank() || managerPassword.isBlank() || 
						managerName.isBlank() || managerPhone.isBlank() || managerEmail.isBlank()) {
			JOptionPane.showMessageDialog(managerInformFrame, "모든 빈칸을 입력해주세요");
			return;
		}
				insertManagerInfor();
			}
		});
		btnOkButton.setFont(new Font("궁서", Font.PLAIN, 20));
		btnOkButton.setBounds(12, 510, 410, 41);
		managerInformFrame.getContentPane().add(btnOkButton);
		
		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPane loginPaneNew = new LoginPane();
				loginPaneNew.setVisible(true);
				managerInformFrame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("궁서", Font.PLAIN, 15));
		btnNewButton.setBounds(12, 10, 89, 30);
		getContentPane().add(btnNewButton);
		managerInformFrame.setBounds(100, 100, 450, 600);
		managerInformFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void insertManagerInfor() {
		try {
		int managerIndex = Integer.parseInt(txtmanufacturingIndex.getText());
		String managerId = txtmanufacturingId.getText();
		String managerPassword = txtmanufacturingPassword.getText();
		String managerName = txtmanufacturingName.getText();
		String managerPhone = txtmanufacturingPhone.getText();
		String managerEmail = txtmanufacturingEmail.getText();
		
		ManagerInformVO vo = new ManagerInformVO(managerIndex, managerId
				, managerPassword, managerName, managerPhone, managerEmail, null);
		
		int result = managerDao.ManagerInforminsert(vo);
		if(result == 1) {
			System.out.println(result + "관리자 회원 등록 완료");
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(managerInformFrame, "관리자 번호가 숫자가 아닙니다.");
	}
	}//end insertManagerInfor
}// end ManagerInfor
