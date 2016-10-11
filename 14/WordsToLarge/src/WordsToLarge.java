import java.applet.Applet;  
import java.awt.Color;  
import java.awt.Font;  
import java.awt.FontMetrics;  
import java.awt.Graphics;  
import java.awt.Image;  
  
public class WordsToLarge extends Applet implements Runnable {  
    private Image myImage;// 定义图片对象  
    private Graphics myGraphic;// 定义Graphics对象  
    private Font font;// 定义Font对象  
    private String myString;// 定义一个字符串对象  
    private Thread mythread;// 定义一个Thread对象  
    private int fontSize;// 定义一个int型变量  
    public void init() {// Applet小程序初始化  
        this.setSize(350,300);  
        myImage = createImage(350,300); // /创建Image图像对像  
        myGraphic = myImage.getGraphics();  
        myString = "JavaApplet小应用程序";// 需要变化的文本内容  
        font = new Font("华文行楷", Font.BOLD, 8);  
    }  
    public void start() {// 启动多线程  
        if (mythread == null) {  
            mythread = new Thread(this);  
            mythread.start();// 启动线程  
        }  
    }  
    public void update(Graphics g) {// 重新调用paint方法  
        paint(g);  
    }  
    public void paint(Graphics g) {// 绘图像  
        myGraphic.setColor(Color.white);  
        myGraphic.fillRect(0, 0, getSize().width, getSize().height);  
        font = new Font("华文行楷", Font.BOLD, fontSize);  
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
    public void run() {// 重写Thread类的run方法  
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
