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
        setTitle("ʵ�ִ�������ͼƬ�Ĵ���");// ���ô������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);// ���ô���λ��
        contentPane = new JPanel();// �����������
        setContentPane(contentPane);// ���ô����������
        contentPane.setLayout(new BorderLayout(0, 0));
        BackgroundPanel backgroundPanel = new BackgroundPanel();// �����������
        backgroundPanel.setImage(getToolkit().getImage(
                getClass().getResource("��è.jpg")));// ������屳��ͼƬ
        contentPane.add(backgroundPanel);// �ѱ��������ӵ������������
    }
}
