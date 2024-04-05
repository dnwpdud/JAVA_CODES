package edu.java.gui09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain09 {

	private JFrame frame;
	private JButton btnOutput;// 움김 버튼 변수는 다른변수들이 사용할 때가 많아 위치에 제악을 들 받아야된다.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain09 window = new GuiMain09();
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
	public GuiMain09() {
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(8, 35, 414, 216);
		frame.getContentPane().add(textArea);
		
		
		JCheckBox chckbxMusic = new JCheckBox("음악");
		chckbxMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chckbxMusic.setBounds(8, 6, 69, 23);
		frame.getContentPane().add(chckbxMusic);
		
		JCheckBox chckbxMovie = new JCheckBox("영화");
		chckbxMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chckbxMovie.setBounds(81, 6, 69, 23);
		frame.getContentPane().add(chckbxMovie);
		
		JCheckBox chckbxReading = new JCheckBox("독서");
		chckbxReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxReading.isSelected()) {
					btnOutput.setEnabled(false);
				}else {
					btnOutput.setEnabled(true);
				}
			}
		});
		chckbxReading.setBounds(154, 6, 69, 23);
		frame.getContentPane().add(chckbxReading);
		
		btnOutput = new JButton("출력");
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "음악 : " + chckbxMusic.isSelected() + "\n"
				+ "영화 : " + chckbxMovie.isSelected() + "\n"
				+ "독서 : " + chckbxReading.isSelected() + "\n";
				textArea.setText(result);
			}
		});
		btnOutput.setBounds(325, 6, 97, 23);
		frame.getContentPane().add(btnOutput);
	}
}
