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
     mainJFrame=new JFrame("JTree使用示例");
     con=mainJFrame.getContentPane();
     msgLabel=new JLabel();  
     root=new DefaultMutableTreeNode("Option");//创建根节点    
     tmpNode=new DefaultMutableTreeNode("A");//创建根节点的第一个孩子节点
     root.add(tmpNode); //将这个孩子节点添加进来
     tmpNode.add(new DefaultMutableTreeNode("a1")); //为这个孩子节点添加两个子节点
     tmpNode.add(new DefaultMutableTreeNode("a2"));
     tmpNode=new DefaultMutableTreeNode("B");//创建根节点的第二个孩子节点  
     root.add(tmpNode);   //添加进来   
     tmpNode.add(new DefaultMutableTreeNode("b1")); //为这个孩子节点添加四个子节点
     tmpNode.add(new DefaultMutableTreeNode("b2"));
     tmpNode.add(new DefaultMutableTreeNode("b3"));
     tmpNode.add(new DefaultMutableTreeNode("b4"));    
     simpleTree=new JTree(root); //以root为根，创建树
     JSPane=new JScrollPane(simpleTree);
     simpleTree.addTreeSelectionListener(this);
     con.add(JSPane,BorderLayout.CENTER);
     con.add(msgLabel,BorderLayout.SOUTH);
     mainJFrame.setSize(250,250);
     mainJFrame.setVisible(true);
   mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
   public void valueChanged(TreeSelectionEvent e){ //在标签上显示用户选择的节点
     msgLabel.setText(e.getPath().toString());
   }
   public static void main(String[] args) {
     new JTreeDemo();
   }
}