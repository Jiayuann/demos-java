import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TableColumnWidthTest extends JFrame {
    private static final long serialVersionUID = -5184493067189341828L;
    private JPanel contentPane;
    private JTable table;
    private JComboBox comboBox;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableColumnWidthTest frame = new TableColumnWidthTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public TableColumnWidthTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u8C03\u6574\u8868\u683C\u5404\u5217\u5BBD\u5EA6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        comboBox = new JComboBox();
        comboBox.addItem("AUTO_RESIZE_ALL_COLUMNS");
        comboBox.addItem("AUTO_RESIZE_LAST_COLUMN");
        comboBox.addItem("AUTO_RESIZE_NEXT_COLUMN");
        comboBox.addItem("AUTO_RESIZE_OFF");
        comboBox.addItem("AUTO_RESIZE_SUBSEQUENT_COLUMNS");
        comboBox.setSelectedIndex(4);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_comboBox_actionPerformed(e);
            }
        });
        comboBox.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        
        panel.add(comboBox);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
        table.setRowHeight(35);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[] { "2012◊Ó–¬”Ô—‘≈≈√˚", "”Ô—‘√˚"  });
        tableModel.addRow(new Object[] {  "1", "C" });
        tableModel.addRow(new Object[] { "2", "Java"  });
        tableModel.addRow(new Object[] { "3", "C++"  });
        tableModel.addRow(new Object[] {  "4", "Objective-C"  });
        table.setModel(tableModel);
    }
    
    protected void do_comboBox_actionPerformed(ActionEvent e) {
        Map<String, Integer> columnModel = new HashMap<String, Integer>();
        columnModel.put("AUTO_RESIZE_ALL_COLUMNS", JTable.AUTO_RESIZE_ALL_COLUMNS);
        columnModel.put("AUTO_RESIZE_LAST_COLUMN", JTable.AUTO_RESIZE_LAST_COLUMN);
        columnModel.put("AUTO_RESIZE_NEXT_COLUMN", JTable.AUTO_RESIZE_NEXT_COLUMN);
        columnModel.put("AUTO_RESIZE_OFF", JTable.AUTO_RESIZE_OFF);
        columnModel.put("AUTO_RESIZE_SUBSEQUENT_COLUMNS", JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        String text = (String) comboBox.getSelectedItem();
        table.setAutoResizeMode(columnModel.get(text));
    }
}
