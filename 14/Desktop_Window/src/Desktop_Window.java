import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class Desktop_Window extends JWindow implements Runnable {
	Thread waitThread;
	final int rest;
	final Thread closerThread;
	public Desktop_Window(String image_url, JFrame frame, int waitTime) {
		super(frame);
		// 建立一个标签，标签中显示图片。将标签放在欢迎画面中间
		JLabel label = new JLabel(new ImageIcon(image_url));
		getContentPane().add(label, BorderLayout.CENTER);
		pack();
		// 获取屏幕的分辨率大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension labelSize = label.getPreferredSize();// 获取标签大小
		// 将欢迎画面放在屏幕中间
		setLocation(screenSize.width / 2 - (labelSize.width / 2),
				screenSize.height / 2 - (labelSize.height / 2));
		// 增加一个鼠标事件处理器，如果用户用鼠标单击了欢迎画面，则关闭。
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		rest = waitTime;
		closerThread = new Thread() {// 关闭欢迎画面的线程
			public void run() {
				setVisible(false);
				dispose();// 释放资源
			}
		};
		waitThread = new Thread();// 等待关闭欢迎画面的线程
		setVisible(true);
		waitThread.start();// 启动等待关闭欢迎画面的线程
	}
	public static void main(String[] args) throws FileNotFoundException {
		JFrame frame = new JFrame("自制欢迎动画");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Desktop_Window dw = new Desktop_Window("D:/abc/QQ.jpg", frame, 5000);
		frame.pack();
		frame.setVisible(true);
	}
	public void run() {
		try {
			Thread.sleep(rest);// 当显示了rest后，尝试关闭欢迎画面
			SwingUtilities.invokeAndWait(closerThread);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
