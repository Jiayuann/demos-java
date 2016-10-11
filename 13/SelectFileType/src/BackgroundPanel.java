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
    protected void paintComponent(Graphics g) {// 重写绘制组件外观
        int width = getWidth();// 获取组件大小
        int height = getHeight();
        if (image != null) {
            g.drawImage(image, 0, 0, width, height, this);// 绘制图片与组件大小相同
        }else{
            String str="没有图片预览";
            int strWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), str);
            g.drawString(str, (width-strWidth)/2, height/2);
        }
        super.paintComponent(g);// 执行超类方法
    }
}
