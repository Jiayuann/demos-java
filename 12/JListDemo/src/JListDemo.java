import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JListDemo implements ActionListener{
  JFrame mainJFrame;
  Container con;
  JButton addBtn,delBtn;
  JList orignList,destList;              //这是两个用于显示的列表
  DefaultListModel orignModel,destModel; //这两个不可视的模型包含了JList中的条目
  JScrollPane leftJSPane,rightJSPane;    //滚动面板用于存放JList
  JSplitPane baseSplitPane;              //分割面板存放上面的滚动面板
  JPanel pane;                           //普通面板用来放按钮
  static final String msg[]={"北京","上海","天津","重庆","河北","山西","内蒙古","山东"};
   public JListDemo() {
     mainJFrame=new JFrame("JList使用示例");
     con=mainJFrame.getContentPane();
     orignModel=new DefaultListModel(); 
     //将需要显示的条目逐条加入到DefaulListModel中
     for(int i=0;i<msg.length;i++)
          orignModel.addElement(msg[i]);
     //用DefaulListModel来创建JList对象，建立二者之间的联系
     orignList=new JList(orignModel);
     destModel=new DefaultListModel();
     destList=new JList(destModel);
     //将列表添加到滚动面板中
     leftJSPane=new JScrollPane(orignList);
     rightJSPane=new JScrollPane(destList);
     //将滚动面板添加到分割面板中
     baseSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftJSPane,rightJSPane);
     //将滚动面板添加到窗口的中间
     con.add(baseSplitPane,BorderLayout.CENTER);
     //下面开始创建按钮，并设置各种属性和监听器
     addBtn=new JButton("选中>>");
     delBtn=new JButton("撤消<<");
     pane=new JPanel();
     pane.add(addBtn);
     pane.add(delBtn);
     addBtn.addActionListener(this);
     delBtn.addActionListener(this);
     //将放置了按钮的面板放在窗口的下方
     con.add(pane,BorderLayout.SOUTH); 
     mainJFrame.setSize(300,300);
     mainJFrame.setVisible(true);
     mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //默认情况下，分隔面板左边窗口所占位置太少，用这个方法来调整
     baseSplitPane.setDividerLocation(0.5); 
   }
   //响应用户点击按钮事件
   public void actionPerformed(ActionEvent e){
     int i;
     if (e.getSource()==addBtn){ 
       //将左边选择的条目加入到右边的JList中
        for(i=0;i<orignModel.getSize();i++)
          if(orignList.isSelectedIndex(i)) 
            destModel.addElement(orignModel.elementAt(i));
       //将左边被选中的条目删除，注意i是递减的，可以提高速度
        for(i--;i>=0;i--)
          if(orignList.isSelectedIndex(i))
            orignModel.removeElementAt(i);
     }
     //这个过程和上面的恰好相反，从右边往左边加
     else{
        for(i=0;i<destModel.getSize();i++)
          if(destList.isSelectedIndex(i)) 
             orignModel.addElement(destModel.elementAt(i));
        for(i--;i>=0;i--)
          if(destList.isSelectedIndex(i))
             destModel.removeElementAt(i);
     }
   }
   public static void main(String[] args) {
        new JListDemo();
   }
} 