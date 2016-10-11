import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class LightScan extends Applet implements Runnable {
    private String myText;// �����ı�����
    private Font font;// �����������
    private int fontSize;// ��������Ĵ�С
    private Thread mythread;// �����̶߳���
    private int spotPosition = 100;// ����������ֵ�λ��
    private int myTextSize = 40;// �ı��Ĵ�С
    private int myTextWidth = 10;// �ı��Ŀ��
    private int fontHeight, baseLine, w;
    public void init()// С�̳�ĳ�ʼ��
    {
        myText = "���������һ��";// ��С��������Ҫ��ʾ���ı�����
        fontSize = 30;// ��������Ĵ�С
        font = new Font("��������", Font.BOLD, fontSize); // ����Font����
        FontMetrics fm = getFontMetrics(font);// ��ȡFontMetrics���������
        fontHeight = fm.getHeight();
        baseLine = getSize().height / 2 + fontHeight / 3;
        myTextWidth = fm.stringWidth(myText);
        w = fm.stringWidth(myText);
        w = (getSize().width - w) / 2;
        spotPosition = w;
        setBackground(Color.white); // ����С����ı���ɫΪ��ɫ
    }
    public void start() {
        if (mythread == null) {
            mythread = new Thread(this);// �������߳�
            mythread.start();// �������߳�
        }
    }
    public void stop() {
        mythread.stop();// ֹͣ�����߳�
        mythread = null;
    }
    public void run()// �����߳�
    {
        while (true) {
            repaint();// �ػ�����
            try {
                mythread.sleep(30);
            }// �߳�����
            catch (InterruptedException e) {
            }
        }
    }
    public void update(Graphics g)// �������
    {
        paint(g);
    }
    // ����clipRect()������ÿ�ε�����ʾ����paint()ʱ��
    // ���ú�ɫ�ıʻ�һ�����֣����ð�ɫ�ڲü����л�һ������
    public void paint(Graphics g) {
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString(myText, w, baseLine); // ��һ����ʾ
        g.clipRect(spotPosition, 0, myTextSize, getSize().height); // ���òü�����
        g.setColor(Color.yellow);
        g.drawString(myText, w, baseLine); // �ڶ�����ʾ
        spotPosition = (spotPosition + 1) % (myTextWidth + 100); // �ƶ����λ��
    }
}