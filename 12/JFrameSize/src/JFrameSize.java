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
        setTitle("���ô����С");// ���ô������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Ĭ�Ϲرշ�ʽ
        setSize(250, 250);// ���ô����С
        contentPane = new JPanel();// �����������
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// �����������
        JLabel label = new JLabel("��ȣ�250���߶ȣ�250");// ������ǩ�ؼ�
        contentPane.add(label, BorderLayout.CENTER);// ��ӱ�ǩ�ؼ�������
    }
    
}
