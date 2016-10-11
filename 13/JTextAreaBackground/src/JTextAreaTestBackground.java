import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
public class JTextAreaTestBackground extends JFrame {
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JTextAreaTestBackground frame = new JTextAreaTestBackground();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public JTextAreaTestBackground() {
        setTitle("¾ßÓÐ±³¾°Í¼Æ¬µÄÎÄ±¾Çø");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);  
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JTextArea textArea = new JTextAreaBackground("±³¾°.jpg");
        textArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        scrollPane.setViewportView(textArea);
    }
    
}
