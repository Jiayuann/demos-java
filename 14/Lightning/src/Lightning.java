import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

//在applet中支持线程，需要实现Runnable接口
public class Lightning extends Applet implements Runnable {
	private Thread thread = null; // applet支持的线程

	private int no_Light = 0; // 没有闪电的标志变量:0表示没有闪电，

	private int Light = 1; // 有闪电的标志变量

	private int[] light;// 声明int型数组light

	private int[] array_1;// 声明int型数组array_1

	private int[] array_2;// 声明int型数组array_2

	private Image T_image, image;// 声明Image变量T_image, image

	private int delay = 3;// 延长的时间倍数

	public void init() {// 初始化applet
		this.setSize(650,450);
		String imageName = "city.gif";
		image = getImage(getCodeBase(), imageName);
		// 创建int型数组，定义其长度为getSize().height
		light = new int[getSize().height];
		array_1 = new int[getSize().height];
		array_2 = new int[getSize().height];
		T_image = this.createImage(getSize().width, getSize().height); // 根据指定的参数创建一幅图像
	}

	public void paint(Graphics g) {
		int i, t;
		if (no_Light == 0) // 没有闪电
		{
			g.setColor(Color.black); // 设背景色为黑色
			g.fillRect(0, 0, getSize().width, getSize().height); // 填充背景色
			g.drawImage(image, 0, 0, this); // 输出city.gif
		} else // 有闪电
		{
			switch (Light) {
			case 1:
				g.setColor(new Color(240, 255, 255));
				break; // 设背景色为蓝色
			case 2:
				g.setColor(new Color(176, 48, 96));
				break; // 设背景色为红色
			case 3:
				g.setColor(new Color(250, 255, 240));
				break; // 设背景色为黄色
			case 4:
				g.setColor(new Color(240, 255, 240));
				break; // 设背景色为绿色
			case 5:
				g.setColor(new Color(248, 248, 255));
				break; // 设背景色为祡色
			default:
				g.setColor(new Color(245, 245, 245));
				break; // 设背景色为白色
			}
			g.fillRect(0, 0, getSize().width, getSize().height); // 填充背景色
			t = (int) (0.6F * getSize().height);// 输出闪电图像
			for (i = 1; i < getSize().height; i++) {
				if (i < t) { // 输出闪电周围的灰色矩形
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
					break; // 蓝色闪电
				case 2:
					g.setColor(new Color(255, 0, 0));
					break; // 红色闪电
				case 3:
					g.setColor(new Color(255, 215, 0));
					break; // 黄色闪电
				case 4:
					g.setColor(new Color(0, 255, 0));
					break; // 绿色闪电
				case 5:
					g.setColor(new Color(160, 32, 240));
					break; // 祡色闪电
				default:
					g.setColor(new Color(225, 225, 225));
					break; // 白色闪电
				}
				g.drawLine(light[i], i, light[i - 1], i - 1);
				if (array_1[i] >= 0) { // 输出闪电折线
					g.drawLine(array_1[i], i, array_1[i - 1], i - 1);
				}
				if (array_2[i] >= 0) { // 输出闪电折线
					g.drawLine(array_2[i], i, array_2[i - 1], i - 1);
				}
			}
			g.drawImage(image, 0, 0, this);// 输出城市图像city.gif
			Light = (int) ((Math.random() * 10) + 1);
		}
	}

	void drawT_image() {// 调用paint()方法
		Graphics g;
		g = T_image.getGraphics();
		paint(g);
	}

	public void start() {// 启动applet，创建并启动线程
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {// 停止运行线程
		if (thread != null) {
			thread.stop();
			thread = null;
		}
	}

	void createLight() {// 生成闪电的坐标数组数据
		int i;
		int bs1, bs2; // 开始位置的坐标
		int be1, be2; // 结束位置的坐标
		light[0] = (int) (Math.random() * getSize().width); // 随机产生闪电出现的位置
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

	public void run() {// 启动进程
		Graphics g;
		while (true) {
			try {
				// 输出图像
				drawT_image();
				g = this.getGraphics();
				g.drawImage(T_image, 0, 0, this);
				Thread.sleep((int) (delay * 1000 * Math.random()));// 线程休眠，时间随机产生
				no_Light = 1;// 无闪电标记变量置位
				createLight();// 创建闪电
				// 输出图像
				drawT_image();
				g = this.getGraphics();
				g.drawImage(T_image, 0, 0, this);
				Thread.sleep(1000);// 线程休眠1秒
				no_Light = 0;// 无闪电标记变量置位
			} catch (InterruptedException e) {
				stop();// 发生异常，停止线程
			}
		}
	}
}
