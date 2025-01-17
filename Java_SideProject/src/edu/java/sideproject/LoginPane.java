package edu.java.sideproject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;


public class LoginPane extends JFrame{
	JPanel loginPane;// 안쪽틀  // 무조건 오류
	JFrame loginPaneFrame;// 무조건 오류
	private JTextField txtId, txtNo;
	private JPasswordField txtPassword;
	
	private static LoginDAO logunDao;
	
	public LoginPane() {
		
		logunDao = LoginDAOImple.getLoginInstace();
		
		loginPaneFrame = this; // 무조건 오류
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 511);
		loginPane = new JPanel();
		loginPane.setBackground(new Color(0, 204, 255));
		loginPane.setForeground(new Color(0, 0, 0));
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPane);
		loginPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("궁서", Font.PLAIN, 40));
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setBounds(73, 10, 282, 41);
		loginPane.add(lblLogin);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("궁서", Font.PLAIN, 20));
		lblId.setBounds(0, 61, 113, 70);
		loginPane.add(lblId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("궁서", Font.PLAIN, 20));
		lblPassword.setBounds(0, 153, 113, 63);
		loginPane.add(lblPassword);
		
		JButton btnManageJoin = new JButton("관리자 회원가입");
		btnManageJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerInform managerInform = new ManagerInform();
				managerInform.setVisible(true);
				loginPaneFrame.setVisible(false);
			}
		});
		btnManageJoin.setFont(new Font("굴림", Font.PLAIN, 15));
		btnManageJoin.setBounds(40, 389, 159, 41);
		loginPane.add(btnManageJoin);
		
		JButton btnUserJoin = new JButton("사용자 회원가입");
		btnUserJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInform userinform = new UserInform();
				userinform.setVisible(true);
				loginPaneFrame.setVisible(false);
			}
		});
		btnUserJoin.setFont(new Font("굴림", Font.PLAIN, 15));
		btnUserJoin.setBounds(247, 389, 159, 41);
		loginPane.add(btnUserJoin);
		
		txtId = new JTextField();
		txtId.setBounds(147, 61, 257, 64);
		loginPane.add(txtId);
		txtId.setColumns(10);
		
		txtPassword = new JPasswordField(); // 패스워드 필드로 변경
		txtPassword.setColumns(10);
		txtPassword.setBounds(147, 155, 257, 64);
		txtPassword.setEchoChar('*'); // 문자 입력했을때 *로 변경
		loginPane.add(txtPassword);
		
		
		
		
		JCheckBox chckbxManage = new JCheckBox("관리자");
		JCheckBox chckbxUser = new JCheckBox("사용자");
		chckbxManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxManage.isSelected()) {
					chckbxUser.setEnabled(false);
				}else {
					chckbxUser.setEnabled(true);
				}
			}
		});
		chckbxManage.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxManage.setBounds(40, 356, 74, 23);
		loginPane.add(chckbxManage);
		
//		JCheckBox chckbxUser = new JCheckBox("사용자");
		chckbxUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxUser.isSelected()) {
					chckbxManage.setEnabled(false);
				}else {
					chckbxManage.setEnabled(true);
				}
			}
		});
		chckbxUser.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxUser.setBounds(118, 356, 74, 23);
		loginPane.add(chckbxUser);
		
		JButton btnLogin = new JButton("로그인");// mian 창 띄우기 
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입력칸이 공백일 경우 에러처리 하는 코드
				String id = txtId.getText();
				String pw = String.valueOf(txtPassword.getPassword());
				String no = txtNo.getText();
				if(id.isBlank() || pw.isBlank() || no.isBlank()) {
					JOptionPane.showMessageDialog(btnLogin, "모든 빈칸을 입력해주세요");
					return; // 에러 발생했으니까 종료하는 것
				}
				// 입력칸이 공백일 경우 에러처리 하는 코드
				if(chckbxManage.isSelected()) {
					MangerIdOk();
				} else if(chckbxUser.isSelected()) {
					UserIdOk();
				} else {
					System.out.println("로그인 창을 체크해주세요.");
					JOptionPane.showMessageDialog(btnLogin, "로그인 창을 체크해주세요");
				}
			}
		});
		btnLogin.setFont(new Font("굴림", Font.PLAIN, 15));
		btnLogin.setBounds(40, 299, 366, 51);
		loginPane.add(btnLogin);
		
		txtNo = new JTextField();
		txtNo.setColumns(10);
		txtNo.setBounds(147, 225, 257, 64);
		loginPane.add(txtNo);
		
		JLabel lblNo = new JLabel("사원 번호");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setFont(new Font("궁서", Font.PLAIN, 20));
		lblNo.setBounds(0, 226, 113, 63);
		loginPane.add(lblNo);
	}
	
	public boolean MangerIdOk() {
		
		boolean result = false;
		try {
			int manageNO = Integer.parseInt(txtNo.getText());
			String manageId = txtId.getText();
			String managePassword = String.valueOf(txtPassword.getPassword());

			result = logunDao.selectLoginManager(manageNO, manageId, managePassword);
			if(result) {
				PartManagementMain partManagementMainNew = new PartManagementMain();
				partManagementMainNew.frame.setVisible(true);
				loginPaneFrame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(loginPaneFrame, 
						"로그인에 실패 하셨습니다. 번호, id, password을 다시 확인해 주세요");
			}
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(loginPaneFrame, "번호에 숫자을 입력해 주세요!");
		}
		return result;

	}// end MangerIdOk()
	
	public boolean UserIdOk() {
		boolean result = false;
			try {
				int manageNO = Integer.parseInt(txtNo.getText());
				String manageId = txtId.getText();
				String managePassword = String.valueOf(txtPassword.getPassword());//txtPassword.getText();
				
				result = logunDao.selectLoginUser(manageNO, manageId, managePassword);
				if(result) {
					EquipmentInform equipmentInform = new EquipmentInform();
					equipmentInform.equipmentframeFrame.setVisible(true);
					loginPaneFrame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(loginPaneFrame, 
							"로그인에 실패 하셨습니다. 번호, id, password을 다시 확인해 주세요");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(loginPaneFrame, "번호에 입력해 주세요!");
			}
			
			return result;
		
	}// end UserIdOk()
	
}// end LoginFrame
