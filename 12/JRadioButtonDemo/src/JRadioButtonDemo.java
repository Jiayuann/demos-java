import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//本类实现ActionListener接口，以便监听按钮事件
public class JRadioButtonDemo implements ActionListener{
  JFrame mainJFrame;
  Container con;
  JButton OKBtn;
  JRadioButton mRadio,fRadio;
  ButtonGroup sexBtnGroup;
  JLabel msgJlabel;
  String msg;  //用这个类的成员记录用户的选择
  public JRadioButtonDemo() {
    mainJFrame=new JFrame("JRadioButton使用示例");
    con=mainJFrame.getContentPane();
    con.setLayout(new FlowLayout());
    msgJlabel=new JLabel("请选择性别");
    con.add(msgJlabel);
    //创建单选按钮
    mRadio=new JRadioButton("男",true);
    //监听ActionEvent事件，它和普通按钮共用同一个监听器
    mRadio.addActionListener(this); 
    fRadio=new JRadioButton("女",false);
    fRadio.addActionListener(this);
    //创建按钮组
    sexBtnGroup=new ButtonGroup();
    //将单选按钮添加到按钮组中
    sexBtnGroup.add(mRadio);
    sexBtnGroup.add(fRadio);
    con.add(mRadio);
    con.add(fRadio);
    OKBtn=new JButton("确定");
    OKBtn.addActionListener(this);
    con.add(OKBtn);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true); 
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent e){
    Object obj = e.getSource();
    //注意这个方法，判断是由哪种按钮产生的本事件
    if( obj instanceof JRadioButton)
        msg=e.getActionCommand();  //如果是单选按钮，记录该按钮的文本信息
    else
       JOptionPane.showMessageDialog(mainJFrame,"你选择了"+msg); 
  }
  public static void main(String[] args) {
      new JRadioButtonDemo();
  }
}