import java.awt.*;
import javax.swing.*;

public class JMenuDemo {
  JFrame mainJFrame;
  Container con;
  JScrollPane JSPane; 
  JTextArea text;
  JMenuBar mainMenuBar;
  JMenu fileMenu,editMenu,formatMenu,helpMenu;
  //“文件”菜单下的菜单项
  JMenuItem newItem,openItem,saveItem, saveasItem,pageItem,printItem,exitItem;
  //“编辑”菜单下的菜单项
  JMenuItem undoItem,cutItem,copyItem,pasteItem,findItem,replaceItem,selectallItem;
  //“设置”菜单下的菜单项
  JCheckBoxMenuItem wrapItem;
  JMenuItem fontItem;
  //“帮助”菜单下的菜单项
  JMenuItem helpItem,aboutItem;
  public JMenuDemo() {
     mainJFrame=new JFrame("菜单使用示例");
     con=mainJFrame.getContentPane();
     text=new JTextArea();
     JSPane=new JScrollPane(text);
     //调用自定义的方法创建菜单结构
     createMenu();
     //添加菜单到窗口
     mainJFrame.setJMenuBar(mainMenuBar);
     con.add(JSPane,BorderLayout.CENTER);
     mainJFrame.setSize(300,300);
     mainJFrame.setVisible(true); 
     mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void createMenu(){  
     mainMenuBar=new JMenuBar();//创建JMenuBar    
     fileMenu=new JMenu("文件");//创建四个JMenu
     editMenu=new JMenu("编辑");
     formatMenu=new JMenu("格式");
     helpMenu=new JMenu("帮助");   
     mainMenuBar.add(fileMenu);//创建JMenuItem并添加到对应的JMenu中
     newItem=new JMenuItem("新建"); //创建文件菜单下面的菜单项
     openItem=new JMenuItem("打开..");
     saveItem=new JMenuItem("保存..");
     saveasItem=new JMenuItem("另存为..");
     pageItem=new JMenuItem("页面设置..");
     printItem=new JMenuItem("打印..");
     exitItem=new JMenuItem("退出");
     fileMenu.add(newItem); 
     fileMenu.add(openItem);
     fileMenu.add(saveItem);
     fileMenu.add(saveasItem);
     fileMenu.addSeparator();
     fileMenu.add(pageItem);
     fileMenu.add(printItem);
     fileMenu.addSeparator();
     fileMenu.add(exitItem);
     
     mainMenuBar.add(editMenu);//创建编辑菜单下面的菜单项
     undoItem=new JMenuItem("撤消");
     cutItem=new JMenuItem("剪切");
     copyItem=new JMenuItem("复制");
     pasteItem=new JMenuItem("粘贴");
     findItem=new JMenuItem("查找..");
     replaceItem=new JMenuItem("替换..");
     selectallItem=new JMenuItem("全选");
     editMenu.add(undoItem);
     editMenu.addSeparator();
     editMenu.add(cutItem);
     editMenu.add(copyItem);
     editMenu.add(pasteItem);
     editMenu.addSeparator();
     editMenu.add(findItem);
     editMenu.add(replaceItem);
     editMenu.addSeparator();
     editMenu.add(selectallItem);
     
     mainMenuBar.add(formatMenu);//创建格式菜单下面的菜单项
     wrapItem=new JCheckBoxMenuItem("自动换行");
     fontItem=new JMenuItem("设置字体..");
     formatMenu.add(wrapItem);
     formatMenu.add(fontItem);   
   }    
   public static void main(String[] args) {
      new JMenuDemo();
   }
}