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
     mainJframe=new JFrame("�ҵ������");
     con=mainJframe.getContentPane();
     msgLbl=new JLabel("������Ҫ���ص��ļ���ַ������");
     urlText=new JTextField();
     urlText.setColumns(15);
     btn=new JButton("����");
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
        //����Զ������
        URLConnection connect=url.openConnection();
        //����������
        BufferedReader buf=new BufferedReader(
                         new InputStreamReader(connect.getInputStream()));
        //���������
        BufferedWriter file=new BufferedWriter(new FileWriter("temp.dat"));
        int ch;
        //�����ļ�
        while((ch=buf.read())!=-1){
           file.write(ch);
        }
        buf.close();
        file.close();
        JOptionPane.showMessageDialog(mainJframe,"���سɹ�");
     }catch(MalformedURLException el){
        System.out.println(el.toString());
     }catch(IOException el){
        JOptionPane.showMessageDialog(mainJframe,"���Ӵ���");
     }
  }
}