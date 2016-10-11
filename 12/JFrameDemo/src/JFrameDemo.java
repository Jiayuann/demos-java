import javax.swing.*;
import java.awt.*;  //布局在此包中
public class JFrameDemo {
  JFrame mainJFrame;
  JLabel myJLabel;
  public  JFrameDemo() {
    mainJFrame=new JFrame("JFrame演示窗口");
    myJLabel=new JLabel("Hello World!");
    try {
	 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	} catch(Exception e) { 
	  System.err.println(e.toString());
	}
    //设置流式布局
    mainJFrame.getContentPane().setLayout(new FlowLayout());
    //注意这种添加组件的方法，需要把组件加在中间容器上
    mainJFrame.getContentPane().add(myJLabel);  
    mainJFrame.setSize(200,200);
    mainJFrame.setVisible(true);
    //设置关闭窗口时退出JVM
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new JFrameDemo();
  }
}