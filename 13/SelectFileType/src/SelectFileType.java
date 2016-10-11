import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
public class SelectFileType extends JFrame {
    private JPanel contentPane;
    private BackgroundPanel backgroundPanel;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	SelectFileType frame = new SelectFileType();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public SelectFileType() {
        setTitle("��ָ�����͵��ļ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);      
        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
                null, null, null));
        contentPane.add(backgroundPanel, BorderLayout.CENTER);    
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);     
        JButton button = new JButton("��ͼƬ");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
    } 
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// �����ļ�ѡ����
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ͼƬ�ļ�",
                "jpg", "gif", "png", "jpeg");// �����ļ����͹�����
        chooser.setFileFilter(filter);// ����ѡ�����Ĺ�����
        int option = chooser.showOpenDialog(this);// ��ʾ�򿪶Ի���
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();// ��ȡ�û�ѡ���ļ�
            try {
                // ����ͼƬ�ļ�
                ImageIcon image = new ImageIcon(file.toURI().toURL());
                backgroundPanel.setImage(image.getImage());// ��ʾͼƬ�ļ�
                backgroundPanel.repaint();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
