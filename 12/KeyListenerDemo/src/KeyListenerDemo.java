import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KeyListenerDemo extends KeyAdapter implements ActionListener {
	JFrame f = null;
	JLabel label = null;
	JTextField tField = null;
	String keyString = "";
	public KeyListenerDemo() {
		f = new JFrame("键盘监听");// 为这个JFrame设置一个标题
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(3, 1));
		label = new JLabel();// 创建一个标签对象
		tField = new JTextField();
		tField.requestFocus();
		tField.addKeyListener(this);
		JButton b = new JButton("清除");// 创建一个按钮
		b.addActionListener(this);
		contentPane.add(label);
		contentPane.add(tField);
		contentPane.add(b);
		f.setSize(250,250);
		f.setLocation(200,300);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		keyString = "";
		label.setText("");
		tField.setText("");
		tField.requestFocus();
	}
	//输入字母"O"之后，会产生新窗口
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();/* 注意getKeyChar()的用法 */
		if (c == 'o') {
			JFrame newF = new JFrame("新窗口");
			newF.setSize(250,250);
			newF.setLocation(200,300);
			newF.setVisible(true);
		}
		keyString = keyString + c;
		label.setText(keyString);
	}
	public static void main(String[] args) {
		new KeyListenerDemo();
	}
}
