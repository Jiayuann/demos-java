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
     mainFrame = new JFrame("光照特效示例");
     palette = new JPanel();
     startBtn = new JButton("开始");
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
       //等待一下，让用户看清楚原始图片
       try{
          Thread.sleep(2000);
       }catch(Exception el){}
       myTimer.schedule(task,100,100);  //启动定时器，时间间隔100毫秒
       startBtn.setText("停止");
     }else{
       myTimer.cancel();
       myTimer = null;
       task = null;
       startBtn.setText("开始");
     }  
     startFlag = !startFlag;
  } 
  public static void main(String[] args){
     if (args.length!=1){
       System.err.println("命令格式错误，你必须指定要显示的图片。");
       System.err.println("例如：java illumination test.jpg");       
     }else{
       new illumination(args[0]);
     }
  }
  //定义一个内部类作为定时器，用它来移动光斑
  class Refresh extends TimerTask{
     int i,j,k;   //i,j是光斑的坐标，k是光斑当前的方向
     int dx, dy;  //光斑每次移动的距离
     int esize;   //光斑的大小
     public Refresh(){
        i = (int)((Math.random() * (double)width) / 2D);
        j = (int)((Math.random() * (double)height) / 2D);
        k = (int)(Math.random() * 3D);
        dx = dy = 5;
        esize = 100;
        //显示原始图片
        Graphics g = palette.getGraphics();
        g.drawImage(img, 0, 0, width, height, palette);
     }
     public void run() {
       //计算光斑应该移动的位置
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
       //光斑位置计算完毕，在当前位置画出图片局部
       replace(i, j); 
     }
     //在指定位置显示图片
     public void replace(int i, int j) {
        Graphics g = palette.getGraphics();
        //用深灰色填充，造出黑暗效果
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, width, height);
        //设置裁剪区域
        g.setClip(new Ellipse2D.Float(i,j, esize, esize));
        //在裁剪区域中绘出图像
        g.drawImage(img, 0, 0, width, height, palette);
        //恢复全局绘画
        g.setClip(null);
    }
  }//内部类结束  
}