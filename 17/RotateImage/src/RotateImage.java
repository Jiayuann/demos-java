import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
public class RotateImage implements ActionListener{
	JFrame frame; // 主窗体
	MyPanel panel;
	JButton rotate; // 控制旋转的按钮
	public RotateImage() {
		frame = new JFrame("绘图Demo");
		frame.setSize(400, 500);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		panel = new MyPanel();
		panel.setBounds(0, 0, 400, 400);
		frame.getContentPane().add(panel);
		rotate = new JButton("逆旋"); // 每按一次逆时针旋转90度
		rotate.setBounds(5, 405, 390, 90);
		frame.getContentPane().add(rotate);
		rotate.addActionListener(this);
	}
	public static void main(String[] args) {
		new RotateImage();
	}
	public void actionPerformed(ActionEvent e) {
		panel.setXuanzhuan(panel.getXuanzhuan() - Math.PI/2);
		panel.repaint();
	}
}
class MyPanel extends JPanel {
	 private double xuanzhuan = 0;
	 private Image image;
	 public void paintComponent(Graphics g) {
	  Graphics2D g2d = (Graphics2D) g;
	  g2d.fillRect(0, 0, 400, 400);
	  g2d.rotate(xuanzhuan, 200, 200);
	  image = new ImageIcon("src/图片.jpg")
	    .getImage();
	  g2d.drawImage(image, 75, 75, this);
	  g.dispose();
	 }
	 public Image getImage() {
	  return image;
	 }
	 public double getXuanzhuan() {
	  return xuanzhuan;
	 }
	 public void setXuanzhuan(double xuanzhuan) {
	  this.xuanzhuan = xuanzhuan;
	 }
}
