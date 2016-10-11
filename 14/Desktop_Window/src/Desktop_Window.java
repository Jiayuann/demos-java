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
		// ����һ����ǩ����ǩ����ʾͼƬ������ǩ���ڻ�ӭ�����м�
		JLabel label = new JLabel(new ImageIcon(image_url));
		getContentPane().add(label, BorderLayout.CENTER);
		pack();
		// ��ȡ��Ļ�ķֱ��ʴ�С
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension labelSize = label.getPreferredSize();// ��ȡ��ǩ��С
		// ����ӭ���������Ļ�м�
		setLocation(screenSize.width / 2 - (labelSize.width / 2),
				screenSize.height / 2 - (labelSize.height / 2));
		// ����һ������¼�������������û�����굥���˻�ӭ���棬��رա�
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		rest = waitTime;
		closerThread = new Thread() {// �رջ�ӭ������߳�
			public void run() {
				setVisible(false);
				dispose();// �ͷ���Դ
			}
		};
		waitThread = new Thread();// �ȴ��رջ�ӭ������߳�
		setVisible(true);
		waitThread.start();// �����ȴ��رջ�ӭ������߳�
	}
	public static void main(String[] args) throws FileNotFoundException {
		JFrame frame = new JFrame("���ƻ�ӭ����");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Desktop_Window dw = new Desktop_Window("D:/abc/QQ.jpg", frame, 5000);
		frame.pack();
		frame.setVisible(true);
	}
	public void run() {
		try {
			Thread.sleep(rest);// ����ʾ��rest�󣬳��Թرջ�ӭ����
			SwingUtilities.invokeAndWait(closerThread);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
