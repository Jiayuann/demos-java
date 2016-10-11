import java.awt.*;
import javax.swing.*;

public class JMenuDemo {
  JFrame mainJFrame;
  Container con;
  JScrollPane JSPane; 
  JTextArea text;
  JMenuBar mainMenuBar;
  JMenu fileMenu,editMenu,formatMenu,helpMenu;
  //���ļ����˵��µĲ˵���
  JMenuItem newItem,openItem,saveItem, saveasItem,pageItem,printItem,exitItem;
  //���༭���˵��µĲ˵���
  JMenuItem undoItem,cutItem,copyItem,pasteItem,findItem,replaceItem,selectallItem;
  //�����á��˵��µĲ˵���
  JCheckBoxMenuItem wrapItem;
  JMenuItem fontItem;
  //���������˵��µĲ˵���
  JMenuItem helpItem,aboutItem;
  public JMenuDemo() {
     mainJFrame=new JFrame("�˵�ʹ��ʾ��");
     con=mainJFrame.getContentPane();
     text=new JTextArea();
     JSPane=new JScrollPane(text);
     //�����Զ���ķ��������˵��ṹ
     createMenu();
     //��Ӳ˵�������
     mainJFrame.setJMenuBar(mainMenuBar);
     con.add(JSPane,BorderLayout.CENTER);
     mainJFrame.setSize(300,300);
     mainJFrame.setVisible(true); 
     mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void createMenu(){  
     mainMenuBar=new JMenuBar();//����JMenuBar    
     fileMenu=new JMenu("�ļ�");//�����ĸ�JMenu
     editMenu=new JMenu("�༭");
     formatMenu=new JMenu("��ʽ");
     helpMenu=new JMenu("����");   
     mainMenuBar.add(fileMenu);//����JMenuItem����ӵ���Ӧ��JMenu��
     newItem=new JMenuItem("�½�"); //�����ļ��˵�����Ĳ˵���
     openItem=new JMenuItem("��..");
     saveItem=new JMenuItem("����..");
     saveasItem=new JMenuItem("���Ϊ..");
     pageItem=new JMenuItem("ҳ������..");
     printItem=new JMenuItem("��ӡ..");
     exitItem=new JMenuItem("�˳�");
     fileMenu.add(newItem); 
     fileMenu.add(openItem);
     fileMenu.add(saveItem);
     fileMenu.add(saveasItem);
     fileMenu.addSeparator();
     fileMenu.add(pageItem);
     fileMenu.add(printItem);
     fileMenu.addSeparator();
     fileMenu.add(exitItem);
     
     mainMenuBar.add(editMenu);//�����༭�˵�����Ĳ˵���
     undoItem=new JMenuItem("����");
     cutItem=new JMenuItem("����");
     copyItem=new JMenuItem("����");
     pasteItem=new JMenuItem("ճ��");
     findItem=new JMenuItem("����..");
     replaceItem=new JMenuItem("�滻..");
     selectallItem=new JMenuItem("ȫѡ");
     editMenu.add(undoItem);
     editMenu.addSeparator();
     editMenu.add(cutItem);
     editMenu.add(copyItem);
     editMenu.add(pasteItem);
     editMenu.addSeparator();
     editMenu.add(findItem);
     editMenu.add(replaceItem);
     editMenu.addSeparator();
     editMenu.add(selectallItem);
     
     mainMenuBar.add(formatMenu);//������ʽ�˵�����Ĳ˵���
     wrapItem=new JCheckBoxMenuItem("�Զ�����");
     fontItem=new JMenuItem("��������..");
     formatMenu.add(wrapItem);
     formatMenu.add(fontItem);   
   }    
   public static void main(String[] args) {
      new JMenuDemo();
   }
}