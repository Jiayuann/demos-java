import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//����ʵ��ActionListener�ӿڣ��Ա������ť�¼�
public class JRadioButtonDemo implements ActionListener{
  JFrame mainJFrame;
  Container con;
  JButton OKBtn;
  JRadioButton mRadio,fRadio;
  ButtonGroup sexBtnGroup;
  JLabel msgJlabel;
  String msg;  //�������ĳ�Ա��¼�û���ѡ��
  public JRadioButtonDemo() {
    mainJFrame=new JFrame("JRadioButtonʹ��ʾ��");
    con=mainJFrame.getContentPane();
    con.setLayout(new FlowLayout());
    msgJlabel=new JLabel("��ѡ���Ա�");
    con.add(msgJlabel);
    //������ѡ��ť
    mRadio=new JRadioButton("��",true);
    //����ActionEvent�¼���������ͨ��ť����ͬһ��������
    mRadio.addActionListener(this); 
    fRadio=new JRadioButton("Ů",false);
    fRadio.addActionListener(this);
    //������ť��
    sexBtnGroup=new ButtonGroup();
    //����ѡ��ť��ӵ���ť����
    sexBtnGroup.add(mRadio);
    sexBtnGroup.add(fRadio);
    con.add(mRadio);
    con.add(fRadio);
    OKBtn=new JButton("ȷ��");
    OKBtn.addActionListener(this);
    con.add(OKBtn);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true); 
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent e){
    Object obj = e.getSource();
    //ע������������ж��������ְ�ť�����ı��¼�
    if( obj instanceof JRadioButton)
        msg=e.getActionCommand();  //����ǵ�ѡ��ť����¼�ð�ť���ı���Ϣ
    else
       JOptionPane.showMessageDialog(mainJFrame,"��ѡ����"+msg); 
  }
  public static void main(String[] args) {
      new JRadioButtonDemo();
  }
}