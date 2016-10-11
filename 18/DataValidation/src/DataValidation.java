import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DataValidation extends JFrame {
    
    private JPanel contentPane;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextField deptTextField;
    private JComboBox sexComboBox;
    private JDBCConn util = new JDBCConn();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	DataValidation frame = new DataValidation();
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
    public DataValidation() {
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(100, 100, 406, 360);
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);
         setTitle("��ѧ����Ϣ��ӵ����ݿ���");
         JPanel panel = new JPanel();
         panel.setBounds(0, 0, 390, 322);
         contentPane.add(panel);
         panel.setLayout(null);
         
         JLabel idLabel = new JLabel("ѧ�ţ�");
         idLabel.setBounds(63, 56, 45, 15);
         panel.add(idLabel);
         
         idTextField = new JTextField();
         idTextField.setBounds(118, 53, 194, 21);
         panel.add(idTextField);
         idTextField.setColumns(10);
         
         JLabel nameLabel = new JLabel("������");
         nameLabel.setBounds(63, 24, 45, 15);
         panel.add(nameLabel);
         
         nameTextField = new JTextField();
         nameTextField.setBounds(118, 21, 194, 21);
         panel.add(nameTextField);
         nameTextField.setColumns(10);
         
         JLabel sexLabel = new JLabel("�Ա�");
         sexLabel.setBounds(63, 87, 45, 15);
         panel.add(sexLabel);
         
         ageTextField = new JTextField();
         ageTextField.setBounds(118, 118, 194, 21);
         panel.add(ageTextField);
         ageTextField.setColumns(10);
         
         String[] sex = new String[] { "��", "Ů" };
         sexComboBox = new JComboBox(sex);
         sexComboBox.setBounds(118, 84, 55, 21);
         panel.add(sexComboBox);
         
         JLabel ageLabel = new JLabel("���䣺");
         ageLabel.setBounds(63, 118, 45, 15);
         panel.add(ageLabel);
         
         JLabel deptLabel = new JLabel("Ժϵ��");
         deptLabel.setBounds(63, 150, 54, 15);
         panel.add(deptLabel);
         
         deptTextField = new JTextField();
         deptTextField.setBounds(118, 147, 194, 21);
         panel.add(deptTextField);
         deptTextField.setColumns(10);
         
         JButton insertButton = new JButton("���");
         insertButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
                 do_insertButton_actionPerformed(arg0);
             }
         });
         insertButton.setBounds(107, 275, 66, 23);
         panel.add(insertButton);
         
         JButton closeButton = new JButton("�ر�");
         closeButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
            	 do_closeButton_actionPerformed(arg0);
             }
         });
         closeButton.setBounds(205, 275, 66, 23);
         panel.add(closeButton);
         
         JLabel messageLabel = new JLabel("*");
         messageLabel.setBounds(322, 24, 54, 15);
         panel.add(messageLabel);
         
         JLabel label_1 = new JLabel("*");
         label_1.setBounds(322, 118, 54, 15);
         panel.add(label_1);
         
         JButton validateButton = new JButton("��֤");
         validateButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
                 do_validateButton_actionPerformed(arg0);
             }
         });
         validateButton.setBounds(342, 20, 66, 23);
         panel.add(validateButton);
         
     }
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        int n = JOptionPane.showConfirmDialog(getContentPane(), "ȷ��ɾ����",
                "ȷ�϶Ի���", JOptionPane.YES_NO_CANCEL_OPTION);
        if (n == JOptionPane.YES_OPTION) { // ����û�ȷ����Ϣ
            System.exit(0);
        }
    }
    
    // ��Ӱ�ť�ĵ����¼�
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        
        student emp = new student();
        
        emp.setName(nameTextField.getText());
        emp.setSex(sexComboBox.getSelectedItem().toString());
        emp.setAge(Integer.parseInt(ageTextField.getText()));
        emp.setDept(deptTextField.getText());
        if (!(nameTextField.getText().equals(""))
                && (!deptTextField.getText().equals(""))
               ) {
            util.insertEmp(emp);
            
            JOptionPane.showMessageDialog(getContentPane(), "������ӳɹ���", "��Ϣ��ʾ��",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "�뽫��Ϣ���������",
                    "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    //��֤��ť�ĵ����¼�
    protected void do_validateButton_actionPerformed(ActionEvent arg0) {
        String name = nameTextField.getText();
        int id = util.selectEmpUseName(name);
        if (id > 0) {
            JOptionPane.showMessageDialog(getContentPane(), "��ѧ���Ѵ��ڣ�", "��Ϣ��ʾ��",
                    JOptionPane.WARNING_MESSAGE);
            nameTextField.setText("");
        }
        else{
            JOptionPane.showMessageDialog(getContentPane(), "��ѧ�������ڣ�", "��Ϣ��ʾ��",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
