import java.applet.Applet;  
import java.awt.Color;  
import java.awt.Font;  
import java.awt.FontMetrics;  
import java.awt.Graphics;  
import java.awt.Image;  
  
public class WordsToLarge extends Applet implements Runnable {  
    private Image myImage;// ����ͼƬ����  
    private Graphics myGraphic;// ����Graphics����  
    private Font font;// ����Font����  
    private String myString;// ����һ���ַ�������  
    private Thread mythread;// ����һ��Thread����  
    private int fontSize;// ����һ��int�ͱ���  
    public void init() {// AppletС�����ʼ��  
        this.setSize(350,300);  
        myImage = createImage(350,300); // /����Imageͼ�����  
        myGraphic = myImage.getGraphics();  
        myString = "JavaAppletСӦ�ó���";// ��Ҫ�仯���ı�����  
        font = new Font("�����п�", Font.BOLD, 8);  
    }  
    public void start() {// �������߳�  
        if (mythread == null) {  
            mythread = new Thread(this);  
            mythread.start();// �����߳�  
        }  
    }  
    public void update(Graphics g) {// ���µ���paint����  
        paint(g);  
    }  
    public void paint(Graphics g) {// ��ͼ��  
        myGraphic.setColor(Color.white);  
        myGraphic.fillRect(0, 0, getSize().width, getSize().height);  
        font = new Font("�����п�", Font.BOLD, fontSize);  
        myGraphic.setFont(font);  
        myGraphic.setColor(Color.blue);  
        FontMetrics fm = myGraphic.getFontMetrics(font);  
        int fontHeight = fm.getHeight();  
        int w;  
        int baseLine = getSize().height / 2 + fontHeight / 2;  
        w = fm.stringWidth(myString);  
        w = (getSize().width - w) / 2;  
        myGraphic.drawString(myString, w, baseLine -= 20);  
        g.drawImage(myImage, 0, 0, this);  
        fontSize++;  
    }  
    public void run() {// ��дThread���run����  
        while (true) {  
            repaint();  
            if (fontSize > getSize().height)  
                fontSize = 0;  
            try {  
                mythread.sleep(100);  
           } catch (InterruptedException e) {  
            }  
        }  
    }  
}  
