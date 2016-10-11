import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableSearch extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3619887890741475524L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableSearch frame = new TableSearch();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public TableSearch() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u652F\u6301\u67E5\u627E\u529F\u80FD\u7684\u8868\u683C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        
        JLabel label = new JLabel("\u5173\u952E\u5B57\uFF1A");
        label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(20);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("\u67E5\u627E");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        buttonPanel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[] { "–’√˚", "—ß∫≈", "ø∆ƒø", "≥…º®", "≈≈√˚",  });
        tableModel.addRow(new Object[] { "ÕÚ±˘", "005", "”¢”Ô", "96", "1" });
        tableModel.addRow(new Object[] { "¿ÓΩ°", "020", "”¢”Ô", "94", "2" });
        tableModel.addRow(new Object[] { "¿Óƒ¨", "056", "”¢”Ô", "92", "3" });
        tableModel.addRow(new Object[] { " ¢Àß", "041", "”¢”Ô", "91", "4" });
        sorter.setModel(tableModel);
        table.setRowSorter(sorter);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        sorter.setRowFilter(RowFilter.regexFilter(textField.getText()));
    }
}
