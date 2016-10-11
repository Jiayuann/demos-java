import java.awt.*;
import javax.swing.JApplet;
public class Words3D extends JApplet implements Runnable {
	private Image image;// 声明Image变量
	private Image image_1;//声明Image变量
	private Graphics gp;// 声明绘图对象
	private Thread thread = null;// 声明线程
	private MediaTracker tracker;// 声明媒体跟踪器
	private int height, width;// 声明int变量
	private String text;// 声明String变量text
	private Font font;// 声明Font对象
	public void init() {// Applet初始化
		this.setSize(300, 200);// 设置初始大小
		width = this.getWidth();// 得到容器的宽
		height = this.getHeight();// 获取容器的高
		this.setBackground(Color.yellow);// 设置容器的背景色
		image = createImage(width, height);// 根据当前的宽和高创建一个图像
		text = "welcome";// String变量text赋值
		String str = "天道酬勤";// 创建一个有初始值的String变量
		if (str != null)
			text = str;// 在str的值不为空的前提下，将str的值赋给text
		font = new Font("华文行楷", Font.BOLD, 50);// 创建一个Font对象
		tracker = new MediaTracker(this);// 创建一个MediaTracker对象
		tracker.addImage(image, 0);// 将image加载到tracker中
		try {
			tracker.waitForID(0);// 等待加载Id为0的图像
		} catch (InterruptedException e) {
		}
		image_1 = createImage(width, height);// 根据当前的宽和高创建一个图像
		gp = image_1.getGraphics();// 根据图像image_1，获得Graphics对象
	}
	public void start() {// 启动线程
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	public void run() {// 运行线程
		int x = 20;// 设置绘制图像的X坐标
		int y = height / 2;// 设置绘制图像的Y坐标
		int R, G, B;// 设置RGB颜色值
		gp.setFont(font);// 设置绘图的字体
		while (thread != null) {// 在启动线程的前提下
		// 随机生成Color颜色值
			R = (int) (255 * Math.random());
			G = (int) (255 * Math.random());
			B = (int) (255 * Math.random());
			try {
				thread.sleep(2000);// 线程休眠2000毫秒
			} catch (InterruptedException ex) {
			}
			gp.setColor(Color.white);// 设置绘图的背景色为黑色
			gp.fillRect(0, 0, width, height);// 设置所绘矩形的大小和位置
			repaint();// 重新绘制此组件
			for (int i = 0; i < 10; i++) {
				gp.setColor(new Color((255 - (0 + R) * i / 10), (255 - (0 + G)
						* i / 10), (255 - (0 + B) * i / 10)));// 根据 sRGB															// ，设置当前的绘图颜色
				gp.drawString(text, x - i, y - i);// 根据当前字体和颜色绘制由指定 string												// 给定的文本
				repaint();// 重新绘制此组件
				try {
					thread.sleep(60);// 线程休眠60毫秒
				} catch (InterruptedException e) {
				}
			}
		}
	}
	public void paint(Graphics g) {// 绘图方法
		g.drawImage(image_1, 0, 0, this);
	}
}