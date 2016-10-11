import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

//��applet��֧���̣߳���Ҫʵ��Runnable�ӿ�
public class Lightning extends Applet implements Runnable {
	private Thread thread = null; // applet֧�ֵ��߳�

	private int no_Light = 0; // û������ı�־����:0��ʾû�����磬

	private int Light = 1; // ������ı�־����

	private int[] light;// ����int������light

	private int[] array_1;// ����int������array_1

	private int[] array_2;// ����int������array_2

	private Image T_image, image;// ����Image����T_image, image

	private int delay = 3;// �ӳ���ʱ�䱶��

	public void init() {// ��ʼ��applet
		this.setSize(650,450);
		String imageName = "city.gif";
		image = getImage(getCodeBase(), imageName);
		// ����int�����飬�����䳤��ΪgetSize().height
		light = new int[getSize().height];
		array_1 = new int[getSize().height];
		array_2 = new int[getSize().height];
		T_image = this.createImage(getSize().width, getSize().height); // ����ָ���Ĳ�������һ��ͼ��
	}

	public void paint(Graphics g) {
		int i, t;
		if (no_Light == 0) // û������
		{
			g.setColor(Color.black); // �豳��ɫΪ��ɫ
			g.fillRect(0, 0, getSize().width, getSize().height); // ��䱳��ɫ
			g.drawImage(image, 0, 0, this); // ���city.gif
		} else // ������
		{
			switch (Light) {
			case 1:
				g.setColor(new Color(240, 255, 255));
				break; // �豳��ɫΪ��ɫ
			case 2:
				g.setColor(new Color(176, 48, 96));
				break; // �豳��ɫΪ��ɫ
			case 3:
				g.setColor(new Color(250, 255, 240));
				break; // �豳��ɫΪ��ɫ
			case 4:
				g.setColor(new Color(240, 255, 240));
				break; // �豳��ɫΪ��ɫ
			case 5:
				g.setColor(new Color(248, 248, 255));
				break; // �豳��ɫΪ�}ɫ
			default:
				g.setColor(new Color(245, 245, 245));
				break; // �豳��ɫΪ��ɫ
			}
			g.fillRect(0, 0, getSize().width, getSize().height); // ��䱳��ɫ
			t = (int) (0.6F * getSize().height);// �������ͼ��
			for (i = 1; i < getSize().height; i++) {
				if (i < t) { // ���������Χ�Ļ�ɫ����
					g.setColor(Color.white);
					g.drawRect(light[i] - 4, i, 3, 1);
					g.drawRect(light[i] + 1, i, 3, 1);
					g.setColor(Color.orange);
					g.drawRect(light[i] - 1, i, 1, 1);
					g.drawRect(light[i] + 1, i, 1, 1);

				}

				switch (Light) {
				case 1:
					g.setColor(new Color(0, 0, 255));
					break; // ��ɫ����
				case 2:
					g.setColor(new Color(255, 0, 0));
					break; // ��ɫ����
				case 3:
					g.setColor(new Color(255, 215, 0));
					break; // ��ɫ����
				case 4:
					g.setColor(new Color(0, 255, 0));
					break; // ��ɫ����
				case 5:
					g.setColor(new Color(160, 32, 240));
					break; // �}ɫ����
				default:
					g.setColor(new Color(225, 225, 225));
					break; // ��ɫ����
				}
				g.drawLine(light[i], i, light[i - 1], i - 1);
				if (array_1[i] >= 0) { // �����������
					g.drawLine(array_1[i], i, array_1[i - 1], i - 1);
				}
				if (array_2[i] >= 0) { // �����������
					g.drawLine(array_2[i], i, array_2[i - 1], i - 1);
				}
			}
			g.drawImage(image, 0, 0, this);// �������ͼ��city.gif
			Light = (int) ((Math.random() * 10) + 1);
		}
	}

	void drawT_image() {// ����paint()����
		Graphics g;
		g = T_image.getGraphics();
		paint(g);
	}

	public void start() {// ����applet�������������߳�
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {// ֹͣ�����߳�
		if (thread != null) {
			thread.stop();
			thread = null;
		}
	}

	void createLight() {// ���������������������
		int i;
		int bs1, bs2; // ��ʼλ�õ�����
		int be1, be2; // ����λ�õ�����
		light[0] = (int) (Math.random() * getSize().width); // �������������ֵ�λ��
		array_1[0] = light[0];
		array_2[0] = light[0];
		bs1 = (int) (Math.random() * getSize().height) + 1;
		bs2 = (int) (Math.random() * getSize().height) + 1;
		be1 = bs1 + (int) (0.5 * Math.random() * getSize().height) + 1;
		be2 = bs2 + (int) (0.5 * Math.random() * getSize().height) + 1;
		for (i = 1; i < getSize().height; i++) {
			light[i] = light[i - 1] + ((Math.random() > 0.5) ? 1 : -1);
			array_1[i] = light[i];
			array_2[i] = light[i];
		}
		for (i = bs1; i < getSize().height; i++) {
			array_1[i] = array_1[i - 1] + ((Math.random() > 0.5) ? 2 : -2);
		}
		for (i = bs2; i < getSize().height; i++) {
			array_2[i] = array_2[i - 1] + ((Math.random() > 0.5) ? 2 : -2);
		}
		for (i = be1; i < getSize().height; i++) {
			array_1[i] = -1;
		}
		for (i = be2; i < getSize().height; i++) {
			array_2[i] = -1;
		}
	}

	public void run() {// ��������
		Graphics g;
		while (true) {
			try {
				// ���ͼ��
				drawT_image();
				g = this.getGraphics();
				g.drawImage(T_image, 0, 0, this);
				Thread.sleep((int) (delay * 1000 * Math.random()));// �߳����ߣ�ʱ���������
				no_Light = 1;// �������Ǳ�����λ
				createLight();// ��������
				// ���ͼ��
				drawT_image();
				g = this.getGraphics();
				g.drawImage(T_image, 0, 0, this);
				Thread.sleep(1000);// �߳�����1��
				no_Light = 0;// �������Ǳ�����λ
			} catch (InterruptedException e) {
				stop();// �����쳣��ֹͣ�߳�
			}
		}
	}
}
