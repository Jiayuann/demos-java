import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
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
    @Override
    protected void paintComponent(Graphics g) {// ��д����������
        if (image != null) {
            g.drawImage(image, 0, 0, this);// ����ͼƬ�������С��ͬ
        }
        super.paintComponent(g);// ִ�г��෽��
    }
}
