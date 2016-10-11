import javax.swing.*;
public class JScrollPaneDemo {
  JScrollPane myJspane;
  JLabel myJlbl;
  JFrame myJFrame;
  public JScrollPaneDemo() {
   myJFrame=new JFrame("JScrollPane使用示例");
   //加载一个图片文件
   Icon picture = new ImageIcon("test.jpg");
   myJlbl=new JLabel(picture);
   //创建空面板
   myJspane=new JScrollPane();
   //设置面板的布局方式
   myJspane.setLayout(new ScrollPaneLayout()); 
    //向其中添加标签
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