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
  //按钮事件监听器
  public class HandleAction implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String msg; 
      //如果按下确定键，显示用户名和密码
      if (e.getSource()==loginBtn){
          //用getText()获取文本框中的数据，用getPassword()获取密码框中的数据
          msg="你的用户名是:"+userText.getText()+"\n你的密码是："
                             +new String(passwordField.getPassword());
          JOptionPane.showMessageDialog(mainJFrame,msg); 
      }
      //如果按下取消键，清空文本框和密码框
      else if(e.getSource()==cancelBtn){
          passwordField.setText("");
          userText.setText("");
      }
    }
  }

  public JTextDemo() {
    handleAction=new HandleAction();
    JLabel1=new JLabel("用户名");
    JLabel2=new JLabel("密 码");
    mainJFrame=new JFrame("文本框和密码框使用示例");
    con=mainJFrame.getContentPane();
    loginBtn=new JButton("登录");
    loginBtn.addActionListener(handleAction);
    cancelBtn=new JButton("取消");
    cancelBtn.addActionListener(handleAction);
    userText=new JTextField();
    //设置文本框的宽度，这个很重要
    userText.setColumns(20); 
    passwordField=new JPasswordField();
     //设置密码框的宽度
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