 import javax.swing.*;
  public class JProgressBarDemo extends JFrame
  {
          JProgressBar progress=new JProgressBar();      //创建，并初始化JProgressBar类型progress
         int count=0;                                                                           //声明整型变量count
         //创建内部类Task，设置滚动条的值
          class Task extends java.util.TimerTask
          {
          //覆盖TimerTask的run方法
             public void run()
              {
                  progress.setValue(count++);     //执行的时候为JProgressBar赋值
              }
          }
         //声明JProgressBarDemo类的构造方法
          public JProgressBarDemo()
          {
             progress.setStringPainted(true);    //指定显示百分比
             this.getContentPane().add(progress,"North");       //获取内容面板，并添加进度条progress
              Task task=new Task();                                      //创建，并初始化Task对象
             java.util.Timer timer=new java.util.Timer();  //创建，并初始化Timer对象timer
             timer.schedule(task,100,100);                         //安排指定时间执行，重复执行任务
              this.setSize(500,100);              //设置窗口的大小
             this.setVisible(true);                 //显示窗口
             //设置窗口关闭窗口，自动隐藏并释放窗口
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
         }
         public void excute(){  
          }
         public static void main(String[] args)
         {
            JProgressBarDemo p=new JProgressBarDemo();//创建，并初始化JProgressBarDemo对象p
         }
 }


