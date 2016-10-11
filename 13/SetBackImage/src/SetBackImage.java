import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SetBackImage extends JFrame {
    
    /**
     * 
     */
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	SetBackImage frame = new SetBackImage();
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
    public SetBackImage() {
        setTitle("实现带背景定图片的窗体");// 设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);// 设置窗体位置
        contentPane = new JPanel();// 创建内容面板
        setContentPane(contentPane);// 设置窗体内容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        BackgroundPanel backgroundPanel = new BackgroundPanel();// 创建背景面板
        backgroundPanel.setImage(getToolkit().getImage(
                getClass().getResource("龙猫.jpg")));// 设置面板背景图片
        contentPane.add(backgroundPanel);// 把背景面板添加到窗体内容面板
    }
}
