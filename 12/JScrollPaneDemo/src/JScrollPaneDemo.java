import javax.swing.*;
public class JScrollPaneDemo {
  JScrollPane myJspane;
  JLabel myJlbl;
  JFrame myJFrame;
  public JScrollPaneDemo() {
   myJFrame=new JFrame("JScrollPaneʹ��ʾ��");
   //����һ��ͼƬ�ļ�
   Icon picture = new ImageIcon("test.jpg");
   myJlbl=new JLabel(picture);
   //���������
   myJspane=new JScrollPane();
   //�������Ĳ��ַ�ʽ
   myJspane.setLayout(new ScrollPaneLayout()); 
    //��������ӱ�ǩ
   myJspane.getViewport().add(myJlbl);  
   myJFrame.add(myJspane);
   myJFrame.setSize(300,300);
   myJFrame.setVisible(true);
   myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public static void main(String[] args) {
    new JScrollPaneDemo();
  }
}