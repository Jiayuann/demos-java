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
		contentPane.add(new JButton("EAST"), BorderLayout.EAST);// ����ť�ŵ�����
		contentPane.add(new JButton("WEST"), BorderLayout.WEST);// ����ť�ŵ�����
		contentPane.add(new JButton("SOUTH"), BorderLayout.SOUTH);// ����ť�ŵ��ϲ�
		contentPane.add(new JButton("NORTH"), BorderLayout.NORTH);// ����ť�ŵ�����
		contentPane.add(new JLabel("CENTER", JLabel.CENTER),
				BorderLayout.CENTER);// ����ť�ŵ��в�
		jf.setTitle("BorderLayout���沼��");// ���ñ���
		jf.pack();
		jf.setSize(250, 250);
		jf.setVisible(true);
		/*
		 * ��һ�����ڽ��йرղ��������û��д��һ�Σ���ʹ���Ѿ��رմ����ˣ������򲢲�����ֹ��
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
