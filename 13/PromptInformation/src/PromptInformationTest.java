import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
public class PromptInformationTest extends JFrame {
    private JPanel contentPane;
    private JScrollPane scrollPane;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PromptInformationTest frame = new PromptInformationTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public PromptInformationTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u5E26\u6709\u63D0\u793A\u4FE1\u606F\u7684\u5217\u8868");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);   
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[][] data = new String[4][2];
        data[0][0] = "���������塷";
        data[0][1] = "��ĩ������޹��������й���һ����ƪ�»�����ʷС˵";
        data[1][0] = "��ˮ䰴���";
        data[1][1] = "����Ҷ��ʩ���������й���ƪ������ѧ����֮һ";
        data[2][0] = "�����μǡ�";
        data[2][1] = "����Ҷ����ж������й�������ħС˵֮һ";
        data[3][0] = "����¥�Ρ�";
        data[3][1] = "�����ڣ���ѩ�ۡ����������ŵ�С˵��������߳ɾ�";
        JList list = new PromptInformation(data);
        list.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
    }
}
