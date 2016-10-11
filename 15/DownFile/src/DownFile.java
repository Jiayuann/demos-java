import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class DownFile implements ActionListener{
  JLabel msgLbl;
  JTextField urlText;
  JButton btn;
  Container con;
  JFrame mainJframe;

  public DownFile() {
     mainJframe=new JFrame("我的浏览器");
     con=mainJframe.getContentPane();
     msgLbl=new JLabel("请输入要下载的文件地址和名称");
     urlText=new JTextField();
     urlText.setColumns(15);
     btn=new JButton("下载");
     btn.addActionListener(this);
     con.setLayout(new FlowLayout());
     con.add(msgLbl);
     con.add(urlText);
     con.add(btn);
     mainJframe.setSize(300,300);
     mainJframe.setVisible(true);
     mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
     new DownFile();
  }

  public void actionPerformed(ActionEvent e) {
     try{
        URL url=new URL(urlText.getText());
        //创建远程连接
        URLConnection connect=url.openConnection();
        //创建输入流
        BufferedReader buf=new BufferedReader(
                         new InputStreamReader(connect.getInputStream()));
        //创建输出流
        BufferedWriter file=new BufferedWriter(new FileWriter("temp.dat"));
        int ch;
        //复制文件
        while((ch=buf.read())!=-1){
           file.write(ch);
        }
        buf.close();
        file.close();
        JOptionPane.showMessageDialog(mainJframe,"下载成功");
     }catch(MalformedURLException el){
        System.out.println(el.toString());
     }catch(IOException el){
        JOptionPane.showMessageDialog(mainJframe,"连接错误");
     }
  }
}