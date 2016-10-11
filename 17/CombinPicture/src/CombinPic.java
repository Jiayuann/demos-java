import javax.swing.*;
import java.awt.*;
public class CombinPic{
  JFrame mainFrame;
  CombinerCanvas palette;
  JScrollPane spane;
  public CombinPic(Image fore, Image back, float alpha){
    mainFrame=new JFrame("水印图片示例");
    palette=new CombinerCanvas(fore,back,alpha);
    spane = new JScrollPane(palette);
    mainFrame.add(spane,BorderLayout.CENTER);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(400,400);
    mainFrame.setVisible(true);
    try{
      Thread.sleep(1000);
      palette.repaint();
    }catch(Exception el){
    }
  }
  public static void main(String[] args) {
    if (args.length<2 || args.length>3){
       System.err.println("调用格式不对，应该是：java CombinPic 前景图片名 背景图片名");
       System.err.println("或者：java CombinPic 前景图片名 背景图片名 透明度");
       System.err.println("透明度的值从0.0-1.0，值越小，水印越淡");
       System.err.println("作为水印的图片最好是背景透明的gif图片");
       System.err.println("例如：java CombinPic myPic.jpg back.gif 0.1");
       return ;
    }
    Image fore = Toolkit.getDefaultToolkit().createImage(args[0]);
    Image back = Toolkit.getDefaultToolkit().createImage(args[1]);
    if (fore == null){
       System.err.println("第一个文件不是可以识别的图片");
       return ;
    }
    if (back == null){
       System.err.println("第二个文件不是可以识别的图片");
       return ;
    }  
    if (args.length==2)
      new CombinPic(fore,back,0.1f);
    else{
      float alpha = Float.parseFloat(args[2]);
      new CombinPic(fore,back,alpha);
    }  
  }
}