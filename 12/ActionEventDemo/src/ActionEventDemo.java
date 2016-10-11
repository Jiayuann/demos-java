import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionEventDemo extends WindowAdapter implements ActionListener {
	JButton b1 = null;
	JButton b2 = null;
	public ActionEventDemo() {
		JFrame f = new JFrame("ActionEventDemo");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));
		b1 = new JButton("发声按钮");
		b2 = new JButton("创建新窗口");
		b1.addActionListener(this);
		b2.addActionListener(this);
		contentPane.add(b1);
		contentPane.add(b2);
		f.pack();
		f.setSize(250,250);
		f.setVisible(true);
		f.addWindowListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1)// 利用getSource判断哪个按钮被按下了。
			Toolkit.getDefaultToolkit().beep();
		if (e.getSource() == b2) {
			JFrame jf = new JFrame("新窗口");
			jf.setSize(250,250);
			jf.show();
		}
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public static void main(String args[]) {
		new ActionEventDemo();
	}
}
