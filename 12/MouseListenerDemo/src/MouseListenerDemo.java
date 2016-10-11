import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerDemo extends WindowAdapter implements MouseListener {
	JFrame f = null;
	JButton b1 = null;
	JLabel label = null;
	public MouseListenerDemo() {
		f = new JFrame("ʹ��MouseListener��������¼�");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));
		b1 = new JButton("��ť");
		label = new JLabel("��ʼ״̬����û������¼�", JLabel.CENTER);
		b1.addMouseListener(this);
		contentPane.add(label);
		contentPane.add(b1);
		f.setSize(250,250);
		f.setLocation(200,300);
		f.setVisible(true);
		f.addWindowListener(this);
	}
	public void mousePressed(MouseEvent e) {
		label.setText("���Ѿ�ѹ����갴ť");
	}
	public void mouseReleased(MouseEvent e) {
		label.setText("���Ѿ��ſ���갴ť");
	}
	public void mouseEntered(MouseEvent e) {
		label.setText("�������밴ť");
	}
	public void mouseExited(MouseEvent e) {
		label.setText("������뿪��ť");
	}
	public void mouseClicked(MouseEvent e) {
		label.setText("���Ѿ����°�ť");
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public static void main(String[] args) {
		new MouseListenerDemo();
	}
}
