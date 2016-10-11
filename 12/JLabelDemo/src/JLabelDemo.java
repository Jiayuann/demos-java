import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JLabelDemo {
  JLabel linkLabel;
  JFrame mainJFrame;
  Container con;
  ListenMouse listenmouse;
  //这个内部类用于监听鼠标事件
  public class ListenMouse extends MouseAdapter{
    //当鼠标移动到标签上时
    public void mouseEntered(MouseEvent e){ 
      //改变标签上鼠标的形状，变成手的形状
      linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    } 
  }
  public JLabelDemo() {
    listenmouse=new ListenMouse();
    mainJFrame=new JFrame("图像标签使用示例");
    con=mainJFrame.getContentPane();
    linkLabel=new JLabel("把鼠标移到我这，将变成手的形状");
    //将标签放上方
    con.add(linkLabel,BorderLayout.NORTH);
    //添加鼠标监听器
    linkLabel.addMouseListener(listenmouse);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true);
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }
  public static void main(String[] args) {
    new JLabelDemo();
  }
} 
