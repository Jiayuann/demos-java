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
               textArea.append("窗口获得焦点. \r\n");
               // 这里可以检查打开的文件是否被外界程序修改过，如果被修改提示是否重新载入文件
           }
           public void windowClosed(WindowEvent e) {
               // 关闭窗口时运行，因此 textArea 中看不到该日志
               textArea.append("窗口退出... \r\n");
               System.out.println("窗口退出... ");
           }
           public void windowClosing(WindowEvent e) {
               textArea.append("即将关闭窗口. \r\n");
               int result = JOptionPane.showConfirmDialog(null, "即将关闭窗口，是否继续？");
               if(result == JOptionPane.YES_OPTION){
                   // 关闭窗口
                   dispose();
               }
           }
           public void windowDeactivated(WindowEvent e) {
               textArea.append("窗口失去焦点. \r\n");
           }
           public void windowDeiconified(WindowEvent e) {
               textArea.append("窗口从最小化恢复. \r\n");
           }
           public void windowIconified(WindowEvent e) {
               textArea.append("窗口最小化. \r\n");
           }
           public void windowOpened(WindowEvent e) {
               textArea.append("打开新窗口. \r\n");
           }
       };
       this.addWindowListener(l);
       this.setSize(300, 400);
       // 这里设置关闭时什么也不做
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       this.setVisible(true);      
   }
   public static void main(String[] args) {
	   new WindowListenerDemo();
   }
}

