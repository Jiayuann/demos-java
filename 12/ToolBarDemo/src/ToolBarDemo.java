import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class ToolBarDemo extends JFrame{
        JTextArea textArea;                           //创建多行文本对象
        public ToolBarDemo(){                           
                  /*创建Action 对象*/
                  Action redButton = new FontColorChange("红色", Color.BLUE);
                  Action blueButton = new FontColorChange("蓝色", Color.RED);
                  Action greenButton = new FontColorChange("绿色", Color.GREEN);
                  JToolBar fontBar = new JToolBar("字体颜色",SwingConstants.HORIZONTAL);
                  fontBar.add(redButton);                   //将表示字体颜色为红色的按钮放入工具栏
                  fontBar.addSeparator();                  //添加分割线
                  fontBar.add(blueButton);                //将表示字体颜色为蓝色的按钮放入工具栏
                  fontBar.add(greenButton);              //将表示字体颜色为绿色的按钮放入工具栏
                  add(fontBar,BorderLayout.NORTH);    //将菜单栏放入到窗体中
        }
        class FontColorChange extends AbstractAction {
                 private String name = "";            //定义一个表示按钮名字变量name
                  private Color color = null;              //定义一个表示颜色变化变量color
                  public FontColorChange(String name, Color color) {
                           this.name = name;                 //按钮名称
                           this.color = color;                     //字体颜色
                           putValue(Action.NAME, name);         //获取按钮名称
                           putValue(Action.SHORT_DESCRIPTION,"字体颜色为"+name);//获取字体颜色
                  }
                  public void actionPerformed(java.awt.event.ActionEvent e) {
                           textArea.setForeground(color);        //设置字体颜色
                  }
        }
        public static void main(String[] args) {
        	ToolBarDemo tt = new ToolBarDemo ();
                  tt.setSize(250,250);                                //设置窗体位置大小
                  tt.setVisible(true);                          //设置窗体是否显示
                  tt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭的处理方式
        }
}

