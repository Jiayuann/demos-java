import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.image.PixelGrabber;
import java.util.Random;

public class PictureFloat extends Applet {
    private Image image;// ����ͼƬ����
    private int x = 25, y = 25;// ����int�ͱ��� �ֱ��ʾx��y������ֵ
    private Random random;// �����������Random����
    private int width, height, w, h, image_size, pixels[];// ����int�ͱ���������
    public void init() { // ��ʼ��applet
        this.setSize(400, 400);
        random = new Random();
        // ����ҳ��ȡͼƬ�ļ�������
        String imageName = "ty.jpg";
        // ����ͼƬ
        image = getImage(getDocumentBase(), imageName);
        MediaTracker imageTracker = new MediaTracker(this);
        imageTracker.addImage(image, 0);
        try {
            imageTracker.waitForID(0);
        } catch (InterruptedException e) {
        }
    }
    public void start() {
        // ����applet,Ȼ�����paint()����
        width = getSize().width; // applet���
        height = getSize().height; // applet�߶�
        w = image.getWidth(this); // ͼƬ���
        h = image.getHeight(this); // ͼƬ�߶�
        // ͼƬ���λ��
        x = (width - w) / 2;
        y = (height - h) / 2;
        // ͼƬ��С
        image_size = w * h;
        // ����ͼƬ����������
        pixels = new int[image_size];
        // ����һ�����ػ�ȡ����ʵ�����������������������
        PixelGrabber pg = new PixelGrabber(image, 0, 0, w, h, pixels, 0, w);
        try {
            // ����ͼƬ��������Ϣ
            pg.grabPixels();
        } catch (InterruptedException e) {
        }
    }
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getSize().width, getSize().height);
        // ����drawImage()����������Ӧ��λ�����ͼƬ
        drawImage(g, image, x, y);
    }
    private void drawImage(Graphics g, Image image, int x, int y) {
        // ���ͼƬ
        while (true) {
            g.setColor(Color.blue);
            g.fillRect(0, 0, getSize().width, getSize().height);
            try {
                int one_time = w; // ͼƬ���
                int S_x = 0, S_y = 0;
                S_x = (int) (random.nextFloat() * width);
                S_y = (int) (random.nextFloat() * height);
                Laser[] nextlot = new Laser[one_time];
                int k = 0, l = 0;
                int step = 1, start = 0;
                float f = random.nextFloat();
                step = (f < 0.8) ? 34759 : (f < 0.9 ? 1 : image_size - 1); // ����
                // start=(int)(random.nextFloat()*image_size); //��ʼλ��
                f = random.nextFloat();
                start = (f < 0.5) ? image_size : 0; // ���fС��0.5,����ʼλ��ΪͼƬ��С������Ϊ0
                int sofar = 0;
                // ��ʼ��nextlot����
                for (k = start; l < image_size; l++, k += step) {
                    Thread.sleep(2);
                    if (k < 0)
                        k += image_size;
                    k %= image_size;
                    int row = k / w;
                    int col = k % w;
                    Color colr = new Color(pixels[k]);
                    int finishx = x + col;
                    int y1 = y + row;
                    nextlot[sofar] = new Laser(colr, new Point(S_x, S_y),
                            new Point(finishx, y1));
                    sofar++;
                    if (sofar == one_time) {
                        Track(g, nextlot);
                        sofar = 0;
                    }
                }
            } catch (Exception e) {
            }
            g.setPaintMode();
            g.drawImage(image, x, y, this);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }
    private synchronized void Track(Graphics g, Laser[] nextlot) {
        Color back = Color.blue;
        g.setXORMode(back);
        for (int pass = 0; pass < 2; pass++) {
            for (int pixnr = 0; pixnr < nextlot.length; pixnr++) {
                Laser p = nextlot[pixnr];
                if (!close(p.c, back)) {
                    g.setColor(p.c);
                    g.drawLine(p.start.x, p.start.y, p.finish.x, p.finish.y);
                }
                if (pass == 1) {
                    g.setColor(p.c);
                    g.drawLine(p.finish.x, p.finish.y, p.finish.x, p.finish.y);
                }
            }
        }
        Thread.yield();
    }
    private boolean close(Color c1, Color c2) {
        return (Math.abs(c1.getRed() - c2.getRed())
                + Math.abs(c1.getGreen() - c2.getGreen()) + Math.abs(c1
                .getBlue()
                - c2.getBlue())) < 0xff;
    }
}
class Laser {
    public Color c;
    public Point start, finish;
    public Laser(Color c, Point start, Point finish) {
        this.c = c;
        this.start = start;
        this.finish = finish;
    }
}