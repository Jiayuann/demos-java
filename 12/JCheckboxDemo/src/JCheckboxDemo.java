import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;     
public class JCheckboxDemo implements ActionListener{
  JFrame mainJFrame;
  Container con;
  JButton OKBtn;
  JCheckBox box[];
  JLabel  msgJlabel;
  static final String ProvinceName[]={"北京","上海","天津","重庆","河北","山西","内蒙古","山东"};
  public JCheckboxDemo() {
    mainJFrame=new JFrame("JCheckBox使用示例");
    con=mainJFrame.getContentPane();
    con.setLayout(new FlowLayout());
    msgJlabel=new JLabel("请至少选择一个你去过的省份");
    con.add(msgJlabel);
     //下面开始创建组件数组
    box=new JCheckBox[ProvinceName.length];
    for(int i=0;i<box.length;i++){
       //依次为每个元素创建复选框对象，初始状态为不选择
       box[i]=new JCheckBox(ProvinceName[i],false);
       con.add(box[i]);
    }
    OKBtn=new JButton("确定");
    OKBtn.addActionListener(this);
    con.add(OKBtn);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true);
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }
  public void actionPerformed(ActionEvent e){
    String tmpmsg="";
    int count=0;
    //遍历整个数组，访问每一个复选框组件
    for(int i=0;i<box.length;i++){
       //判断这个复选框是否被选中
       if (box[i].isSelected()){
          count++;
          tmpmsg=tmpmsg+box[i].getText()+" ";
       }
    }
    JOptionPane.showMessageDialog(mainJFrame,"你选择了"+count+"个省份,它们是:\n"+tmpmsg); 
  }
  public static void main(String[] args) {
     new JCheckboxDemo();
  }
}

