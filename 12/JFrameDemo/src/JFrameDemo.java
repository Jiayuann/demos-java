import javax.swing.*;
import java.awt.*;  //�����ڴ˰���
public class JFrameDemo {
  JFrame mainJFrame;
  JLabel myJLabel;
  public  JFrameDemo() {
    mainJFrame=new JFrame("JFrame��ʾ����");
    myJLabel=new JLabel("Hello World!");
    try {
	 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	} catch(Exception e) { 
	  System.err.println(e.toString());
	}
    //������ʽ����
    mainJFrame.getContentPane().setLayout(new FlowLayout());
    //ע�������������ķ�������Ҫ����������м�������
    mainJFrame.getContentPane().add(myJLabel);  
    mainJFrame.setSize(200,200);
    mainJFrame.setVisible(true);
    //���ùرմ���ʱ�˳�JVM
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new JFrameDemo();
  }
}