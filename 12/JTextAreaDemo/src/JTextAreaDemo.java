import javax.swing.*;

public class JTextAreaDemo {
  JFrame mainJFrame;
  JScrollPane JSpane;
  JTextArea JEdit;
  
  public JTextAreaDemo() {
    mainJFrame=new JFrame("JTextAreaʹ��ʾ��");
    //����һ���հ��ı���
    JEdit=new JTextArea();
    //������ӵ����������
    JSpane=new JScrollPane(JEdit);
    mainJFrame.add(JSpane);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true); 
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new JTextAreaDemo();
  }
}