import java.io.*;
import javax.swing.filechooser.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class JFileChooserDemo 
{	JTextArea jbl=new JTextArea();
	JScrollPane jsp=new JScrollPane();
	JPanel jp=new JPanel();
	JButton open=new JButton("打开");
	JButton save=new JButton("保存");
	JButton ret=new JButton("返回");
	public void go()
	{	JFrame jf=new JFrame("文件处理");
		jf.getContentPane().add("Center",jsp);
        jsp.getViewport().add(jbl);
		jf.getContentPane().add("North",jp);
		jp.add(open);
		jp.add(save);
		jp.add(ret);
		save.addActionListener(new Select('s'));
		open.addActionListener(new Select('o'));
		ret.addActionListener(new Select('r'));
		Font newf=new Font("TimesRoman",Font.PLAIN,24);
		jbl.setFont(newf);
        open.setFont(newf);
        save.setFont(newf);
        ret.setFont(newf);
		jf.setSize(250,250);
		jf.setVisible(true);
	}
	public class Select implements ActionListener
	{	private char isselect;
		String fname;
		JFileChooser jfc;
		//定义一个文件对话框jfc
        File sf;
		public Select(char ch)
		{	isselect=ch;
		}
		public void actionPerformed(ActionEvent e)
		{	if(isselect=='r') System.exit(1);
			//若是返回按钮，则结束程序运行
			switch(isselect)
			{	case 'o':
				//若是“打开”按钮
					jfc = new JFileChooser("c:/");
					//文件对话框的缺省目录为C:\
   					jfc.showOpenDialog(null);
					//显示打开文件对话框
					sf=jfc.getSelectedFile();
					//获得所选择的文件名
					fname=sf.getAbsolutePath();
					//获得含绝对路径的文件名
					String resl="";
					try{
						FileReader fr=new FileReader(fname);
						//以读方式打开文件，并将文件内容读到resl中
						int rd;
						rd=fr.read();
						while(rd!=-1)
						{	resl=resl+(char)rd;
							rd=fr.read();
						}
					}catch(IOException e1){};
					jbl.setText(resl);
					//在多行编辑框中显示文件内容resl
					break;
				case 's':
				//若是“保存”按钮
					jfc = new JFileChooser("c:/");
    				jfc.showSaveDialog(null);
					//显示保存文件对话框
					sf=jfc.getSelectedFile();
					fname=sf.getAbsolutePath(); 
					try{
						FileWriter fw=new FileWriter(fname);
						//以写方式打开文件，并将多行编辑框中内容写到文件中
						String sw;
						sw=jbl.getText();
						fw.write(sw);
						fw.close();
					}catch(IOException e2){};
					break;
			}
		}
	}
	public static void main(String args[])
	{	JFileChooserDemo sft=new JFileChooserDemo();
		sft.go();
	}
}
