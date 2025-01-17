package jeyeong.contactMainqwe;

import javax.swing.*;
import java.awt.*;

public class CategoryExample extends JFrame {
    
    public CategoryExample() {
        setTitle("Category Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());
        
        // 카테고리 목록
        String[] categories = {"Category 1", "Category 2", "Category 3", "Category 4"};
        
        // JComboBox 생성 및 카테고리 목록 추가
        JComboBox<String> categoryComboBox = new JComboBox<>(categories);
        
        // JComboBox에 선택 이벤트 리스너 추가
        categoryComboBox.addActionListener(e -> {
            // 선택된 항목을 출력
            System.out.println("Selected category: " + categoryComboBox.getSelectedItem());
        });
        
        // 프레임에 JComboBox 추가
        add(categoryComboBox);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CategoryExample::new);
    }
}