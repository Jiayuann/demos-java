import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JButtonDemo implements ActionListener{
  JButton shiftBtn;
  JFrame mainJFrame;
  Container con;
  ImageIcon closeIcon,openIcon;
  public JButtonDemo() {
    mainJFrame=new JFrame("ͼ��ťʹ��ʾ��");
    closeIcon=new ImageIcon("close.jpg");
    openIcon=new ImageIcon("open.jpg");
    con=mainJFrame.getContentPane();
  // ������ķ�������һ����ͼƬ�İ�ť��ͼƬ������GIF��JPG��ʽ
    shiftBtn=new JButton("��",openIcon);
    con.add(shiftBtn,BorderLayout.NORTH);
    shiftBtn.addActionListener(this);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true);
  mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent e){
    if (e.getSource()==shiftBtn){
      //�жϵ�ǰ��ť����ʾ�����֣�����������������Ӧ�Ķ���
      if(shiftBtn.getText().compareTo("��")==0){
         shiftBtn.setText("�ر�");//��������
         shiftBtn.setIcon(closeIcon);//����ͼƬ
      }
      else{
         shiftBtn.setText("��");
         shiftBtn.setIcon(openIcon);
      } 
   }
  }
  public static void main(String[] args) {
     new JButtonDemo();
  }
}