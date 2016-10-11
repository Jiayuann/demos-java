import javax.swing.*;

public class JTextAreaDemo {
  JFrame mainJFrame;
  JScrollPane JSpane;
  JTextArea JEdit;
  
  public JTextAreaDemo() {
    mainJFrame=new JFrame("JTextArea使用示例");
    //创建一个空白文本区
    JEdit=new JTextArea();
    //将它添加到滚动面板中
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