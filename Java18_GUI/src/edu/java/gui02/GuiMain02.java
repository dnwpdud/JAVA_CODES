package edu.java.gui02;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GuiMain02 {

	private JFrame frame;
	private JTextField textInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain02 window = new GuiMain02();
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
	public GuiMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutput = new JLabel("오늘은 월요일 입니다.");
		lblOutput.setBackground(Color.WHITE);
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblOutput.setForeground(Color.BLUE);
		lblOutput.setBounds(12, 10, 410, 47);
		frame.getContentPane().add(lblOutput);
		
		// 이벤트 리스너에서 접근하는 변수들은 
		// 멤버 변수로 선언하는 것이 좋음
		
		textInput = new JTextField();
		textInput.setBounds(12, 67, 410, 69);
		textInput.setFont(new Font("맑은 고딕" , Font.PLAIN, 24));
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JButton btnInput = new JButton("입력");
		btnInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼을 클릭하면
				// JTextFieled에 입력된 내용을 읽어서
				// JLbel에 출력(쓰기)
				String msg = textInput.getText();
				System.out.println(msg);
				lblOutput.setText(msg);
			}
		});
		
		btnInput.setBounds(12, 146, 410, 105);
		btnInput.setFont(new Font("굴림", Font.PLAIN, 18));
		frame.getContentPane().add(btnInput);
		
		System.out.println("initialize 메소드 호출 끝");
		
	}
}
