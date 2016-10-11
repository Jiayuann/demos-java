import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
public class AgitatedWater extends Applet implements Runnable {
    Thread thread = null;                    // �����߳�
    private Graphics g, inv_g;                // �����������ͼ��͵�����ͼ���Graphics����
    private Image image, invimage;            // image������������ͼ��invimage�������뵹����ͼ��
    private int inv;                        // Ӧ�����γɵ���Ӱ��ı���
    private int image_W = 2, image_H = 2;    // ����װ��ͼƬ��͸ߵı���
    private boolean load_Flag = false;        // �����־���������Ǳ�־����ͼƬ�Ƿ����
    private final int fre = 14;                // ����ˮ�Ʋ�����Ƶ�ʣ���ֵԽ�󣬲���Խ����
    private String picture_name = "";        // ����ͼƬ����
    public void init() {                    // ��ʼ��applet
        picture_name = "����Ů��.jpg";
    }
    public void paint(Graphics g) {
        if (!load_Flag)                    // ����Ѿ�����ͼƬ���򷵻�
            return;
        if (invimage != null) {                // �����ӰͼƬ
            g.drawImage(invimage, (-inv * image_W), image_H, this);
            g.drawImage(invimage, ((fre - inv) * image_W), image_H, this);
        }
        g.drawImage(image, 0, -1, this);    // �������ͼƬ
    }
    public void start() {                    // ����applet�������������߳�
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
    public void run() {// �����߳�
// ����ͼƬ
inv = 0;
g = getGraphics();
MediaTracker imageTracker = new MediaTracker(this);
image = getImage(this.getCodeBase(), picture_name);
imageTracker.addImage(image, 0);
try {
            imageTracker.waitForAll();
            load_Flag = !imageTracker.isErrorAny();    // ���ý����������ٵ�����ͼ��Ĵ���״̬
        } catch (InterruptedException e) {
        }
                                            // ͼƬ��ȡ�ͼƬ�߶�
        image_W = image.getWidth(this);
        image_H = image.getHeight(this);
        this.setSize(image_W+1, image_H * 2 - 19);
        creatWater();                            // ���ɵ�Ӱ
        repaint();                                // �������applet
        while (true) {
            try {
                if (!load_Flag)
                    return;
                if (invimage != null) {
                    g.drawImage(invimage, (-inv * image_W), image_H, this);
                    g.drawImage(invimage, ((fre - inv) * image_W), image_H,
                            this);
                }
                g.drawImage(image, 0, -1, this);
                if (++inv == fre)
                    inv = 0;
                Thread.sleep(50);
            } catch (InterruptedException e) {
                stop();
            }
        }
    }
    public void creatWater() {                        //����ˮ����Ч
        Image back = createImage(image_W+3, image_H + 2);
        Graphics graphics = back.getGraphics();
        int phase = 0;
        int x, y;
        double p1;
        graphics.drawImage(image, 0, 1, this);
        for (int i = 0; i < (image_H >> 1); i++) {
            graphics.copyArea(0, i, image_W, 1, 0, image_H - i);
            graphics.copyArea(0, image_H - 1 - i, image_W, 1, 0, -image_H + 1
                    + (i << 1));
            graphics.copyArea(0, image_H, image_W, 1, 0, -1 - i);
        }
        invimage = createImage((fre + 1) * image_W+20, image_H+2);
        inv_g = invimage.getGraphics();
        inv_g.drawImage(back, fre * image_W, 0, this);
        for (phase = 0; phase < fre; phase++) {
            p1 = 2 * Math.PI * (double) phase / (double) fre;
            x = (fre - phase) * image_W;
            for (int i = 0; i < image_H; i++) {
                y = (int) ((image_H / 14)
                        * ((double) i + 28.0)
                        * Math.sin((double) ((image_H / 14) * (image_H - i))
                                / (double) (i + 1) + p1) / (double) image_H);
                if (i < -y)
                    inv_g.copyArea(fre * image_W, i, image_W, 1, -x, 0);
                else
                    inv_g.copyArea(fre * image_W, i + y, image_W, 1, -x,
                            -y);
            }
        }
graphics.drawImage(image, 0, 1, this);
image = back;
    }
}