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
     String[] Names={"姓名","语文","数学","总分","及格"};
     //创建带内容和表头信息的表格
     DataTable=new JTable(playerInfo,Names);
     JSPane=new JScrollPane(DataTable);
     mainJFrame.add(JSPane);
     mainJFrame.setTitle("JTable使用示例");
     mainJFrame.setSize(300,200);
     mainJFrame.setVisible(true);
     mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public static void main(String[] args) {
      new JTableDemo();
   }
}