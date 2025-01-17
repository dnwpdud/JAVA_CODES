package edu.java.sideproject;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EquipmentInform {
	JFrame equipmentframeFrame;
	
	private JTextField txtequipmentName
	, txtpartRating, txtpartCategory, txtuserId;
	
	private JTextArea txtAreaInfo, txtAreaLog;
	
	private JTable table, tab, table_1;
	
	private String[] colNames = {"설비이름", "설비종류", "부품 사용횟수", 
			"부품 등급", "부품 사용일자", "부품번호", "사용자ID"}; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수
	
	private String[] colNames2 = {"부품종류", "부품번호", "부품이름", "부품등급", 
			"제조일자","관리자ID", "부품 사용횟수"}; // 테이블 헤더에 들어갈 이름들 , 
	private Object[] records2 = new Object[colNames2.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableMode2; // 테이블 형태를 만들 모델 변수
	
	private static EquipmentInformDAO equipmentInformDao;
	
	private static PartManagementDAO dao;
	private JTextField txtPartUse;
	private JTextField txtequipmentLocation;
	public EquipmentInform() {
		dao = PartManagementDAOImple.getInstance();
		equipmentInformDao = EquipmentInformDAOImple.getEquipmentInform();
		
		equipmentframeFrame = new JFrame();
		equipmentframeFrame.setBounds(100, 100, 1000, 800);
		equipmentframeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		equipmentframeFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("설비 프로그램");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 10, 209, 35);
		equipmentframeFrame.getContentPane().add(lblNewLabel);
		
		// 이름 Text 크기
		int nameWidth1 = 80;
		int nameLength1 = 30;
		
		// 입력 Text 크기
		int inputWidth2 = 200;
		int inputLength2 = 45;
		
		
		JLabel lblequipmentName = new JLabel("설비 이름");
		lblequipmentName.setBounds(12, 55, inputWidth2, nameLength1);
		equipmentframeFrame.getContentPane().add(lblequipmentName);
		
		JLabel lblpartCategory = new JLabel("설비 종류");
		lblpartCategory.setBounds(238, 55, inputWidth2, nameLength1);
		equipmentframeFrame.getContentPane().add(lblpartCategory);
		
		JLabel lblpartRating = new JLabel("부품 등급");
		lblpartRating.setBounds(12, 140, inputWidth2, nameLength1);
		equipmentframeFrame.getContentPane().add(lblpartRating);
		
		JButton btnInsertButton = new JButton("등록");
		btnInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipmentName = txtequipmentName.getText();
				String partCategory = txtpartCategory.getText();
				String PartUse = txtPartUse.getText();
				String equipmentLocation = txtequipmentLocation.getText();
				String partRating = txtpartRating.getText();
				String userId = txtuserId.getText();
				
				if(equipmentName.isBlank() || partCategory.isBlank() || PartUse.isBlank() || 
						equipmentLocation.isBlank() || partRating.isBlank() || userId.isBlank() ) {
					JOptionPane.showMessageDialog(btnInsertButton, "모든 빈칸을 입력해주세요");
					return;
				}
				insertEquipment();
				selectALLEquipmentTable1();
			}
		});
		btnInsertButton.setBounds(252, 19, nameWidth1, nameLength1);
		equipmentframeFrame.getContentPane().add(btnInsertButton);
		
		JButton btnSearchALLButton = new JButton("설비 전체검색");
		btnSearchALLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectALLEquipment();
				selectALLEquipmentTable1();
			}
		});
		
		JButton btnSearchButton = new JButton("검색");
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipmentName = txtequipmentName.getText();
				if(equipmentName.isBlank()) {
					JOptionPane.showMessageDialog(btnInsertButton, "설비이름을 입력해주세요");
					return;
				}
				selectEquipment();
				selectALLEquipmentTable1();
			}
		});
		btnSearchButton.setBounds(552, 19, nameWidth1, nameLength1);
		equipmentframeFrame.getContentPane().add(btnSearchButton);
		
		btnSearchALLButton.setBounds(691, 58, 270, 23);
		equipmentframeFrame.getContentPane().add(btnSearchALLButton);

		JButton btnUpdateButton = new JButton("수정");
		btnUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipmentName = txtequipmentName.getText();
				if(equipmentName.isBlank()) {
					JOptionPane.showMessageDialog(btnInsertButton, "설비이름을 입력해주세요");
					return;
				}
				updateEquipment();
				selectALLEquipmentTable1();
			}
		});
		btnUpdateButton.setBounds(358, 19, nameWidth1, nameLength1);
		equipmentframeFrame.getContentPane().add(btnUpdateButton);
		
		JButton btnDeleteButton = new JButton("삭제");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipmentName = txtequipmentName.getText();
				if(equipmentName.isBlank()) {
					JOptionPane.showMessageDialog(btnInsertButton, "설비이름을 입력해주세요");
					return;
				}
				deleteEquipment();
				selectALLEquipmentTable1();
			}
		});
		btnDeleteButton.setBounds(460, 19, nameWidth1, nameLength1);
		equipmentframeFrame.getContentPane().add(btnDeleteButton);
		
		JButton btnLoninButton_4 = new JButton("로그아웃");
		btnLoninButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPane loginPane = new LoginPane();
				loginPane.setVisible(true); /// 보여주는 함수
				equipmentframeFrame.setVisible(false);// 메인 프레임을 안보이게
			}
		});
		btnLoninButton_4.setBounds(833, 18, 128, 30);
		equipmentframeFrame.getContentPane().add(btnLoninButton_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(691, 142, 281, 44);
		equipmentframeFrame.getContentPane().add(scrollPane_1);

		txtAreaLog = new JTextArea();
		txtAreaLog.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane_1.setViewportView(txtAreaLog);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 267, 960, 59);
		equipmentframeFrame.getContentPane().add(scrollPane);

		txtAreaInfo = new JTextArea();
		txtAreaInfo.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane.setViewportView(txtAreaInfo);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 540, 960, 211);
		equipmentframeFrame.getContentPane().add(scrollPane_2);
		
		
		
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
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				System.out.println(value);
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		
		scrollPane_2.setViewportView(table);
		
		txtpartCategory = new JTextField();
		txtpartCategory.setBounds(238, 85, inputWidth2, inputLength2);
		equipmentframeFrame.getContentPane().add(txtpartCategory);
		txtpartCategory.setColumns(10);
		
		txtequipmentName  = new JTextField();
		txtequipmentName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				txtequipmentName.setText("");
			}
		});
		txtequipmentName.setText("검색창: 설비이름 입력");
		txtequipmentName .setColumns(10);
		txtequipmentName .setBounds(12, 85, inputWidth2, inputLength2);
		equipmentframeFrame.getContentPane().add(txtequipmentName );
		
		txtpartRating  = new JTextField();
		txtpartRating .setColumns(10);
		txtpartRating .setBounds(12, 171, inputWidth2, inputLength2);
		equipmentframeFrame.getContentPane().add(txtpartRating );
		
		txtuserId  = new JTextField();
		txtuserId .setColumns(10);
		txtuserId .setBounds(470, 170, 200, 45);
		equipmentframeFrame.getContentPane().add(txtuserId );
		
		JLabel lbluserId = new JLabel("사용자 ID");
		lbluserId.setBounds(470, 140, 200, 30);
		equipmentframeFrame.getContentPane().add(lbluserId);
		
		JLabel lblpartRating_2 = new JLabel("설비 목록");
		lblpartRating_2.setBounds(12, 511, 128, 30);
		equipmentframeFrame.getContentPane().add(lblpartRating_2);
		
		JLabel lblpartRating_2_1 = new JLabel("부품 목록");
		lblpartRating_2_1.setBounds(12, 336, 128, 30);
		equipmentframeFrame.getContentPane().add(lblpartRating_2_1);
		
		JButton btnSearchALLButton_2 = new JButton("부품 전체검색");
		btnSearchALLButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectALLEquipmentTable2();
				
			}
		});
		btnSearchALLButton_2.setBounds(691, 91, 270, 23);
		equipmentframeFrame.getContentPane().add(btnSearchALLButton_2);
		
		JScrollPane abc = new JScrollPane();
		abc.setBounds(12, 364, 960, 149);
		equipmentframeFrame.getContentPane().add(abc);
		
		tab = new JTable((TableModel) null);
		tab.setFont(new Font("굴림", Font.PLAIN, 15));
		tab.setBounds(0, 0, 958, 1);
		
		// 테이블 초기화
		tableMode2 = new DefaultTableModel(colNames2, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_1 = new JTable(tableMode2);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row1 = table_1.getSelectedRow();
				int col1 = table_1.getSelectedColumn();
				Object value1 = table_1.getValueAt(row1, col1);
				System.out.println(value1);
			}
		});
		table_1.setFont(new Font("굴림", Font.PLAIN, 15));
		
		abc.setViewportView(table_1);
		
		txtPartUse = new JTextField();
		txtPartUse.setColumns(10);
		txtPartUse.setBounds(470, 85, 200, 45);
		equipmentframeFrame.getContentPane().add(txtPartUse);
		
		JLabel lblPartUse = new JLabel("사용횟수");
		lblPartUse.setBounds(470, 55, 200, 30);
		equipmentframeFrame.getContentPane().add(lblPartUse);
		
		txtequipmentLocation = new JTextField();
		txtequipmentLocation.setColumns(10);
		txtequipmentLocation.setBounds(238, 171, 200, 45);
		equipmentframeFrame.getContentPane().add(txtequipmentLocation);
		
		JLabel lblEquipmentLocation = new JLabel("부품 NO");
		lblEquipmentLocation.setBounds(238, 140, 200, 30);
		equipmentframeFrame.getContentPane().add(lblEquipmentLocation);
		
		JLabel lblNewLabel_1 = new JLabel("검색 결과");
		lblNewLabel_1.setBounds(12, 226, 145, 31);
		equipmentframeFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("상태 창");
		lblNewLabel_2.setBounds(691, 111, 80, 21);
		equipmentframeFrame.getContentPane().add(lblNewLabel_2);

	}
	
	private void insertEquipment() {
		String equipmentName = txtequipmentName.getText();
		String equipmentType = txtpartCategory.getText();
		int partUse = Integer.parseInt(txtPartUse.getText());
		String equipmentRating = txtpartRating.getText();
		String equipmentLocation = txtequipmentLocation.getText();
		String userId = txtuserId.getText();
		
		EquipmentInformVO vo = new EquipmentInformVO(equipmentName, equipmentType
				, partUse, equipmentRating, null, equipmentLocation, userId);
		
		int result = equipmentInformDao.EquipmentInformInsert(vo);
		int size = ((EquipmentInformDAOImple)equipmentInformDao).getEquipmentInformSize();
		
		System.out.println(vo.getPartOutTime());
		if(result == 1) {
			txtAreaLog.setText("등록된 설비 개수 : " + size + "\n"
						+ "설비 등록 완료");
		}
	}// end insertEquipment()
	
	private void selectALLEquipment() {
		int size = ((EquipmentInformDAOImple)equipmentInformDao).getEquipmentInformSize();
		ArrayList<EquipmentInformVO> list = equipmentInformDao.EquipmentInformSelectALL();
		StringBuffer buffer = new StringBuffer();
		long startTime = System.currentTimeMillis();
		for(int i = 0; i< size; i++) {
			buffer.append("설비[" + i + "] \n"
					+ list.get(i) + "\n");
			
		}
		txtAreaInfo.setText(buffer.toString());
		long endTime = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (endTime - startTime));
	}// end selectALLEquipment
	
	private void selectEquipment() {
		String equipmentName = txtequipmentName.getText();
		txtAreaInfo.setText(equipmentInformDao.EquipmentInformSelect(equipmentName).toString());
		System.out.println("검색완료");
	}// end selectEquipment
	
	private void updateEquipment() {
		int size = ((EquipmentInformDAOImple)equipmentInformDao).getEquipmentInformSize();
		
		String equipmentName = txtequipmentName.getText();
		String equipmentType = txtpartCategory.getText();
		int partUse = Integer.parseInt(txtPartUse.getText());
		String equipmentRating = txtpartRating.getText();
		String equipmentLocation = txtequipmentLocation.getText();
		String userId = txtuserId.getText();
		
		EquipmentInformVO vo = new EquipmentInformVO(equipmentName, equipmentType
				, partUse, equipmentRating, null, equipmentLocation, userId);
		int result = equipmentInformDao.EquipmentInformUpdate(equipmentName, vo);
		
		if(result == 1) {
			txtAreaLog.setText("설비 수정 완료");
		} else {
			txtAreaInfo.setText("입력한 설비가 없어 수정 불가 합니다.");
		}
	}// end updateEquipment
	
	private void deleteEquipment() {
		String equipmentName = txtequipmentName.getText();
		
		int result = equipmentInformDao.EquipmentInformDelete(equipmentName);
		
		txtAreaLog.setText("설비 삭제 완료");
	}// end deleteEquipment
	
	
	
	private void selectALLEquipmentTable1() {
		ArrayList<EquipmentInformVO> list = equipmentInformDao.EquipmentInformSelectALL();
		tableModel.setRowCount(0);
		
		for(int i = 0; i < list.size(); i++) {
			EquipmentInformVO vo = list.get(i);
			records[0] = vo.getEquipmentName();
			records[1] = vo.getEquipmentType();
			records[2] = vo.getPartUse();
			records[3] = vo.getPartRating();
			records[4] = vo.getPartOutTime();// 여기서 한 단계 밀림// 여기는 저장 자체가 안됬고
			records[5] = vo.getEquipmentLocation();
//			System.out.println(vo.getEquipmentLocation());// 여기는 시간이 저장 되었다.
			records[6] = vo.getUserId();
			tableModel.addRow(records);
		}
	}// end selectALLEquipmentTable
	
	private void selectALLEquipmentTable2() {
		ArrayList<PartManagementVO> list = dao.selectALL();
		tableMode2.setRowCount(0);
		for(int i = 0; i < list.size(); i++) {
			PartManagementVO vo = list.get(i);
			records2[0] = vo.getPartType();
			records2[1] = vo.getPartNo();
			records2[2] = vo.getPartName();
			records2[3] = vo.getPartRating();
			records2[4] = vo.getManufacturing();
			records2[5] = vo.getManagerIndex();
			records2[6] = vo.getPartUse();
			tableMode2.addRow(records2);
		}
	}// end selectALLEquipmentTable
}// end EquipmentInform
