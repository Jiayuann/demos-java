import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class PopupMenuImage extends JFrame {

    private static final long serialVersionUID = -5570749657628665431L;
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
                    PopupMenuImage frame = new PopupMenuImage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public PopupMenuImage() {
        setTitle("\u5F39\u51FA\u5F0F\u83DC\u5355\u7684\u5E94\u7528");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        JPopupMenu popupMenu = new JPopupMenu();
        contentPane.setComponentPopupMenu(popupMenu);
        
        JMenuItem cut = new JMenuItem("剪切");
        cut.setIcon(new ImageIcon(PopupMenuImage.class.getResource("剪切.jpg")));
        cut.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        cut.addActionListener(listener);
        popupMenu.add(cut);
        
        JMenuItem find = new JMenuItem("查找");
        find.setIcon(new ImageIcon(PopupMenuImage.class.getResource("查找.jpg")));
        find.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        find.addActionListener(listener);
        popupMenu.add(find);
        
        JMenuItem open = new JMenuItem("打开");
        open.setIcon(new ImageIcon(PopupMenuImage.class.getResource("打开.jpg")));
        open.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        open.addActionListener(listener);
        popupMenu.add(open);
        
        JMenuItem save = new JMenuItem("保存");
        save.setIcon(new ImageIcon(PopupMenuImage.class.getResource("保存.jpg")));
        save.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        save.addActionListener(listener);
        popupMenu.add(save);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        label = new JLabel("单击鼠标右键弹出菜单！");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        contentPane.add(label, BorderLayout.NORTH);
    }
    
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(e.getActionCommand());// 设置标签的文本为用户选择的操作
        }
    };
    private JLabel label;
    
}
