 import javax.swing.*;
  public class JProgressBarDemo extends JFrame
  {
          JProgressBar progress=new JProgressBar();      //����������ʼ��JProgressBar����progress
         int count=0;                                                                           //�������ͱ���count
         //�����ڲ���Task�����ù�������ֵ
          class Task extends java.util.TimerTask
          {
          //����TimerTask��run����
             public void run()
              {
                  progress.setValue(count++);     //ִ�е�ʱ��ΪJProgressBar��ֵ
              }
          }
         //����JProgressBarDemo��Ĺ��췽��
          public JProgressBarDemo()
          {
             progress.setStringPainted(true);    //ָ����ʾ�ٷֱ�
             this.getContentPane().add(progress,"North");       //��ȡ������壬����ӽ�����progress
              Task task=new Task();                                      //����������ʼ��Task����
             java.util.Timer timer=new java.util.Timer();  //����������ʼ��Timer����timer
             timer.schedule(task,100,100);                         //����ָ��ʱ��ִ�У��ظ�ִ������
              this.setSize(500,100);              //���ô��ڵĴ�С
             this.setVisible(true);                 //��ʾ����
             //���ô��ڹرմ��ڣ��Զ����ز��ͷŴ���
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
         }
         public void excute(){  
          }
         public static void main(String[] args)
         {
            JProgressBarDemo p=new JProgressBarDemo();//����������ʼ��JProgressBarDemo����p
         }
 }


