import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class JOptionPaneDemo {	
	JFrame f=new JFrame("用户对话框JOptionPane的用法");
	JPanel p=new JPanel(new GridLayout(1,3,10,10));
	JButton b1=new JButton("确认对话框");
	JButton b2=new JButton("输入对话框");
	JButton b3=new JButton("信息对话框");
	JLabel ch=new JLabel("你的选择或输入是",JLabel.CENTER);
	Font ft=new Font("Serif",Font.BOLD,18);
	public static void main(String args[])
	{	JOptionPaneDemo that=new JOptionPaneDemo();
		that.go();
	}
	void go()
	{	f.getContentPane().add("North",p);
		p.add(b1);
        p.add(b2);
        p.add(b3);
		b1.setFont(ft);
        b2.setFont(ft);
        b3.setFont(ft);
		f.getContentPane().add("Center",ch);
		ch.setFont(ft);
		b1.addActionListener(new ButtonH(1));
		b2.addActionListener(new ButtonH(2));
		b3.addActionListener(new ButtonH(3));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,250);
		f.setVisible(true);
	}
	class ButtonH implements ActionListener
	{	int sel;
		ButtonH(int select)
		{	sel=select;}
		public void actionPerformed(ActionEvent e)
		{	if(sel==1)
			{	int n=JOptionPane.showConfirmDialog(null,
			 "这是一个确认对话框! 返回值:\n0表示你选择Yes、1表示选择No、2表示选择Cancel","确认对话框的用法",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
				String choice;
				if(n==0) choice="Yes";
				else if(n==1) choice="No";
					else choice="Cancel";
				ch.setText("你选择的是："+choice);
			}
			if(sel==2)
			{	Object []vals={"Blue","Yellow","Brown","Pink","White"};
				String inpt=(String)JOptionPane.showInputDialog(null,"这是一个输入对话框! \n返回值表示你的输入或选择",
				              "输入对话框的用法",
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("01.jpg"),vals,vals[2]);
				ch.setText("你输入的是："+inpt);
			}
			if(sel==3)
			{	JOptionPane.showMessageDialog(null,"这是一个信息对话框! 没有返回值！",
				            "信息对话框的用法",
                JOptionPane.WARNING_MESSAGE,
                new ImageIcon("01.jpg"));
				ch.setText("信息对话框没有返回值！");
			}
		}
	}
}
