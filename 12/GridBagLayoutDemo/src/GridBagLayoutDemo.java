import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo {
   Container con;
   JFrame mainJframe;
   GridBagLayout gridbag;
   //����ָ�������Դ�������Ӱ�ť����Ԫ����
   private void makebutton(String name, 
                           GridBagLayout gridbag, GridBagConstraints c) {
      JButton btn = new JButton(name);
      //����c��������η��������ť
      gridbag.setConstraints(btn, c);
      con.add(btn);
   }

   public GridBagLayoutDemo(){
      GridBagConstraints c = new GridBagConstraints();
      gridbag = new GridBagLayout();
      mainJframe=new JFrame("���������ʹ��ʾ��");
      con=mainJframe.getContentPane();
      con.setLayout(gridbag);
      c.fill = GridBagConstraints.BOTH;
      //����ÿ����ťռһ��һ��
      c.weightx = 1.0;
      makebutton("Button1", gridbag, c);
      makebutton("Button2", gridbag, c);
      makebutton("Button3", gridbag, c);      
      c.gridwidth = GridBagConstraints.REMAINDER; //ռ�ݵ����н���
      makebutton("Button4", gridbag, c);
      //��ʼ���õڶ��еİ�ť
      c.weightx = 0.0; //����ΪĬ��ֵ
      //�����gridwidth������Ȼ��REMAINDER������ռ��һ����
      makebutton("Button5", gridbag, c);
      //��ʼ���õ�����
      c.gridwidth = GridBagConstraints.RELATIVE; //����һ�У�ռ����
      makebutton("Button6", gridbag, c);
      c.gridwidth = GridBagConstraints.REMAINDER; //ռ�ݵ����н���
      makebutton("Button7", gridbag, c);
      //��ʼ���õ����к͵�����
      c.gridwidth = 1; //����Ԫ��ռ����һ��
      c.gridheight = 2;
      c.weighty = 1.0;
      makebutton("Button8", gridbag, c);
      //��ʼ���������İ�ť�����Ƿ���������
      c.weighty = 0.0; 
      c.gridwidth = GridBagConstraints.REMAINDER; //ռ�ݵ����н���
      c.gridheight = 1; //ֻռһ��
      makebutton("Button9", gridbag, c);
      makebutton("Button10", gridbag, c);
      //�����������
      mainJframe.setSize(400,180);
      mainJframe.setVisible(true);
      mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String[] args) {
      new GridBagLayoutDemo();
   }
}