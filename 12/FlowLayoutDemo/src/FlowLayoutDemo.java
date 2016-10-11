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
		contentPane.setLayout(new FlowLayout());//创建一个布局管理器
		contentPane.add(new JButton("第一个"));//设置第一个按钮
		contentPane.add(new JButton("第二个"));
		contentPane.add(new JButton("第三个"));
		contentPane.add(new JButton("第四个"));
		contentPane.add(new JButton("第五个"));
		contentPane.add(new JButton("第六个"));
		f.setTitle("FlowLayout");
		// f.pack();//必须将f.pach()去掉，否则setSize功能将没有作用
		f.setSize(250, 250);
		f.setVisible(true);//将框架设置为可见状态
		f.addWindowListener(new WindowAdapter() {//创建一个监听
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		FlowLayoutDemo b = new FlowLayoutDemo();
	}
}
