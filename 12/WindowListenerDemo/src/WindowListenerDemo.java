import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class WindowListenerDemo extends JFrame {  
   public WindowListenerDemo(){      
       this.setTitle("WindowEvent");      
       final JTextArea textArea = new JTextArea();
       this.add(new JScrollPane(textArea));
       WindowListener l = new WindowListener(){          
           public void windowActivated(WindowEvent e) {
               textArea.append("���ڻ�ý���. \r\n");
               // ������Լ��򿪵��ļ��Ƿ��������޸Ĺ���������޸���ʾ�Ƿ����������ļ�
           }
           public void windowClosed(WindowEvent e) {
               // �رմ���ʱ���У���� textArea �п���������־
               textArea.append("�����˳�... \r\n");
               System.out.println("�����˳�... ");
           }
           public void windowClosing(WindowEvent e) {
               textArea.append("�����رմ���. \r\n");
               int result = JOptionPane.showConfirmDialog(null, "�����رմ��ڣ��Ƿ������");
               if(result == JOptionPane.YES_OPTION){
                   // �رմ���
                   dispose();
               }
           }
           public void windowDeactivated(WindowEvent e) {
               textArea.append("����ʧȥ����. \r\n");
           }
           public void windowDeiconified(WindowEvent e) {
               textArea.append("���ڴ���С���ָ�. \r\n");
           }
           public void windowIconified(WindowEvent e) {
               textArea.append("������С��. \r\n");
           }
           public void windowOpened(WindowEvent e) {
               textArea.append("���´���. \r\n");
           }
       };
       this.addWindowListener(l);
       this.setSize(300, 400);
       // �������ùر�ʱʲôҲ����
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       this.setVisible(true);      
   }
   public static void main(String[] args) {
	   new WindowListenerDemo();
   }
}

