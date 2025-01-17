package edu.java.sideproject;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import oracle.jdbc.OracleDriver;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class PartManagementMain {
	JFrame frame;
	private JTextField txtpartIndex, txtpartNo, txtpartName,
	txtpartRating, txtmanagerIndex;
	private JTextArea txtAreaInfo, txtAreaLog;
	ArrayList<PartManagementVO> list;
	private static PartManagementDAO dao;
	
	private JTable table;
	private String[] colNames = {"부품번호", "부품종류", "부품이름", "부품등급", 
			"제조일자","관리자ID", "사용횟수"}; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수
	/**
	 * @wbp.nonvisual location=-30,219
	 */
	private final JPanel panel = new JPanel();
	private JTextField txtPartUse;

	public static void main(String[] args) {
		dao = PartManagementDAOImple.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					PartManagementMain window = new PartManagementMain();
//					window.frame.setVisible(true);
					LoginPane window = new LoginPane();
					window.setVisible(true);
//					EquipmentInform equipmentInform = new EquipmentInform();
//					equipmentInform.equipmentframeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// end main()
	
	public PartManagementMain() {
		initialize();
	}
	//protected 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("부품관리 프로그램");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 10, 209, 35);
		frame.getContentPane().add(lblNewLabel);
		
		// 이름 Text 크기
		int nameWidth1 = 80;
		int nameLength1 = 30;
		
		// 입력 Text 크기
		int inputWidth2 = 200;
		int inputLength2 = 45;
		
		
		JLabel lblpartNo = new JLabel("부품 번호");
		lblpartNo.setBounds(13, 59, inputWidth2, nameLength1);
		frame.getContentPane().add(lblpartNo);
		
		JLabel lblpartIndex = new JLabel("부품 종류");
		lblpartIndex.setBounds(238, 59, inputWidth2, nameLength1);
		frame.getContentPane().add(lblpartIndex);
		
		JLabel lblpartName = new JLabel("부품 이름");
		lblpartName.setBounds(12, 142, inputWidth2, nameLength1);
		frame.getContentPane().add(lblpartName);
		
		JLabel lblmanagerIndex = new JLabel("관리자 ID");
		lblmanagerIndex.setBounds(450, 59, inputWidth2, nameLength1);
		frame.getContentPane().add(lblmanagerIndex);
		
		JLabel lblpartRating = new JLabel("부품 등급");
		lblpartRating.setBounds(238, 142, inputWidth2, nameLength1);
		frame.getContentPane().add(lblpartRating);
		
		JButton btnInsertButton = new JButton("등록");
		btnInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String partNo = txtpartNo.getText();
				String partCategory = txtpartIndex.getText();
				String partName = txtpartName.getText();
				String partRating = txtpartRating.getText();
				String managerIndex = txtmanagerIndex.getText();
				if(partNo.isBlank() || partCategory.isBlank() || partName.isBlank() || 
						partRating.isBlank() || managerIndex.isBlank()) {
					JOptionPane.showMessageDialog(btnInsertButton, "모든 빈칸을 입력해주세요");
					return;
				}
				insertPartManagement();
				selectALLPartManagementTable();
			}
		});
		btnInsertButton.setBounds(252, 19, nameWidth1, nameLength1);
		frame.getContentPane().add(btnInsertButton);
		
		JButton btnSearchALLButton = new JButton("전체검색");
		btnSearchALLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectALLPartManagement();
				selectALLPartManagementTable();
			}
		});
		
		JButton btnSearchButton = new JButton("검색");
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String partNo = txtpartNo.getText();
				if(partNo.isBlank()) {
					JOptionPane.showMessageDialog(btnInsertButton, "부품번호 빈칸을 입력해주세요");
					return;
				} 
				selectPartManagement();
			}
		});
		btnSearchButton.setBounds(552, 19, nameWidth1, nameLength1);
		frame.getContentPane().add(btnSearchButton);
		
		btnSearchALLButton.setBounds(644, 19, 110, 30);
		frame.getContentPane().add(btnSearchALLButton);

		JButton btnUpdateButton = new JButton("수정");
		btnUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String partNo = txtpartNo.getText();
				if(partNo.isBlank()) {
					JOptionPane.showMessageDialog(btnInsertButton, "부품번호 빈칸을 입력해주세요");
					return;
				}
				updatePartManagement();
				selectALLPartManagementTable();
			}
		});
		btnUpdateButton.setBounds(358, 19, nameWidth1, nameLength1);
		frame.getContentPane().add(btnUpdateButton);
		
		JButton btnDeleteButton = new JButton("삭제");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String partNo = txtpartNo.getText();
				if(partNo.isBlank()) {
					JOptionPane.showMessageDialog(btnInsertButton, "부품번호 빈칸을 입력해주세요");
					return;
				}
				deletePartManagement();
				selectALLPartManagementTable();
			}
		});
		btnDeleteButton.setBounds(460, 19, nameWidth1, nameLength1);
		frame.getContentPane().add(btnDeleteButton);
		
		JButton btnLoninButton_4 = new JButton("로그아웃");
		btnLoninButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPane loginPane = new LoginPane();
				loginPane.setVisible(true); /// 보여주는 함수
				frame.setVisible(false);// 메인 프레임을 안보이게
			}
		});
		btnLoninButton_4.setBounds(860, 18, 101, 30);
		frame.getContentPane().add(btnLoninButton_4);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(702, 154, 270, 218);
		frame.getContentPane().add(scrollPane_1);

		txtAreaLog = new JTextArea();
		txtAreaLog.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane_1.setViewportView(txtAreaLog);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 382, 960, 102);
		frame.getContentPane().add(scrollPane);

		txtAreaInfo = new JTextArea();
		txtAreaInfo.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane.setViewportView(txtAreaInfo);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 494, 960, 257);
		frame.getContentPane().add(scrollPane_2);
		
		// 테이블 초기화
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
				int row = table.getSelectedRow();
				//int col = table.getSelectedColumn();
				//Object value = table.getSelectedRow()
				list.get(table.getSelectedRow());
				System.out.println(list.get(table.getSelectedRow()));
				//System.out.println(value);
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		
		scrollPane_2.setViewportView(table);
		
		txtpartIndex = new JTextField();
		
		txtpartIndex.setBounds(238, 89, inputWidth2, inputLength2);
		frame.getContentPane().add(txtpartIndex);
		txtpartIndex.setColumns(10);
		
		txtpartNo = new JTextField();
		txtpartNo.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				txtpartNo.setText("");
			}
		});
		txtpartNo.setText("검색창: 번호입력");
		txtpartNo.setColumns(10);
		txtpartNo.setBounds(12, 89, inputWidth2, inputLength2);
		frame.getContentPane().add(txtpartNo);
		
		txtpartRating = new JTextField();
		txtpartRating.setColumns(10);
		txtpartRating.setBounds(238, 173, inputWidth2, inputLength2);
		frame.getContentPane().add(txtpartRating);
		
		txtpartName = new JTextField();
		txtpartName.setColumns(10);
		txtpartName.setBounds(12, 173, 200, 45);
		frame.getContentPane().add(txtpartName);
		
		txtmanagerIndex = new JTextField();
		txtmanagerIndex.setColumns(10);
		txtmanagerIndex.setBounds(450, 89, 200, 45);
		frame.getContentPane().add(txtmanagerIndex);
		
		JButton btnSearchALLButton_2 = new JButton("설비 프로그램");
		btnSearchALLButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipmentInform equipmentInform = new EquipmentInform();
				equipmentInform.equipmentframeFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSearchALLButton_2.setBounds(803, 59, 158, 30);
		frame.getContentPane().add(btnSearchALLButton_2);
		
		JLabel lblPartUse = new JLabel("사용 횟수");
		lblPartUse.setBounds(450, 143, 200, 30);
		frame.getContentPane().add(lblPartUse);
		
		txtPartUse = new JTextField();
		txtPartUse.setColumns(10);
		txtPartUse.setBounds(450, 173, 200, 45);
		frame.getContentPane().add(txtPartUse);
		
		JLabel lblNewLabel_1 = new JLabel("검색 결과");
		lblNewLabel_1.setBounds(12, 341, 145, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("상태 창");
		lblNewLabel_2.setBounds(702, 123, 80, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		
	}// end initialize()
	
	// PART_MANAGEMENT 배열에 PART_MANAGEMENT배열 저장
	private void insertPartManagement() {// 일단 완료
		try {
			String partNo = txtpartNo.getText();
			String partType = txtpartIndex.getText();
			String partName = txtpartName.getText();
			String partRating = txtpartRating.getText();
			String managerIndex = txtmanagerIndex.getText();
			int partUse = Integer.parseInt(txtPartUse.getText());
			PartManagementVO vo = new PartManagementVO(partNo, partType
					, partName, partRating, null, managerIndex, partUse);
					
			
			int result = dao.insert(vo);
			System.out.println(vo);
			int size = dao.getSize();
			if(result == 1) {
				txtAreaLog.setText("등록된 부품 개수 : " + size + "\n"
						+ "부품 등록 완료");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "사용횟수가 숫자가 아닙니다.");
		}
		
	}// end insertPartManagement()
	
	private void selectALLPartManagement() {
		
		int size = ((PartManagementDAOImple)dao).getSize();
		ArrayList<PartManagementVO> list = dao.selectALL();
		StringBuffer buffer = new StringBuffer();
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < size; i++) {
			buffer.append("부품[" + i + "] \n"
					+ list.get(i) + "\n");
		}
		txtAreaInfo.setText(buffer.toString());
		long endTime = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (endTime - startTime));
		
		PartManagementVO vo = new PartManagementVO();
		System.out.println(vo.getManufacturing());
	}// end selectALLPartManagement()
	
	private void selectPartManagement() {
		String partNo = txtpartNo.getText();
		
//		int size = ((PartManagementDAOImple)dao).getSize();
//		if(partIndex >= 0 && partIndex < size) {
		
			txtAreaInfo.setText(dao.select(partNo).toString());
		
		System.out.println(dao.select(partNo));
			System.out.println("검색완료");
//			selectPartManagementTable(dao.select(partNo));
//		} else {
//			txtAreaLog.setText("해당 인덱스에 부품이 없습니다.");
//		}
	}// end selectPartManagement()
	
	private void updatePartManagement() {// 오류 고치기 3.8 야간작업 후 결론
	
		
		int size = ((PartManagementDAOImple)dao).getSize();
		
//		if(index >= 0 && index < size) {
			
			String partNo = txtpartNo.getText();
			String partType = txtpartIndex.getText();
			String partName = txtpartName.getText();
			String partRating = txtpartRating.getText();
			String managerIndex = txtmanagerIndex.getText();
			int partUse = Integer.parseInt(txtPartUse.getText());
			
			PartManagementVO vo = new PartManagementVO(partNo, partType
					, partName, partRating, null, managerIndex, partUse);
			
			int result = dao.update(partNo, vo);
			
			if(result == 1) {
				txtAreaLog.setText("부품 수정 완료!");
			}
//		} 
	else {
		JOptionPane.showMessageDialog(frame, "사용횟수가 숫자가 아닙니다.");
	}
			System.out.println(vo.getManufacturing());
	}// end updatePartManagement()

	private void deletePartManagement() {
		String partNo = txtpartNo.getText();
		
//		int size = ((PartManagementDAOImple)dao).getSize();
//		if(index >= 0 && index < size) {
			int result = dao.delete(partNo);
			
			
			txtAreaLog.setText("부품 삭제 완료!");
			PartManagementVO vo = new PartManagementVO();
			System.out.println(vo.getManufacturing());
//	} else {
//		txtAreaInfo.setText("해당 인덱스에 부품이 없어 삭제 불가 했습니다.");
//	}
} // end deletePartManagement
	private void selectALLPartManagementTable() {
		list = dao.selectALL();
		tableModel.setRowCount(0);
		for(int i = 0; i < list.size(); i++) {
			PartManagementVO vo = list.get(i);
			records[0] = vo.getPartNo();
			records[1] = vo.getPartType();
			records[2] = vo.getPartName();
			records[3] = vo.getPartRating();
			records[4] = vo.getManufacturing();
			records[5] = vo.getManagerIndex();
			records[6] = vo.getPartUse();
			tableModel.addRow(records);
		}
	}// end selectALLPartManagementTable()
	
//	private void selectPartManagementTable(String partNo) {
//		list = dao.selectALL();
//		tableModel.setRowCount(0);
//		for(int i = 0; i < list.size(); i++) {
//			PartManagementVO vo = list.get(i);
//			if(vo.getPartNo() == partNo){
//				records[0] = vo.getPartNo();
//				records[1] = vo.getPartType();
//				records[2] = vo.getPartName();
//				records[3] = vo.getPartRating();
//				records[4] = vo.getManufacturing();
//				records[5] = vo.getManagerIndex();
//				records[6] = vo.getPartUse();
//				tableModel.addRow(records);
//			}
//		}
//	}
//	
}// end PartManagementMain
