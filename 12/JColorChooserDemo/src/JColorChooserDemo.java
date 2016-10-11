import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;                
import javax.swing.colorchooser.*; 
//��javax.swing.colorchooser�ж�������ɫѡ��ģ��DefaultColorSelectionModel
public class JColorChooserDemo 
{	JFrame f=new JFrame("��ɫѡ��Ի���JColorChooser���÷�");
	JTextField disp=new JTextField("����ĵ�ɫ������������ɫ",JTextField.CENTER);
	DefaultColorSelectionModel md1 = new DefaultColorSelectionModel();
	//������ɫѡ��ģ��DefaultColorSelectionModel����md1
	DefaultColorSelectionModel md2 = new DefaultColorSelectionModel();
	//������ɫѡ��ģ��DefaultColorSelectionModel����md2
	JColorChooser jcc1=new JColorChooser(md1);
	//������ɫѡ��Ի���JColorChooser����jcc1������ɫģ��Ϊmd1
	JColorChooser jcc2=new JColorChooser(md2);
	//������ɫѡ��Ի���JColorChooser����jcc2������ɫģ��Ϊmd2
	Color clr;
	Font ft=new Font("TimesRoman",Font.PLAIN,34);
	JButton b1=new JButton("���ñ�����ɫ");
	JDialog jdg;
	//����ͨ�öԻ���
	void go()
	{	f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add("North",disp);
		f.getContentPane().add("Center",jcc2);
		//����ɫ��jcc2�ӵ����ڵ�����
		disp.setFont(ft);
		md2.addChangeListener(new ChangeH());
		//����ɫģ��md2ע�ᵽ������ChangeH��
		f.getContentPane().add("South",b1);
		b1.setFont(ft);
		b1.addActionListener(new B1());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(450,350);
		f.setVisible(true);
	}
	class B1 implements ActionListener
	//ѡ��ťb1����ʾһ����ɫ�Ի���jdg
	{	public void actionPerformed(ActionEvent e)
		{	jdg=JColorChooser.createDialog(null,"���ñ�����ɫ�ĶԻ���",true,jcc1,new OK(),new Cancel());
			//����ɫ�Ի���jdg�У���ʾ��ɫ��jcc1����ȷ����ť�ļ�������OK��
			//ȡ����ť�ļ�������Cancel
			jdg.setSize(450,350);
			jdg.setLocation(200,300);
			jdg.setVisible(true);
		}
	}
	class OK implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	clr=jcc1.getColor();
			//��ȡ��ɫ��jcc1����ѡ����ɫclr
			disp.setBackground(clr);
			//�ı䵥�б༭��disp�ı���ɫΪclr
		}
	}
	class Cancel implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{}
	}
	class ChangeH implements ChangeListener
	//��ChangeH����ɫģ��md2��ע�ᵽ������
	{	public void stateChanged(ChangeEvent e)
		{		clr=jcc2.getColor();
				//��ȡ��ɫ��jcc2����ѡ����ɫclr
				disp.setForeground(clr);
				//�ı䵥�б༭��disp��ǰ��ɫΪclr
		}
	}
	public static void main(String []arg)
	{	JColorChooserDemo that=new JColorChooserDemo();
		that.go();
	}
}
