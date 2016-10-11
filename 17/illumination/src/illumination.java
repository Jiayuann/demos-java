import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;
public class illumination implements ActionListener {
  JPanel palette;
  JFrame mainFrame;
  JButton startBtn;
  Container con;
  Timer   myTimer;
  Refresh task;
  boolean startFlag;
  Image img;
  int width,height;
  public illumination(String imgfile) {
     mainFrame = new JFrame("������Чʾ��");
     palette = new JPanel();
     startBtn = new JButton("��ʼ");
     startFlag = true;
     startBtn.addActionListener(this);
     con = mainFrame.getContentPane();
     con.add(palette,BorderLayout.CENTER);
     con.add(startBtn,BorderLayout.NORTH);
     mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     mainFrame.setSize(400,400);
     mainFrame.setVisible(true);
     width = palette.getWidth();
     height = palette.getHeight();
     img = Toolkit.getDefaultToolkit().createImage(imgfile);
  }
  public void actionPerformed(ActionEvent e){
     if (startFlag){
       myTimer=new Timer();
       task=new Refresh();
       //�ȴ�һ�£����û������ԭʼͼƬ
       try{
          Thread.sleep(2000);
       }catch(Exception el){}
       myTimer.schedule(task,100,100);  //������ʱ����ʱ����100����
       startBtn.setText("ֹͣ");
     }else{
       myTimer.cancel();
       myTimer = null;
       task = null;
       startBtn.setText("��ʼ");
     }  
     startFlag = !startFlag;
  } 
  public static void main(String[] args){
     if (args.length!=1){
       System.err.println("�����ʽ���������ָ��Ҫ��ʾ��ͼƬ��");
       System.err.println("���磺java illumination test.jpg");       
     }else{
       new illumination(args[0]);
     }
  }
  //����һ���ڲ�����Ϊ��ʱ�����������ƶ����
  class Refresh extends TimerTask{
     int i,j,k;   //i,j�ǹ�ߵ����꣬k�ǹ�ߵ�ǰ�ķ���
     int dx, dy;  //���ÿ���ƶ��ľ���
     int esize;   //��ߵĴ�С
     public Refresh(){
        i = (int)((Math.random() * (double)width) / 2D);
        j = (int)((Math.random() * (double)height) / 2D);
        k = (int)(Math.random() * 3D);
        dx = dy = 5;
        esize = 100;
        //��ʾԭʼͼƬ
        Graphics g = palette.getGraphics();
        g.drawImage(img, 0, 0, width, height, palette);
     }
     public void run() {
       //������Ӧ���ƶ���λ��
       switch(k){
         case 0:
           if(i < width - esize){
              i += dx;
           } else {
              k = 1;
           }
           if(j < height - esize){
              j += dy;
           } else {
              k = 3;
           }
           break;
         case 1:
           if(i > 0){
             i -= dx;
           } else {
             k = 0;
           }
           if(j < height - esize) {
             j += dy;
           } else {
             k = 2;
           }
           break;
         case 2:
           if(i > 0){
             i -= dx;
           } else {
             k = 3;
           }
           if(j > 0) {
             j -= dx;
           } else {
             k = 1;
           }
           break;
         case  3:
           if(i < width - esize){
             i += dx;
           } else {
             k = 2;
           }
           if(j > 0){
             j -= dy;
           } else {
             k = 0;
           }
           break;
       }
       //���λ�ü�����ϣ��ڵ�ǰλ�û���ͼƬ�ֲ�
       replace(i, j); 
     }
     //��ָ��λ����ʾͼƬ
     public void replace(int i, int j) {
        Graphics g = palette.getGraphics();
        //�����ɫ��䣬����ڰ�Ч��
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, width, height);
        //���òü�����
        g.setClip(new Ellipse2D.Float(i,j, esize, esize));
        //�ڲü������л��ͼ��
        g.drawImage(img, 0, 0, width, height, palette);
        //�ָ�ȫ�ֻ滭
        g.setClip(null);
    }
  }//�ڲ������  
}