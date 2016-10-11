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
      mainJframe=new JFrame("��Ƭ����ʹ��ʾ��");
      con=mainJframe.getContentPane();
      myCard=new CardLayout();
      con.setLayout(myCard);
     //Ϊ��һ�ſ�Ƭ������
      Label1=new JLabel("���ǵ�һ��");
      nextBtn1=new JButton("��һ��");
      panel1=new JPanel();
      panel1.add(Label1);
      panel1.add(nextBtn1);
      con.add("first",panel1);
     //Ϊ�ڶ��ſ�Ƭ������
      Label2=new JLabel("���ǵڶ���");
      prevBtn1=new JButton("��һ��");
      nextBtn2=new JButton("��һ��");
      panel2=new JPanel();
      panel2.add(Label2);
      panel2.add(prevBtn1);
      panel2.add(nextBtn2);
      con.add("second",panel2);
     //Ϊ�����ſ�Ƭ������
      Label3=new JLabel("���ǵ�����");
      prevBtn2=new JButton("��һ��");
      OKBtn=new JButton("���");
      panel3=new JPanel();
      panel3.add(Label3);
      panel3.add(prevBtn2);
      panel3.add(OKBtn); 
      con.add("third",panel3);
     //����¼������� 
      nextBtn1.addActionListener(this); 
      prevBtn1.addActionListener(this);
      nextBtn2.addActionListener(this);
      prevBtn2.addActionListener(this);
      OKBtn.addActionListener(this);
      mainJframe.setSize(250,250);
      mainJframe.setVisible(true);
      mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   //�����û�����İ�ť��ʾ����Ŀ�Ƭ
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