import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;                
import javax.swing.colorchooser.*; 
//包javax.swing.colorchooser中定义了颜色选择模板DefaultColorSelectionModel
public class JColorChooserDemo 
{	JFrame f=new JFrame("颜色选择对话框JColorChooser的用法");
	JTextField disp=new JTextField("下面的调色板设置文字颜色",JTextField.CENTER);
	DefaultColorSelectionModel md1 = new DefaultColorSelectionModel();
	//定义颜色选择模板DefaultColorSelectionModel对象md1
	DefaultColorSelectionModel md2 = new DefaultColorSelectionModel();
	//定义颜色选择模板DefaultColorSelectionModel对象md2
	JColorChooser jcc1=new JColorChooser(md1);
	//定义颜色选择对话框JColorChooser对象jcc1，其颜色模板为md1
	JColorChooser jcc2=new JColorChooser(md2);
	//定义颜色选择对话框JColorChooser对象jcc2，其颜色模板为md2
	Color clr;
	Font ft=new Font("TimesRoman",Font.PLAIN,34);
	JButton b1=new JButton("设置背景颜色");
	JDialog jdg;
	//定义通用对话框
	void go()
	{	f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add("North",disp);
		f.getContentPane().add("Center",jcc2);
		//将调色板jcc2加到窗口的中央
		disp.setFont(ft);
		md2.addChangeListener(new ChangeH());
		//将颜色模板md2注册到监听器ChangeH中
		f.getContentPane().add("South",b1);
		b1.setFont(ft);
		b1.addActionListener(new B1());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(450,350);
		f.setVisible(true);
	}
	class B1 implements ActionListener
	//选择按钮b1将显示一个颜色对话框jdg
	{	public void actionPerformed(ActionEvent e)
		{	jdg=JColorChooser.createDialog(null,"设置背景颜色的对话框",true,jcc1,new OK(),new Cancel());
			//在颜色对话框jdg中，显示调色板jcc1，其确定按钮的监听器是OK，
			//取消按钮的监听器是Cancel
			jdg.setSize(450,350);
			jdg.setLocation(200,300);
			jdg.setVisible(true);
		}
	}
	class OK implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	clr=jcc1.getColor();
			//获取调色板jcc1中所选的颜色clr
			disp.setBackground(clr);
			//改变单行编辑框disp的背景色为clr
		}
	}
	class Cancel implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{}
	}
	class ChangeH implements ChangeListener
	//类ChangeH是颜色模板md2的注册到监听器
	{	public void stateChanged(ChangeEvent e)
		{		clr=jcc2.getColor();
				//获取调色板jcc2中所选的颜色clr
				disp.setForeground(clr);
				//改变单行编辑框disp的前景色为clr
		}
	}
	public static void main(String []arg)
	{	JColorChooserDemo that=new JColorChooserDemo();
		that.go();
	}
}
