package jeyeong.contactMain;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickableCheckboxTableExample extends JFrame {

    public ClickableCheckboxTableExample() {
        setTitle("Clickable Checkbox Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create sample data for the table
        Object[][] data = {
                {false, "Item 1"},
                {false, "Item 2"},
                {false, "Item 3"},
                {false, "Item 4"},
                {false, "Item 5"}
        };
        String[] columnNames = {"Select", "Name",};// 늘리면 테이블 칸도 늘어남

        // Create a table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames);//기본테이블 모델

        // Create JTable with the model
        JTable table = new JTable(model);// 테이블

        // Set the cell renderer for the first column to render checkboxes
        table.getColumnModel().getColumn(0).setCellRenderer(new CheckBoxRenderer());// 테이블을 체크하는 코드
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 체크 상태 변경
                int column = table.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / table.getRowHeight();

                if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                    Object value = table.getValueAt(row, column);
                    if (value instanceof Boolean) {
                        table.setValueAt(!(Boolean) value, row, column);
                    }
                }
            }
        });

        // Adjust column width
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50); // Adjust checkbox column width

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    // Custom cell renderer for rendering checkboxes
    class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
        CheckBoxRenderer() {// 수평 정렬 코드
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setSelected(value != null && (Boolean) value);
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClickableCheckboxTableExample());
    }
}