import java.awt.*;
import java.applet.*;
public class ColorWords extends Applet implements Runnable { // ���߳����нӿ�
	String str = null;
	int d = 1;
	int h = 18;
	int v = 18;
	Thread thread = null; // ����һ���߳�
	char[] ch;
	int p = 0;
	Image image;
	Graphics gphics;
	Color[] color;
	private Font f; // ����
	private FontMetrics fm; // ��ģ
	public void init() {
		str = "���н�����������ǿ��Ϣ";// �����߲���������
		this.setSize(500, 200);// ����Applet�Ĵ�С
		setBackground(Color.white);// ���ñ�����ɫ
		ch = new char[str.length()];
		ch = str.toCharArray();// ���ַ����еĸ����ַ����浽������
		image = createImage(getSize().width, getSize().height);
		gphics = image.getGraphics();
		f = new Font("�����п�", Font.BOLD, 30);
		fm = getFontMetrics(f);// ���ָ�������������
		gphics.setFont(f);// �������������
		float hue;
		// ��ɫ��ɫԪ
		color = new Color[str.length()];
		for (int i = 0; i < str.length(); i++) {
			hue = ((float) i) / ((float) str.length());
			color[i] = new Color(Color.HSBtoRGB(hue, 0.8f, 1.0f)); // ��ɫ����
		}
	}
	public void start() {
		if (thread == null) { // ����߳�Ϊ�գ���
			thread = new Thread(this);
			// ��ʼ�µ��߳�
			thread.start(); // ��ʼ
		}
	}
	// ��ֹ�߳�
	public void stop() {
		if (thread != null) { // ����̲߳�Ϊ�գ���
			thread.stop(); // ��ֹ�̣߳�ʹ��
			thread = null; // Ϊ��
		}
	}
	// �����߳�
	public void run() {
		while (thread != null) {
			try {
				thread.sleep(200); // ���̳߳�˯200����
			} catch (InterruptedException e) {
			}
			repaint(); // ���»��ƽ���
		}
	}
	public void update(Graphics g) { // ��дupdate�����������˸����
		int x, y;
		double angle;
		gphics.setColor(Color.white);
		gphics.fillRect(0, 0, getSize().width, getSize().height);
		p += d;
		p %= 7;// ��Ҫ�����ֵ��ٶȣ�������ԽС���ٶ�Խ��
		// System.out.println(p+" p1");
		for (int i = 0; i < str.length(); i++) {
			angle = ((p - i * d) % 7) / 4.0 * Math.PI;// ��Ҫ���ƻ��ȵģ�������ԽС������Խ��
			x = 30 + fm.getMaxAdvance() * i + (int) (Math.cos(angle) * h);// ��x����ֵ
			y = 80 + (int) (Math.sin(angle) * v); //��y����ֵ
			gphics.setColor(color[(p + i) % str.length()]);
			gphics.drawChars(ch, i, 1, x, y);
		}
		paint(g);
	}
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}
