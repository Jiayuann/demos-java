import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CardLayoutDemo implements ActionListener{
   Container con;
   JFrame mainJframe;
   JLabel Label1,Label2,Label3;
   JButton nextBtn1,prevBtn1,nextBtn2,prevBtn2,OKBtn;
   CardLayout myCard;
   JPanel panel1,panel2,panel3;
   public CardLayoutDemo() {
      mainJframe=new JFrame("卡片布局使用示例");
      con=mainJframe.getContentPane();
      myCard=new CardLayout();
      con.setLayout(myCard);
     //为第一张卡片添加组件
      Label1=new JLabel("这是第一步");
      nextBtn1=new JButton("下一步");
      panel1=new JPanel();
      panel1.add(Label1);
      panel1.add(nextBtn1);
      con.add("first",panel1);
     //为第二张卡片添加组件
      Label2=new JLabel("这是第二步");
      prevBtn1=new JButton("上一步");
      nextBtn2=new JButton("下一步");
      panel2=new JPanel();
      panel2.add(Label2);
      panel2.add(prevBtn1);
      panel2.add(nextBtn2);
      con.add("second",panel2);
     //为第三张卡片添加组件
      Label3=new JLabel("这是第三步");
      prevBtn2=new JButton("上一步");
      OKBtn=new JButton("完成");
      panel3=new JPanel();
      panel3.add(Label3);
      panel3.add(prevBtn2);
      panel3.add(OKBtn); 
      con.add("third",panel3);
     //添加事件监听器 
      nextBtn1.addActionListener(this); 
      prevBtn1.addActionListener(this);
      nextBtn2.addActionListener(this);
      prevBtn2.addActionListener(this);
      OKBtn.addActionListener(this);
      mainJframe.setSize(250,250);
      mainJframe.setVisible(true);
      mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   //根据用户点击的按钮显示所需的卡片
   public void actionPerformed(ActionEvent e){
      Object tp;
      tp=e.getSource();
      if (tp==nextBtn1 || tp==nextBtn2) myCard.next(con);
      if (tp==prevBtn1 || tp==prevBtn2) myCard.previous(con);
      if (tp==OKBtn)                    mainJframe.dispose(); 
   }
   public static void main(String[] args) {
      new CardLayoutDemo();
   }
}