import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class JOptionPaneDemo {	
	JFrame f=new JFrame("�û��Ի���JOptionPane���÷�");
	JPanel p=new JPanel(new GridLayout(1,3,10,10));
	JButton b1=new JButton("ȷ�϶Ի���");
	JButton b2=new JButton("����Ի���");
	JButton b3=new JButton("��Ϣ�Ի���");
	JLabel ch=new JLabel("���ѡ���������",JLabel.CENTER);
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
			 "����һ��ȷ�϶Ի���! ����ֵ:\n0��ʾ��ѡ��Yes��1��ʾѡ��No��2��ʾѡ��Cancel","ȷ�϶Ի�����÷�",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
				String choice;
				if(n==0) choice="Yes";
				else if(n==1) choice="No";
					else choice="Cancel";
				ch.setText("��ѡ����ǣ�"+choice);
			}
			if(sel==2)
			{	Object []vals={"Blue","Yellow","Brown","Pink","White"};
				String inpt=(String)JOptionPane.showInputDialog(null,"����һ������Ի���! \n����ֵ��ʾ��������ѡ��",
				              "����Ի�����÷�",
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("01.jpg"),vals,vals[2]);
				ch.setText("��������ǣ�"+inpt);
			}
			if(sel==3)
			{	JOptionPane.showMessageDialog(null,"����һ����Ϣ�Ի���! û�з���ֵ��",
				            "��Ϣ�Ի�����÷�",
                JOptionPane.WARNING_MESSAGE,
                new ImageIcon("01.jpg"));
				ch.setText("��Ϣ�Ի���û�з���ֵ��");
			}
		}
	}
}
