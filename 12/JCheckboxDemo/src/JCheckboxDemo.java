import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;     
public class JCheckboxDemo implements ActionListener{
  JFrame mainJFrame;
  Container con;
  JButton OKBtn;
  JCheckBox box[];
  JLabel  msgJlabel;
  static final String ProvinceName[]={"����","�Ϻ�","���","����","�ӱ�","ɽ��","���ɹ�","ɽ��"};
  public JCheckboxDemo() {
    mainJFrame=new JFrame("JCheckBoxʹ��ʾ��");
    con=mainJFrame.getContentPane();
    con.setLayout(new FlowLayout());
    msgJlabel=new JLabel("������ѡ��һ����ȥ����ʡ��");
    con.add(msgJlabel);
     //���濪ʼ�����������
    box=new JCheckBox[ProvinceName.length];
    for(int i=0;i<box.length;i++){
       //����Ϊÿ��Ԫ�ش�����ѡ����󣬳�ʼ״̬Ϊ��ѡ��
       box[i]=new JCheckBox(ProvinceName[i],false);
       con.add(box[i]);
    }
    OKBtn=new JButton("ȷ��");
    OKBtn.addActionListener(this);
    con.add(OKBtn);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true);
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }
  public void actionPerformed(ActionEvent e){
    String tmpmsg="";
    int count=0;
    //�����������飬����ÿһ����ѡ�����
    for(int i=0;i<box.length;i++){
       //�ж������ѡ���Ƿ�ѡ��
       if (box[i].isSelected()){
          count++;
          tmpmsg=tmpmsg+box[i].getText()+" ";
       }
    }
    JOptionPane.showMessageDialog(mainJFrame,"��ѡ����"+count+"��ʡ��,������:\n"+tmpmsg); 
  }
  public static void main(String[] args) {
     new JCheckboxDemo();
  }
}

