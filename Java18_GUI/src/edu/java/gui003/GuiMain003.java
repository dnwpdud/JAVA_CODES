package edu.java.gui003;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

public class GuiMain003 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain003 window = new GuiMain003();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain003() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 337, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Num = new JLabel("이름");
		Num.setOpaque(true);
		Num.setFont(new Font("굴림", Font.BOLD, 27));
		Num.setHorizontalAlignment(SwingConstants.CENTER);
		Num.setBackground(Color.PINK);
		Num.setForeground(Color.BLACK);
		Num.setBounds(12, 10, 150, 42);
		frame.getContentPane().add(Num);
		
		JLabel Tel = new JLabel("전화번호");
		Tel.setOpaque(true);
		Tel.setBackground(Color.YELLOW);
		Tel.setFont(new Font("굴림", Font.BOLD, 27));
		Tel.setHorizontalAlignment(SwingConstants.CENTER);
		Tel.setBounds(12, 62, 150, 42);
		frame.getContentPane().add(Tel);
		
		JLabel Email = new JLabel("이메일");
		Email.setBackground(new Color(0, 102, 255));
		Email.setOpaque(true);
		Email.setFont(new Font("굴림", Font.BOLD, 27));
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setBounds(12, 114, 150, 42);
		frame.getContentPane().add(Email);
		
		textField = new JTextField();
		textField.setBounds(174, 10, 116, 42);
		textField.setFont(new Font("맑은 고딕" , Font.PLAIN, 30));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 62, 116, 42);
		textField_1.setFont(new Font("맑은 고딕" , Font.PLAIN, 30));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(174, 114, 116, 42);
		textField_2.setFont(new Font("맑은 고딕" , Font.PLAIN, 30));
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel AllOut = new JLabel("New label");
		AllOut.setFont(new Font("굴림", Font.PLAIN, 24));
		AllOut.setOpaque(true);
		AllOut.setBackground(Color.WHITE);
		AllOut.setBounds(12, 210, 278, 34);
		frame.getContentPane().add(AllOut);
		
		JButton btnInput = new JButton("정보 출력");
		btnInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼을 클릭하면
				// JTextFieled에 입력된 내용을 읽어서
				// JLbel에 출력(쓰기)
				String msg = textField.getText();
				String msg1 = textField_1.getText();
				String msg2 = textField_2.getText();
				System.out.println(msg);
				AllOut.setText("이름 : " + msg + " 전화번호 : " + msg1 + " 이메일 : " + msg2);
			}
		});
		btnInput.setBounds(12, 166, 278, 34);
		frame.getContentPane().add(btnInput);
		
	}

}
