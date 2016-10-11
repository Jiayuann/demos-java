import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
public class JTreeDemo implements TreeSelectionListener{
   JFrame mainJFrame;
   Container con;
   JLabel msgLabel;
   JScrollPane JSPane; 
   JTree simpleTree;
   private DefaultMutableTreeNode tmpNode,root; 
   public JTreeDemo() {
     mainJFrame=new JFrame("JTreeʹ��ʾ��");
     con=mainJFrame.getContentPane();
     msgLabel=new JLabel();  
     root=new DefaultMutableTreeNode("Option");//�������ڵ�    
     tmpNode=new DefaultMutableTreeNode("A");//�������ڵ�ĵ�һ�����ӽڵ�
     root.add(tmpNode); //��������ӽڵ���ӽ���
     tmpNode.add(new DefaultMutableTreeNode("a1")); //Ϊ������ӽڵ���������ӽڵ�
     tmpNode.add(new DefaultMutableTreeNode("a2"));
     tmpNode=new DefaultMutableTreeNode("B");//�������ڵ�ĵڶ������ӽڵ�  
     root.add(tmpNode);   //��ӽ���   
     tmpNode.add(new DefaultMutableTreeNode("b1")); //Ϊ������ӽڵ�����ĸ��ӽڵ�
     tmpNode.add(new DefaultMutableTreeNode("b2"));
     tmpNode.add(new DefaultMutableTreeNode("b3"));
     tmpNode.add(new DefaultMutableTreeNode("b4"));    
     simpleTree=new JTree(root); //��rootΪ����������
     JSPane=new JScrollPane(simpleTree);
     simpleTree.addTreeSelectionListener(this);
     con.add(JSPane,BorderLayout.CENTER);
     con.add(msgLabel,BorderLayout.SOUTH);
     mainJFrame.setSize(250,250);
     mainJFrame.setVisible(true);
   mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
   public void valueChanged(TreeSelectionEvent e){ //�ڱ�ǩ����ʾ�û�ѡ��Ľڵ�
     msgLabel.setText(e.getPath().toString());
   }
   public static void main(String[] args) {
     new JTreeDemo();
   }
}