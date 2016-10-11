import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
public class WordsExpansion extends Applet implements Runnable {
    private Image myImage;//����Imageͼ�����
    private Graphics myGraphic;//����Graphics����
    private int width = 0, height = 0;//�����ߺͿ����
    private String words;//�����ı�����
    private Thread mythread;//����Thread���̶߳���
    private int xPosition = 0, yPosition = 0, myHeight;//����x��y�����
    private int times = 0;//��ʾ�������ֵķ���
    private Font font;
    public void init()//��ʼ��AppletС����
    {
        this.setSize(300, 200);
        font = new Font("�����п�", Font.BOLD, 30);
        width = 300;
        height = 200;
        myHeight = height / 3;
        yPosition = myHeight;
        words = "��ӭ����Java���磡";
        myImage = createImage(width, height);
        myGraphic = myImage.getGraphics();
    }
    public void start()//��AppletС����Ͷ��߳�
    {
        if (mythread == null) {
            mythread = new Thread(this);
            mythread.start();
        }
    }
    public void update(Graphics g)//�������
    {
        paint(g);
    }
    public void paint(Graphics g)//�������
    {
        g.drawImage(myImage, 0, yPosition, width, myHeight, this);
    }
    public void run()//���ж��߳�
    {
        try {
            while (true) {
                yPosition = 0;
                myHeight = height;
                myGraphic.setColor(Color.pink);
                myGraphic.fillRect(0, 0, width, height);
                repaint();
                mythread.sleep(100);
                if (times == 0) {
                    myGraphic.setColor(Color.yellow);
                    for (int i = width; i >= 0; i--) {
                        myGraphic.fillRect(i, height / 3, width, height / 10);
                        repaint();
                        mythread.sleep(10);
                    }
                } else if (times == 1) {
                    myGraphic.setColor(Color.green);
                    for (int i = 0; i <= width; i++) {
                        myGraphic.fillRect(0, height / 3, i, height / 10);
                        repaint();
                        mythread.sleep(10);
                    }
                }
                yPosition = height / 3;
                myHeight = height / 3;
                for (int i = height / 3; i >= 0; i--) {
                    xPosition = 0;
                    yPosition--;
                    myHeight = myHeight + 2;
                    if (times == 0)//0��ʾ���������ƶ�
                    {
                        myGraphic.setColor(Color.green);
                        myGraphic.fillRect(0, 0, width, height);
                        myGraphic.setFont(font);
                        myGraphic.setColor(Color.yellow);
                        myGraphic.drawString(words, 10, 35);
                        times++;
                    } else if (times == 1)//1��ʾ���������ƶ�
                    {
                        myGraphic.setColor(Color.red);
                        myGraphic.fillRect(0, 0, width, height);
                        myGraphic.setFont(font);
                        myGraphic.setColor(Color.green);
                        myGraphic.drawString(words, 10, 35);
                        times = 0;
                    }
                    repaint();
                    mythread.sleep(100);
                }
                mythread.sleep(2500);
                System.out.println(times);
            }
        } catch (InterruptedException e) {
        }
    }
}