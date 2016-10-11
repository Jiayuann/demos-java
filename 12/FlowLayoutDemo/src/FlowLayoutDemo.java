import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo {
	public FlowLayoutDemo() {
		JFrame f = new JFrame();
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new FlowLayout());//����һ�����ֹ�����
		contentPane.add(new JButton("��һ��"));//���õ�һ����ť
		contentPane.add(new JButton("�ڶ���"));
		contentPane.add(new JButton("������"));
		contentPane.add(new JButton("���ĸ�"));
		contentPane.add(new JButton("�����"));
		contentPane.add(new JButton("������"));
		f.setTitle("FlowLayout");
		// f.pack();//���뽫f.pach()ȥ��������setSize���ܽ�û������
		f.setSize(250, 250);
		f.setVisible(true);//���������Ϊ�ɼ�״̬
		f.addWindowListener(new WindowAdapter() {//����һ������
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		FlowLayoutDemo b = new FlowLayoutDemo();
	}
}
