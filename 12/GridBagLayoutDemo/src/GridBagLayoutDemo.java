import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo {
   Container con;
   JFrame mainJframe;
   GridBagLayout gridbag;
   //按照指定的属性创建并添加按钮到单元格中
   private void makebutton(String name, 
                           GridBagLayout gridbag, GridBagConstraints c) {
      JButton btn = new JButton(name);
      //参数c决定了如何放置这个按钮
      gridbag.setConstraints(btn, c);
      con.add(btn);
   }

   public GridBagLayoutDemo(){
      GridBagConstraints c = new GridBagConstraints();
      gridbag = new GridBagLayout();
      mainJframe=new JFrame("网格包布局使用示例");
      con=mainJframe.getContentPane();
      con.setLayout(gridbag);
      c.fill = GridBagConstraints.BOTH;
      //下面每个按钮占一行一列
      c.weightx = 1.0;
      makebutton("Button1", gridbag, c);
      makebutton("Button2", gridbag, c);
      makebutton("Button3", gridbag, c);      
      c.gridwidth = GridBagConstraints.REMAINDER; //占据到本行结束
      makebutton("Button4", gridbag, c);
      //开始布置第二行的按钮
      c.weightx = 0.0; //重设为默认值
      //这里的gridwidth属性仍然是REMAINDER，所以占据一整行
      makebutton("Button5", gridbag, c);
      //开始布置第三行
      c.gridwidth = GridBagConstraints.RELATIVE; //重起一行，占三格
      makebutton("Button6", gridbag, c);
      c.gridwidth = GridBagConstraints.REMAINDER; //占据到本行结束
      makebutton("Button7", gridbag, c);
      //开始布置第四行和第五行
      c.gridwidth = 1; //本单元格占两行一列
      c.gridheight = 2;
      c.weighty = 1.0;
      makebutton("Button8", gridbag, c);
      //开始布置其他的按钮，它们分在两行中
      c.weighty = 0.0; 
      c.gridwidth = GridBagConstraints.REMAINDER; //占据到本行结束
      c.gridheight = 1; //只占一行
      makebutton("Button9", gridbag, c);
      makebutton("Button10", gridbag, c);
      //布局设置完毕
      mainJframe.setSize(400,180);
      mainJframe.setVisible(true);
      mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String[] args) {
      new GridBagLayoutDemo();
   }
}