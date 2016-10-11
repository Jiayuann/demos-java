import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameSize extends JFrame {
    private static final long serialVersionUID = -2085588912441845548L;
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	JFrameSize frame = new JFrameSize();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrameSize() {
        setTitle("设置窗体大小");// 设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 默认关闭方式
        setSize(250, 250);// 设置窗体大小
        contentPane = new JPanel();// 创建内容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// 设置内容面板
        JLabel label = new JLabel("宽度：250，高度：250");// 创建标签控件
        contentPane.add(label, BorderLayout.CENTER);// 添加标签控件到窗体
    }
    
}
