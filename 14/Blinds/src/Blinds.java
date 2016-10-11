import java.awt.*;
import java.applet.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.image.*;
public class Blinds extends Applet implements Runnable {
	private Image IMG[], image;// ����Image����ͱ���
	private MediaTracker tracker;// ����MediaTracker����
	private int width, height, image_count = 8, image2, image3;// ����int���͵ı���
	private Thread thread;// ����Thread����
	private int delay = 3000;// ����int��������ʼֵΪ3000
	private int p, p_1[], p_2[], p_3[], p_4[], p_5[], p_6[], p_7[], p_8[],
			p_A[], p_B[];// ����int�����飬���ڽ�������ͼ�������
	public void init() {
		this.setBackground(Color.white);// ���ñ�����ɫΪ��ɫ
		this.setSize(320, 250);// ���ñ߿�Ŀ�͸�
		IMG = new Image[image_count];// �������鳤��Ϊimage_count��Image����
		tracker = new MediaTracker(this);// ����MediaTracker����
		String s = "";
		for (int i = 0; i < image_count; i++) {
			s = (i + 1) + ".jpg";
			URL url;
			try {
				url = new URL("file:" + s);// ����URL����
				IMG[i] = getImage(url);// ����Image����
				tracker.addImage(IMG[i], 0);// ��Image������ӵ�tracker�е�ָ��λ����
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		try {
			tracker.waitForID(0);// �ȴ�����IDΪ0������ͼ��
		} catch (InterruptedException e) {
		}
		width = IMG[0].getWidth(this);// �õ���ͼƬ�Ŀ�
		height = IMG[0].getHeight(this);// �õ���ͼƬ�ĸ�
		p = width * height;// ��͸ߵĳ˻�
		p_1 = new int[p];// ��������Ϊp��int����
		PixelGrabber PG1 = new PixelGrabber(IMG[0], 0, 0, width, height, p_1,
				0, width);// ����һ�� PixelGrabber �����Ա��ָ����ͼ���н����ؾ��β��� (x, y, w,
							// h) ץȡ�������������С�
		try {
			PG1.grabPixels();// ����Image��ʼ�������أ����ȴ���������ؾ����е��������أ����ߵȴ�����ʱ���ѹ���
		} catch (InterruptedException ex) {
		}
		p_2 = new int[p];
		PixelGrabber PG2 = new PixelGrabber(IMG[1], 0, 0, width, height, p_2,
				0, width);
		try {
			PG2.grabPixels();
		} catch (InterruptedException ex) {
		}
		p_3 = new int[p];
		PixelGrabber PG3 = new PixelGrabber(IMG[2], 0, 0, width, height, p_3,
				0, width);
		try {
			PG3.grabPixels();
		} catch (InterruptedException ex) {
		}
		p_4 = new int[p];
		PixelGrabber PG4 = new PixelGrabber(IMG[3], 0, 0, width, height, p_4,
				0, width);
		try {
			PG4.grabPixels();
		} catch (InterruptedException ex) {
		}
		p_5 = new int[p];
		PixelGrabber PG5 = new PixelGrabber(IMG[4], 0, 0, width, height, p_5,
				0, width);
		try {
			PG5.grabPixels();
		} catch (Exception ex) {
		}
		p_6 = new int[p];
		PixelGrabber PG6 = new PixelGrabber(IMG[5], 0, 0, width, height, p_6,
				0, width);
		try {
			PG6.grabPixels();
		} catch (InterruptedException ex) {
		}
		p_7 = new int[p];
		PixelGrabber PG7 = new PixelGrabber(IMG[6], 0, 0, width, height, p_7,
				0, width);
		try {
			PG7.grabPixels();
		} catch (InterruptedException ex) {
		}
		p_8 = new int[p];
		PixelGrabber PG8 = new PixelGrabber(IMG[7], 0, 0, width, height, p_8,
				0, width);
		try {
			PG8.grabPixels();
		} catch (Exception ex) {
		}
		image2 = 0;
		p_A = new int[p];
		p_B = new int[p];
		image = IMG[0];

		thread = new Thread(this);// �����߳�
		thread.start();// �����߳�
	}
	public void paint(Graphics g)// �������
	{
		g.drawImage(image, 0, 0, this);
	}
	public void update(Graphics g)// �������
	{
		paint(g);
	}
	public void run()// �����߳�
	{
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		while (true)// ����ͼƬ��ͼƬ֮��Ĺ���
		{
			try {
				thread.sleep(delay);// �߳�����delay����
				image3 = ((image2 + 1) % image_count);// ָ��ǰͼƬ����һ��ͼƬ
				if (image2 == 0) {
					System.arraycopy(p_1, 0, p_A, 0, p);// ���±�Ϊ0��p_1����
													// �и���һ�����飬��ŵ�p_A�������±�Ϊ0��λ���У������鳤��Ϊp
					System.arraycopy(p_2, 0, p_B, 0, p);// ͬ��
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));// ����ָ����ͼ������������һ��ͼ��
					repaint();
				}
				if (image2 == 1) {
					System.arraycopy(p_2, 0, p_A, 0, p);
					System.arraycopy(p_3, 0, p_B, 0, p);
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));
					repaint();
				}
				if (image2 == 2) {
					System.arraycopy(p_3, 0, p_A, 0, p);
					System.arraycopy(p_4, 0, p_B, 0, p);
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));
					repaint();
				}
				if (image2 == 3) {
					System.arraycopy(p_4, 0, p_A, 0, p);
					System.arraycopy(p_5, 0, p_B, 0, p);
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));
					repaint();
				}
				if (image2 == 4) {
					System.arraycopy(p_5, 0, p_A, 0, p);
					System.arraycopy(p_6, 0, p_B, 0, p);
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));
					repaint();
				}
				if (image2 == 5) {
					System.arraycopy(p_6, 0, p_A, 0, p);
					System.arraycopy(p_7, 0, p_B, 0, p);
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));
					repaint();
				}
				if (image2 == 6) {
					System.arraycopy(p_7, 0, p_A, 0, p);
					System.arraycopy(p_8, 0, p_B, 0, p);
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));
					repaint();
				}
				if (image2 == 7) {
					System.arraycopy(p_8, 0, p_A, 0, p);
					System.arraycopy(p_1, 0, p_B, 0, p);
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));
					repaint();
				}

				while (true)// ����Ҷ��
				{
					for (int i = 0; i < (int) (height / 13); i++) {
						try {
							thread.sleep(50);// �߳�����30����
							for (int j = 0; j < height; j += (int) (height / 13)) {
								for (int k = 0; k < width; k++) {
									p_A[width * (j + i) + k] = p_B[width
											* (j + i) + k];// ���������ĸ���

								}
							}
						} catch (InterruptedException e) {
						}
						image = createImage(new MemoryImageSource(width,
								height, p_A, 0, width));
						repaint();

					}
					break;
				}

				image2 = image3;
				repaint();
			} catch (InterruptedException e) {

			}
		}
	}
}
