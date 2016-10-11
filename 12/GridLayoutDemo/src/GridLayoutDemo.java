import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GridLayoutDemo implements ActionListener {
	JPanel p1, p2, p3, p4;
	int i = 1;
	JFrame f;
	public GridLayoutDemo() {
		f = new JFrame();		// ����һ��JFrame�Ķ���
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));
		p1 = new JPanel();
		Button b = new Button("���񲼾�");
		b.addActionListener(this);	// ������"���񲼾�"��ťʱ�������¼�������������ϵͳ����������
		p1.add(b); 			// ���������52-64��.
		contentPane.add(p1);
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(new JButton("first"));	// ����һ����ť��ӵ�����p2��
		p2.add(new JButton("second"));// ���ڶ�����ť��ӵ�����p2��
		p2.add(new JButton("third"));	// ����������ť��ӵ�����p2��
		p3 = new JPanel();
		p3.setLayout(new GridLayout(3, 1));
		p3.add(new JButton("fourth"));
		p3.add(new JButton("fifth"));
		p3.add(new JButton("This is the last button"));
		p4 = new JPanel();
		p4.setLayout(new GridLayout());
		p4.add("one", p2);
		p4.add("two", p3);
		
		contentPane.add(p4);
		f.setTitle("CardLayout");
		f.pack();
		f.setVisible(true);			// ���������Ϊ�ɼ�״̬
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent event) {
		switch (i) {
		case 1:
			break;
		case 2:
			break;
		}
		i++;
		if (i == 3)
			i = 1;
		f.validate();
	}
	public static void main(String[] args) {
		new GridLayoutDemo();
	}
}
