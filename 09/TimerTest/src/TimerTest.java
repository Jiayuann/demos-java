import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
public class TimerTest {
   public static void main(String[] args){
   // 声明一个计时器 Timer
       final Timer timer = new Timer();  
       // 声明一个计时器任务 TimerTask
       final TimerTask timerTask = new TimerTask(){
           // 任务执行三次。三次之后取消计时器
           int count = 3;         
           @Override
           public void run() {              
               // 执行的任务：使计算机beep三次，然后输出beep记录
               Toolkit.getDefaultToolkit().beep();
               System.out.println("beep ... ");               
               // 检查是否已经beep了三次。如果是，则取消掉计时器
               if(--count <= 0){
                   System.out.println("timer canceled. ");                   
                   // 取消该任务
                   this.cancel();                  
                   // 取消定时器
                   timer.cancel();
               }
           }           
       };      
       // 设定计时器。100毫秒后启动计时器任务，每隔1000毫秒再启动一次
       timer.schedule(timerTask, 100, 1000);              
   }
}

