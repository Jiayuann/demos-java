import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JButtonDemo implements ActionListener{
  JButton shiftBtn;
  JFrame mainJFrame;
  Container con;
  ImageIcon closeIcon,openIcon;
  public JButtonDemo() {
    mainJFrame=new JFrame("图像按钮使用示例");
    closeIcon=new ImageIcon("close.jpg");
    openIcon=new ImageIcon("open.jpg");
    con=mainJFrame.getContentPane();
  // 用下面的方法创建一个带图片的按钮，图片可以是GIF或JPG格式
    shiftBtn=new JButton("打开",openIcon);
    con.add(shiftBtn,BorderLayout.NORTH);
    shiftBtn.addActionListener(this);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true);
  mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent e){
    if (e.getSource()==shiftBtn){
      //判断当前按钮是显示的文字，并根据文字做出相应的动作
      if(shiftBtn.getText().compareTo("打开")==0){
         shiftBtn.setText("关闭");//设置文字
         shiftBtn.setIcon(closeIcon);//设置图片
      }
      else{
         shiftBtn.setText("打开");
         shiftBtn.setIcon(openIcon);
      } 
   }
  }
  public static void main(String[] args) {
     new JButtonDemo();
  }
}