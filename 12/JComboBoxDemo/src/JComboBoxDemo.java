import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JComboBoxDemo implements ItemListener,ActionListener{
  JLabel JLabel1,JLabel2;
  JFrame mainJFrame;
  Container con;
  JButton shiftBtn;
  JComboBox Jcombobox1;
  static final String msg[]={"����","�Ϻ�","���","����","�ӱ�","ɽ��","���ɹ�","ɽ��"};
  public JComboBoxDemo() {
    JLabel1=new JLabel("����ѡ���ǣ�");
    JLabel2=new JLabel("            ");
    mainJFrame=new JFrame("JComboBoxʹ��ʾ��");
    con=mainJFrame.getContentPane();
    shiftBtn=new JButton("���ɱ༭");
    shiftBtn.addActionListener(this);
    //����һ����Ͽ��б���е�������msgָ��
    Jcombobox1=new JComboBox(msg);
    //�����ı���Ϊ�ɱ༭
    Jcombobox1.setEditable(true);
    //��Ӽ�����
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
       if(shiftBtn.getText().compareTo("���ɱ༭")==0){
          shiftBtn.setText("���Ա༭");
          Jcombobox1.setEditable(false);
       }
       else{
          shiftBtn.setText("���ɱ༭");
          Jcombobox1.setEditable(true);
       } 
    }
  }
  //�����û�ѡ����Ŀ�¼�
   public void itemStateChanged(ItemEvent e){
      //��Ҫ�ж���Ŀ�Ǳ�ѡ�л��ǳ���ѡ��
      if (e.getStateChange() ==ItemEvent.SELECTED) 
        JLabel2.setText((String)Jcombobox1.getSelectedItem());
   }
   public static void main(String[] args) {
      new JComboBoxDemo();
   }
} 
