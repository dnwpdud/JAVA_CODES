package edu.java.gui07;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain07 {

	private JFrame frame;
	private static final String[] STRINGS = {
			"1. 김근수",
			"2. 김시훈",
			"3. 김주영",
			"4. 노성욱",
			"5. 박정민",
			"6. 신중비",
			"7. 양준혁",
			"8. 우제영",
			"9. 위승혁",
			"10. 이현우",
			"11. 조현",
			"12. 최정현",
			"13. 홍지안",
			"14. 김한빈",
			"15. 정의원",
			"16. 임창준",
			"17. 민예인",
			"18. 박혜준",
			"19. 권보성"
	};
	
	private int index = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain07 window = new GuiMain07();
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
	public GuiMain07() {
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
		lblOutput.setText(STRINGS[0]);
		lblOutput.setFont(new Font("굴림", Font.BOLD, 42));
		lblOutput.setBounds(12, 10, 410, 131);
		frame.getContentPane().add(lblOutput);
		
		JButton dtmPrev = new JButton("이전");
		dtmPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(index <0) {
					index--;
				}else {
					index = 0;
				}
				lblOutput.setText(STRINGS[index]);
			}
		});
		dtmPrev.setBounds(12, 176, 203, 175);
		frame.getContentPane().add(dtmPrev);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index < STRINGS.length -1) {
					index++;
				}else {
					index = 0;
				}
				lblOutput.setText(STRINGS[index]);
			}
		});
		btnNext.setBounds(227, 176, 195, 175);
		frame.getContentPane().add(btnNext);
		
		//
		JButton btnNewButton = new JButton("버튼");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double rX = Math.random();
				int x = (int)(19 * rX);
				lblOutput.setText(STRINGS[x]);
			}
		});
		
		btnNewButton.setBounds(12, 143, 410, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
