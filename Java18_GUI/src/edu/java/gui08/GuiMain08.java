package edu.java.gui08;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain08 {

	private JFrame frame;
	private static final ImageIcon[] IMAGE_ICONS = {
			new ImageIcon("res/dog1.jpg"),
			new ImageIcon("res/dog2.jpg"),
			new ImageIcon("res/dog3.jpg"),
			new ImageIcon("res/dog4.jpg")
	};

	private int index = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain08 window = new GuiMain08();
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
	public GuiMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutput = new JLabel();
		lblOutput.setIcon(IMAGE_ICONS[0]);
		lblOutput.setFont(new Font("굴림", Font.BOLD, 42));
		lblOutput.setBounds(12, 10, 410, 131);
		frame.getContentPane().add(lblOutput);
		
		JButton dtmPrev = new JButton("이전");
		dtmPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index > 0) {
					index--;
				}else {
					index = IMAGE_ICONS.length -1;
				}
				lblOutput.setIcon(IMAGE_ICONS[index]);
			}
		});
		dtmPrev.setBounds(12, 187, 203, 164);
		frame.getContentPane().add(dtmPrev);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index < IMAGE_ICONS.length -1) {
					index++;
				}else {
					index = 0;
				}
				lblOutput.setIcon(IMAGE_ICONS[index]);
			}
		});
		btnNext.setBounds(227, 187, 195, 164);
		frame.getContentPane().add(btnNext);
		
		JButton btnNewButton = new JButton("버튼");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double rX = Math.random();
				int x = (int)(IMAGE_ICONS.length * rX);
				lblOutput.setIcon(IMAGE_ICONS[x]);
				
			}
		});
		btnNewButton.setBounds(12, 151, 410, 23);
		frame.getContentPane().add(btnNewButton);

}
}