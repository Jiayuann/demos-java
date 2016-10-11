import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.MediaTracker;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StrongButton extends Applet implements MouseListener {
    private Graphics grap; // ����Graphics����
    private MediaTracker media; // ����MediaTracker����
    private AudioClip audioA, audioB; // ����AudioClip����
    private int width, height; // ����int�����
    private Image image, img1, img2, img3; // ����Image���ͱ���
    private Label la = new Label("�๦�ܰ���"); // ����һ������ʼֵ��Label����
    public void init() { // ΪApplet��ʼ��
        audioA = getAudioClip(this.getDocumentBase(), "aa.wav"); // ����audioA����
        audioB = getAudioClip(getDocumentBase(), "hh.wav"); // //����audioB����
        width = getSize().width; // ����Applet�Ŀ��
        height = getSize().height; // ����Applet�ĸ߶�
        image = createImage(width, height); // ���ݲ�������һ��Image����
        grap = image.getGraphics(); // ����ͼ�񴴽�Graphics����
        media = new MediaTracker(this); // MediaTracker����ʵ����
        img1 = getImage(getDocumentBase(), "2.jpg"); // ���ݲ�������Image����
        media.addImage(img1, 0); // ��img1����media������
        img2 = getImage(getDocumentBase(), "3.jpg");
        media.addImage(img2, 1);
        img3 = getImage(getDocumentBase(), "4.jpg");
        media.addImage(img3, 2);
        try {
            media.waitForAll(); // �ȴ�media�������е�ͼ��
        } catch (InterruptedException e) {
        }
        la.setSize(100, 20);
        la.setForeground(Color.blue); // ���ñ�ǩ��ǰ����ɫ
        this.add(la, BorderLayout.NORTH); // ����ǩ������ص�Applet��
        addMouseListener(this); // ΪApplet�����������¼�
    }
    public void start() { // ��ʼApplet����
        grap.drawImage(img1, 0, 0, width + 5, height, this); // ���ݸ����Ĳ�������ͼ��
        repaint();
    }
    public void mouseClicked(MouseEvent e) { // ��굥���¼�
    }
    public void mousePressed(MouseEvent e) { // ��갴���¼�
        grap.drawImage(img3, 0, 0, width + 5, height, this); // ����걻����ʱ�����Ƶ�ͼ��
        audioA.stop(); // audioAֹͣ��������
        audioB.play(); // audioB��ʼ��������
        la.setBackground(Color.black); // ���ñ�ǩ�ı�����ɫ
        la.setForeground(Color.red); // ���ñ�ǩ��ǰ����ɫ
        la.setText("audioB is playing"); // ���ñ�ǩ��Ҫ��ʾ������
        this.add(la, BorderLayout.NORTH); // ��ӱ�ǩ���
        repaint(); // ���»������
    }
    public void mouseReleased(MouseEvent e) { // ����ͷ��¼�
        grap.drawImage(img2, 0, 0, width + 5, height, this);
        repaint();
        audioB.stop();
        audioA.play();
        la.setBackground(Color.red);
        la.setForeground(Color.black);
        la.setText("audioA is playing");
        this.add(la, BorderLayout.NORTH);
    }
    public void mouseEntered(MouseEvent e) { // ������Applet���������¼�
        grap.drawImage(img2, 0, 0, width, height, this);
        repaint();
    }
    public void mouseExited(MouseEvent e) { // ����뿪Applet���������¼�
        grap.drawImage(img1, 0, 0, width, height, this);
        repaint();
    }
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, width, height, this);
    }
}