import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class BackgroundPanel extends JPanel {
    private Image image;
    public BackgroundPanel() {
        super();
        setOpaque(false);
        setLayout(null);
    }
    public void setImage(Image image) {
        this.image = image;
    }
    protected void paintComponent(Graphics g) {// ��д����������
        int width = getWidth();// ��ȡ�����С
        int height = getHeight();
        if (image != null) {
            g.drawImage(image, 0, 0, width, height, this);// ����ͼƬ�������С��ͬ
        }else{
            String str="û��ͼƬԤ��";
            int strWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), str);
            g.drawString(str, (width-strWidth)/2, height/2);
        }
        super.paintComponent(g);// ִ�г��෽��
    }
}
