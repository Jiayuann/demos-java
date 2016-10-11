import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JComboBoxDemo implements ItemListener,ActionListener{
  JLabel JLabel1,JLabel2;
  JFrame mainJFrame;
  Container con;
  JButton shiftBtn;
  JComboBox Jcombobox1;
  static final String msg[]={"北京","上海","天津","重庆","河北","山西","内蒙古","山东"};
  public JComboBoxDemo() {
    JLabel1=new JLabel("您的选择是：");
    JLabel2=new JLabel("            ");
    mainJFrame=new JFrame("JComboBox使用示例");
    con=mainJFrame.getContentPane();
    shiftBtn=new JButton("不可编辑");
    shiftBtn.addActionListener(this);
    //创建一个组合框，列表框中的内容由msg指定
    Jcombobox1=new JComboBox(msg);
    //设置文本框为可编辑
    Jcombobox1.setEditable(true);
    //添加监听器
    Jcombobox1.addItemListener(this);
    con.setLayout(new FlowLayout());
    con.add(JLabel1);
    con.add(JLabel2);
    con.add(Jcombobox1);
    con.add(shiftBtn);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true); 
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent e){
    if (e.getSource()==shiftBtn){
       if(shiftBtn.getText().compareTo("不可编辑")==0){
          shiftBtn.setText("可以编辑");
          Jcombobox1.setEditable(false);
       }
       else{
          shiftBtn.setText("不可编辑");
          Jcombobox1.setEditable(true);
       } 
    }
  }
  //监听用户选择条目事件
   public void itemStateChanged(ItemEvent e){
      //需要判断条目是被选中还是撤销选中
      if (e.getStateChange() ==ItemEvent.SELECTED) 
        JLabel2.setText((String)Jcombobox1.getSelectedItem());
   }
   public static void main(String[] args) {
      new JComboBoxDemo();
   }
} 
