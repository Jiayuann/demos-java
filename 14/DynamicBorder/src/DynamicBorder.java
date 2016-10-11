import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

public class DynamicBorder extends Applet implements Runnable
// ��applet��֧���̣߳���Ҫʵ��Runnable�ӿ�
{
    private Image bimg, fimg, offI, virtualI;			// ����Imageͼ�����
    private Graphics offG, virtualG;// ����Graphics����
    private Thread thread = null;// ����Thread���̶߳���
    private MediaTracker imageTracker;// ����MediaTracker����
    private int height, width, X, Y;// ����int�ͱ���
    public void init() {
        // ��ʼ��applet,���ر���ͼƬ��ǰ��ͼƬ
        this.setSize(400, 400);
        String imageName = "��è.jpg";
        String imageName2 = "�߿�.gif";
        bimg = getImage(getDocumentBase(), imageName);// ��ȡ����ͼƬ
        fimg = getImage(getDocumentBase(), imageName2);// ��ȡǰ��ͼƬ
        imageTracker = new MediaTracker(this); // ����һ��ý���������ʵ��
        // ��ͼƬ���뵽 MedialTracker �ļ��Ӷ�����ȥ�� image ΪҪ�����ӵ�ͼ�����
        // 0 Ϊ����ͼ���ڼ��Ӷ����еı�ʶ��
        imageTracker.addImage(bimg, 0);
        imageTracker.addImage(fimg, 0);
        width = this.getSize().width; // ����applet���
        height = this.getSize().height; // ����applet�߶�
        try {
            imageTracker.waitForID(0); // ����ͼƬ
        } catch (InterruptedException e) {
        }
        offI = createImage(width, height);
        offG = offI.getGraphics();
        virtualI = createImage(width * 2, height * 2);
        virtualG = virtualI.getGraphics();
    }
    public void start() {
        // ����applet,����������һ���߳�
        if (thread == null) {
            thread = new Thread(this); // ��applet��ʼ���߳�
            thread.start(); // �����̣߳�����run()����
        }
    }
    public void run() {
        // �̵߳��ÿ�ʼ
        int x = 0, y = 0;
        int tileWidth = bimg.getWidth(this); // �������ƿ��
        int tileHeight = bimg.getHeight(this); // �������Ƹ߶�
        while (thread != null) {
            try {
                Thread.sleep(10);
                x = virtualI.getWidth(this) - width;
                y = virtualI.getHeight(this) - height;
                // �ڲ�ͬ������λ�����ͼ���Բ���ȼ��Ч��
                for (; (x > 0) && (y > 0); x--, y--) {
                    if ((x == 0) || (y == 0)) {
                        x = virtualI.getWidth(this) - width;
                        y = virtualI.getHeight(this) - height;
                    }
                    // ���ͼ�񣬲���ȼ����Ч
                    for (int j = 0; j < virtualI.getHeight(this); j = j
                            + tileHeight)
                        for (int i = 0; i < virtualI.getWidth(this); i = i
                                + tileWidth)
                            virtualG.drawImage(bimg, i, j, this);
                    virtualG.drawImage(fimg, x, y, width, height, this);
                    offG.drawImage(virtualI, -x, -y, this);
                    // ���applet������update()����
                    repaint();
                }
            } catch (InterruptedException e) {
            }
        }
    }
    public void update(Graphics g) {
        // ����paint()����
        paint(g);
    }
    public void paint(Graphics g) {
        // ���applet
        g.drawImage(offI, 0, 0, this);
    }
}