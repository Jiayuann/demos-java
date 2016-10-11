import java.awt.*;
import java.applet.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.image.*;
public class Blinds extends Applet implements Runnable {
	private Image IMG[], image;// 声明Image数组和变量
	private MediaTracker tracker;// 声明MediaTracker变量
	private int width, height, image_count = 8, image2, image3;// 声明int类型的变量
	private Thread thread;// 声明Thread变量
	private int delay = 3000;// 定义int变量，初始值为3000
	private int p, p_1[], p_2[], p_3[], p_4[], p_5[], p_6[], p_7[], p_8[],
			p_A[], p_B[];// 声明int型数组，用于接收生成图像的像素
	public void init() {
		this.setBackground(Color.white);// 设置背景颜色为黑色
		this.setSize(320, 250);// 设置边框的宽和高
		IMG = new Image[image_count];// 创建数组长度为image_count的Image数组
		tracker = new MediaTracker(this);// 创建MediaTracker对象
		String s = "";
		for (int i = 0; i < image_count; i++) {
			s = (i + 1) + ".jpg";
			URL url;
			try {
				url = new URL("file:" + s);// 创建URL对象
				IMG[i] = getImage(url);// 创建Image对象
				tracker.addImage(IMG[i], 0);// 将Image对象添加到tracker中的指定位置中
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		try {
			tracker.waitForID(0);// 等待加载ID为0的所有图像
		} catch (InterruptedException e) {
		}
		width = IMG[0].getWidth(this);// 得到此图片的宽
		height = IMG[0].getHeight(this);// 得到此图片的高
		p = width * height;// 宽和高的乘积
		p_1 = new int[p];// 创建长度为p的int数组
		PixelGrabber PG1 = new PixelGrabber(IMG[0], 0, 0, width, height, p_1,
				0, width);// 创建一个 PixelGrabber 对象，以便从指定的图像中将像素矩形部分 (x, y, w,
							// h) 抓取到给定的数组中。
		try {
			PG1.grabPixels();// 请求Image开始传递像素，并等待传递完相关矩形中的所有像素，或者等待到超时期已过。
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

		thread = new Thread(this);// 创建线程
		thread.start();// 启动线程
	}
	public void paint(Graphics g)// 绘制组件
	{
		g.drawImage(image, 0, 0, this);
	}
	public void update(Graphics g)// 更新组件
	{
		paint(g);
	}
	public void run()// 运行线程
	{
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		while (true)// 控制图片和图片之间的过渡
		{
			try {
				thread.sleep(delay);// 线程休眠delay毫秒
				image3 = ((image2 + 1) % image_count);// 指向当前图片的下一张图片
				if (image2 == 0) {
					System.arraycopy(p_1, 0, p_A, 0, p);// 从下标为0的p_1数组
													// 中复制一个数组，存放到p_A数组中下标为0的位置中，其数组长度为p
					System.arraycopy(p_2, 0, p_B, 0, p);// 同上
					image = createImage(new MemoryImageSource(width, height,
							p_A, 0, width));// 根据指定的图像生成器创建一幅图像。
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

				while (true)// 控制叶宽
				{
					for (int i = 0; i < (int) (height / 13); i++) {
						try {
							thread.sleep(50);// 线程休眠30毫秒
							for (int j = 0; j < height; j += (int) (height / 13)) {
								for (int k = 0; k < width; k++) {
									p_A[width * (j + i) + k] = p_B[width
											* (j + i) + k];// 进行数组间的复制

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
