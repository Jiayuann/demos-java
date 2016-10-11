import java.awt.FlowLayout;
import javax.swing.*;

public class JDialogDemo {
  JFrame mainJFrame;
  JLabel myJLabel;
  JDialog subDialog;
  public JDialogDemo() {
    mainJFrame=new JFrame("带对话框的JFrame演示窗口");
    myJLabel=new JLabel("Hello,World!");
    //创建对话框
    subDialog=new JDialog(mainJFrame,"这是一个对话框"); 
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