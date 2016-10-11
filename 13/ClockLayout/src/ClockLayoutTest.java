import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class ClockLayoutTest extends JFrame {
    private static final long serialVersionUID = 3479036492186972580L;
    private JPanel contentPane;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ClockLayoutTest frame = new ClockLayoutTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public ClockLayoutTest() {
        setTitle("建立时钟布局");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLayout(new ClockLayout());
        for (int i = 0; i < 12; i++) {
            if (i < 10) {
                add(new JButton(""+i));
            } else {
                add(new JButton("" + i));
            }
        }
    }
    
}
