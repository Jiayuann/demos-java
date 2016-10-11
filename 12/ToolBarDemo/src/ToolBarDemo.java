import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class ToolBarDemo extends JFrame{
        JTextArea textArea;                           //���������ı�����
        public ToolBarDemo(){                           
                  /*����Action ����*/
                  Action redButton = new FontColorChange("��ɫ", Color.BLUE);
                  Action blueButton = new FontColorChange("��ɫ", Color.RED);
                  Action greenButton = new FontColorChange("��ɫ", Color.GREEN);
                  JToolBar fontBar = new JToolBar("������ɫ",SwingConstants.HORIZONTAL);
                  fontBar.add(redButton);                   //����ʾ������ɫΪ��ɫ�İ�ť���빤����
                  fontBar.addSeparator();                  //��ӷָ���
                  fontBar.add(blueButton);                //����ʾ������ɫΪ��ɫ�İ�ť���빤����
                  fontBar.add(greenButton);              //����ʾ������ɫΪ��ɫ�İ�ť���빤����
                  add(fontBar,BorderLayout.NORTH);    //���˵������뵽������
        }
        class FontColorChange extends AbstractAction {
                 private String name = "";            //����һ����ʾ��ť���ֱ���name
                  private Color color = null;              //����һ����ʾ��ɫ�仯����color
                  public FontColorChange(String name, Color color) {
                           this.name = name;                 //��ť����
                           this.color = color;                     //������ɫ
                           putValue(Action.NAME, name);         //��ȡ��ť����
                           putValue(Action.SHORT_DESCRIPTION,"������ɫΪ"+name);//��ȡ������ɫ
                  }
                  public void actionPerformed(java.awt.event.ActionEvent e) {
                           textArea.setForeground(color);        //����������ɫ
                  }
        }
        public static void main(String[] args) {
        	ToolBarDemo tt = new ToolBarDemo ();
                  tt.setSize(250,250);                                //���ô���λ�ô�С
                  tt.setVisible(true);                          //���ô����Ƿ���ʾ
                  tt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���رյĴ���ʽ
        }
}

