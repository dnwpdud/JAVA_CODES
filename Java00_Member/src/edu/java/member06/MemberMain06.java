package edu.java.member06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberMain06 {

	private JFrame frame;
	
	private JTable table;
	private String[] colNames = {"아이디", "비밀번호", "이름", "이메일", "취미", "가입일"};
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	
	private static MemberDAO dao;
	
	public static void main(String[] args) {
		dao = MemberDAOImple.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain06 window = new MemberMain06();
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
	public MemberMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertFrame insertFrame = new InsertFrame();
				insertFrame.setVisible(true);
			}
		});
		btnInsert.setBounds(12, 10, 76, 55);
		frame.getContentPane().add(btnInsert);
		
		JButton btnSelectAll = new JButton("전체 검색");
		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAllMember();
			}
		});
		btnSelectAll.setBounds(108, 10, 101, 55);
		frame.getContentPane().add(btnSelectAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 91, 530, 264);
		frame.getContentPane().add(scrollPane);
		
		tableModel = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		scrollPane.setViewportView(table);
	}
	
	private void selectAllMember() {
		ArrayList<MemberVO> list = dao.select();
		tableModel.setRowCount(0);
		
		for(int i = 0; i < list.size(); i++) {
			records[0] = list.get(i).getId();
			records[1] = list.get(i).getPw();
			records[2] = list.get(i).getName();
			records[3] = list.get(i).getEmail();
			records[4] = list.get(i).getInterest();
			records[5] = list.get(i).getRegDate();
			tableModel.addRow(records);
		}
		
	}
	 
} // end MemberMain05
