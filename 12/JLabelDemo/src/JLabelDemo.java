import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JLabelDemo {
  JLabel linkLabel;
  JFrame mainJFrame;
  Container con;
  ListenMouse listenmouse;
  //����ڲ������ڼ�������¼�
  public class ListenMouse extends MouseAdapter{
    //������ƶ�����ǩ��ʱ
    public void mouseEntered(MouseEvent e){ 
      //�ı��ǩ��������״������ֵ���״
      linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    } 
  }
  public JLabelDemo() {
    listenmouse=new ListenMouse();
    mainJFrame=new JFrame("ͼ���ǩʹ��ʾ��");
    con=mainJFrame.getContentPane();
    linkLabel=new JLabel("������Ƶ����⣬������ֵ���״");
    //����ǩ���Ϸ�
    con.add(linkLabel,BorderLayout.NORTH);
    //�����������
    linkLabel.addMouseListener(listenmouse);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true);
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }
  public static void main(String[] args) {
    new JLabelDemo();
  }
} 
