import javax.swing.*;
import java.awt.*;
public class JTableDemo{
   JFrame mainJFrame;
   Container con;
   JScrollPane JSPane;
   JTable DataTable;
   public JTableDemo(){
     mainJFrame = new JFrame();
     Object[][] playerInfo={
        {"Lester",new Integer(85),new Integer(58),new Integer(133),new Boolean(false)},
        {"limo",new Integer(82),new Integer(80),new Integer(162),new Boolean(true)},
     };
     String[] Names={"����","����","��ѧ","�ܷ�","����"};
     //���������ݺͱ�ͷ��Ϣ�ı��
     DataTable=new JTable(playerInfo,Names);
     JSPane=new JScrollPane(DataTable);
     mainJFrame.add(JSPane);
     mainJFrame.setTitle("JTableʹ��ʾ��");
     mainJFrame.setSize(300,200);
     mainJFrame.setVisible(true);
     mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public static void main(String[] args) {
      new JTableDemo();
   }
}