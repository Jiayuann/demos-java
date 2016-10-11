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
        data[0][0] = "《三国演义》";
        data[0][1] = "明末清初，罗贯中著，中国第一部长篇章回体历史小说";
        data[1][0] = "《水浒传》";
        data[1][1] = "明中叶，施耐庵著，中国长篇叙事文学鼻祖之一";
        data[2][0] = "《西游记》";
        data[2][1] = "明中叶，吴承恩著，中国著名神魔小说之一";
        data[3][0] = "《红楼梦》";
        data[3][1] = "清中期，曹雪芹、高鹗著，古典小说艺术的最高成就";
        JList list = new PromptInformation(data);
        list.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
    }
}
