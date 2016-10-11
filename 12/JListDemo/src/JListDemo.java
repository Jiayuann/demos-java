import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JListDemo implements ActionListener{
  JFrame mainJFrame;
  Container con;
  JButton addBtn,delBtn;
  JList orignList,destList;              //��������������ʾ���б�
  DefaultListModel orignModel,destModel; //�����������ӵ�ģ�Ͱ�����JList�е���Ŀ
  JScrollPane leftJSPane,rightJSPane;    //����������ڴ��JList
  JSplitPane baseSplitPane;              //�ָ����������Ĺ������
  JPanel pane;                           //��ͨ��������Ű�ť
  static final String msg[]={"����","�Ϻ�","���","����","�ӱ�","ɽ��","���ɹ�","ɽ��"};
   public JListDemo() {
     mainJFrame=new JFrame("JListʹ��ʾ��");
     con=mainJFrame.getContentPane();
     orignModel=new DefaultListModel(); 
     //����Ҫ��ʾ����Ŀ�������뵽DefaulListModel��
     for(int i=0;i<msg.length;i++)
          orignModel.addElement(msg[i]);
     //��DefaulListModel������JList���󣬽�������֮�����ϵ
     orignList=new JList(orignModel);
     destModel=new DefaultListModel();
     destList=new JList(destModel);
     //���б���ӵ����������
     leftJSPane=new JScrollPane(orignList);
     rightJSPane=new JScrollPane(destList);
     //�����������ӵ��ָ������
     baseSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftJSPane,rightJSPane);
     //�����������ӵ����ڵ��м�
     con.add(baseSplitPane,BorderLayout.CENTER);
     //���濪ʼ������ť�������ø������Ժͼ�����
     addBtn=new JButton("ѡ��>>");
     delBtn=new JButton("����<<");
     pane=new JPanel();
     pane.add(addBtn);
     pane.add(delBtn);
     addBtn.addActionListener(this);
     delBtn.addActionListener(this);
     //�������˰�ť�������ڴ��ڵ��·�
     con.add(pane,BorderLayout.SOUTH); 
     mainJFrame.setSize(300,300);
     mainJFrame.setVisible(true);
     mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //Ĭ������£��ָ������ߴ�����ռλ��̫�٣����������������
     baseSplitPane.setDividerLocation(0.5); 
   }
   //��Ӧ�û������ť�¼�
   public void actionPerformed(ActionEvent e){
     int i;
     if (e.getSource()==addBtn){ 
       //�����ѡ�����Ŀ���뵽�ұߵ�JList��
        for(i=0;i<orignModel.getSize();i++)
          if(orignList.isSelectedIndex(i)) 
            destModel.addElement(orignModel.elementAt(i));
       //����߱�ѡ�е���Ŀɾ����ע��i�ǵݼ��ģ���������ٶ�
        for(i--;i>=0;i--)
          if(orignList.isSelectedIndex(i))
            orignModel.removeElementAt(i);
     }
     //������̺������ǡ���෴�����ұ�����߼�
     else{
        for(i=0;i<destModel.getSize();i++)
          if(destList.isSelectedIndex(i)) 
             orignModel.addElement(destModel.elementAt(i));
        for(i--;i>=0;i--)
          if(destList.isSelectedIndex(i))
             destModel.removeElementAt(i);
     }
   }
   public static void main(String[] args) {
        new JListDemo();
   }
} 