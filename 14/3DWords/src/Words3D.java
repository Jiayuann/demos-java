import java.awt.*;
import javax.swing.JApplet;
public class Words3D extends JApplet implements Runnable {
	private Image image;// ����Image����
	private Image image_1;//����Image����
	private Graphics gp;// ������ͼ����
	private Thread thread = null;// �����߳�
	private MediaTracker tracker;// ����ý�������
	private int height, width;// ����int����
	private String text;// ����String����text
	private Font font;// ����Font����
	public void init() {// Applet��ʼ��
		this.setSize(300, 200);// ���ó�ʼ��С
		width = this.getWidth();// �õ������Ŀ�
		height = this.getHeight();// ��ȡ�����ĸ�
		this.setBackground(Color.yellow);// ���������ı���ɫ
		image = createImage(width, height);// ���ݵ�ǰ�Ŀ�͸ߴ���һ��ͼ��
		text = "welcome";// String����text��ֵ
		String str = "�������";// ����һ���г�ʼֵ��String����
		if (str != null)
			text = str;// ��str��ֵ��Ϊ�յ�ǰ���£���str��ֵ����text
		font = new Font("�����п�", Font.BOLD, 50);// ����һ��Font����
		tracker = new MediaTracker(this);// ����һ��MediaTracker����
		tracker.addImage(image, 0);// ��image���ص�tracker��
		try {
			tracker.waitForID(0);// �ȴ�����IdΪ0��ͼ��
		} catch (InterruptedException e) {
		}
		image_1 = createImage(width, height);// ���ݵ�ǰ�Ŀ�͸ߴ���һ��ͼ��
		gp = image_1.getGraphics();// ����ͼ��image_1�����Graphics����
	}
	public void start() {// �����߳�
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	public void run() {// �����߳�
		int x = 20;// ���û���ͼ���X����
		int y = height / 2;// ���û���ͼ���Y����
		int R, G, B;// ����RGB��ɫֵ
		gp.setFont(font);// ���û�ͼ������
		while (thread != null) {// �������̵߳�ǰ����
		// �������Color��ɫֵ
			R = (int) (255 * Math.random());
			G = (int) (255 * Math.random());
			B = (int) (255 * Math.random());
			try {
				thread.sleep(2000);// �߳�����2000����
			} catch (InterruptedException ex) {
			}
			gp.setColor(Color.white);// ���û�ͼ�ı���ɫΪ��ɫ
			gp.fillRect(0, 0, width, height);// ����������εĴ�С��λ��
			repaint();// ���»��ƴ����
			for (int i = 0; i < 10; i++) {
				gp.setColor(new Color((255 - (0 + R) * i / 10), (255 - (0 + G)
						* i / 10), (255 - (0 + B) * i / 10)));// ���� sRGB															// �����õ�ǰ�Ļ�ͼ��ɫ
				gp.drawString(text, x - i, y - i);// ���ݵ�ǰ�������ɫ������ָ�� string												// �������ı�
				repaint();// ���»��ƴ����
				try {
					thread.sleep(60);// �߳�����60����
				} catch (InterruptedException e) {
				}
			}
		}
	}
	public void paint(Graphics g) {// ��ͼ����
		g.drawImage(image_1, 0, 0, this);
	}
}