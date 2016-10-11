import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
public class TimerTest {
   public static void main(String[] args){
   // ����һ����ʱ�� Timer
       final Timer timer = new Timer();  
       // ����һ����ʱ������ TimerTask
       final TimerTask timerTask = new TimerTask(){
           // ����ִ�����Ρ�����֮��ȡ����ʱ��
           int count = 3;         
           @Override
           public void run() {              
               // ִ�е�����ʹ�����beep���Σ�Ȼ�����beep��¼
               Toolkit.getDefaultToolkit().beep();
               System.out.println("beep ... ");               
               // ����Ƿ��Ѿ�beep�����Ρ�����ǣ���ȡ������ʱ��
               if(--count <= 0){
                   System.out.println("timer canceled. ");                   
                   // ȡ��������
                   this.cancel();                  
                   // ȡ����ʱ��
                   timer.cancel();
               }
           }           
       };      
       // �趨��ʱ����100�����������ʱ������ÿ��1000����������һ��
       timer.schedule(timerTask, 100, 1000);              
   }
}

