import java.awt.FlowLayout;
import javax.swing.*;

public class JDialogDemo {
  JFrame mainJFrame;
  JLabel myJLabel;
  JDialog subDialog;
  public JDialogDemo() {
    mainJFrame=new JFrame("���Ի����JFrame��ʾ����");
    myJLabel=new JLabel("Hello,World!");
    //�����Ի���
    subDialog=new JDialog(mainJFrame,"����һ���Ի���"); 
    subDialog.getContentPane().setLayout(new FlowLayout());
    subDialog.getContentPane().add(myJLabel);
    mainJFrame.setSize(200,200);
    mainJFrame.setVisible(true);
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    subDialog.setSize(200,200);
    subDialog.setVisible(true);
  }

  public static void main(String[] args) {
    new JDialogDemo();
  }
}