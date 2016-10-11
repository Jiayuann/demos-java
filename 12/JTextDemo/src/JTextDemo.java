import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JTextDemo {
  JLabel JLabel1,JLabel2;
  JFrame mainJFrame;
  Container con;
  JButton loginBtn,cancelBtn;
  JTextField userText;
  JPasswordField passwordField;
  HandleAction handleAction;
  //��ť�¼�������
  public class HandleAction implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String msg; 
      //�������ȷ��������ʾ�û���������
      if (e.getSource()==loginBtn){
          //��getText()��ȡ�ı����е����ݣ���getPassword()��ȡ������е�����
          msg="����û�����:"+userText.getText()+"\n��������ǣ�"
                             +new String(passwordField.getPassword());
          JOptionPane.showMessageDialog(mainJFrame,msg); 
      }
      //�������ȡ����������ı���������
      else if(e.getSource()==cancelBtn){
          passwordField.setText("");
          userText.setText("");
      }
    }
  }

  public JTextDemo() {
    handleAction=new HandleAction();
    JLabel1=new JLabel("�û���");
    JLabel2=new JLabel("�� ��");
    mainJFrame=new JFrame("�ı���������ʹ��ʾ��");
    con=mainJFrame.getContentPane();
    loginBtn=new JButton("��¼");
    loginBtn.addActionListener(handleAction);
    cancelBtn=new JButton("ȡ��");
    cancelBtn.addActionListener(handleAction);
    userText=new JTextField();
    //�����ı���Ŀ�ȣ��������Ҫ
    userText.setColumns(20); 
    passwordField=new JPasswordField();
     //���������Ŀ��
    passwordField.setColumns(20);
    con.setLayout(new FlowLayout());
    con.add(JLabel1);
    con.add(userText);
    con.add(JLabel2);
    con.add(passwordField);
    con.add(loginBtn);
    con.add(cancelBtn);
    mainJFrame.setSize(250,250);
    mainJFrame.setVisible(true); 
    mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

   public static void main(String[] args) {
     new JTextDemo();
   }
}