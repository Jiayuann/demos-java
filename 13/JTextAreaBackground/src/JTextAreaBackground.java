import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class JTextAreaBackground extends JTextArea {
    private static final long serialVersionUID = -4157782271632761973L;
    private Image image;
    
    public JTextAreaBackground(String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        image = imageIcon.getImage();
        setOpaque(false);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
        super.paint(g);
    }
}
