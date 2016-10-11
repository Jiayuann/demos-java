import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderLayoutDemo {
	public BorderLayoutDemo() {
		JFrame jf = new JFrame();
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JButton("EAST"), BorderLayout.EAST);// 将按钮放到东侧
		contentPane.add(new JButton("WEST"), BorderLayout.WEST);// 将按钮放到西侧
		contentPane.add(new JButton("SOUTH"), BorderLayout.SOUTH);// 将按钮放到南侧
		contentPane.add(new JButton("NORTH"), BorderLayout.NORTH);// 将按钮放到北侧
		contentPane.add(new JLabel("CENTER", JLabel.CENTER),
				BorderLayout.CENTER);// 将按钮放到中部
		jf.setTitle("BorderLayout版面布局");// 设置标题
		jf.pack();
		jf.setSize(250, 250);
		jf.setVisible(true);
		/*
		 * 对一个窗口进行关闭操作，如果没有写这一段，即使你已经关闭窗口了，但程序并不会终止。
		 */
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		BorderLayoutDemo b = new BorderLayoutDemo();
	}
}
