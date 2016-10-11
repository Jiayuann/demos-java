import javax.swing.*;
import java.awt.*;
//import java.awt.geom.*;
public class CombinerCanvas extends JPanel {
  private Image foreImg = null, backImg = null;
  private float _alpha = 1.0f;
  public CombinerCanvas(Image forePic, Image backPic, float alpha){
     foreImg = forePic;
     backImg = backPic;
     _alpha = alpha;
  }
  //创建一个指定alpha值的AlphaComposite对象
  private AlphaComposite makeComposite(float alpha) {
    int type = AlphaComposite.SRC_OVER;
    return(AlphaComposite.getInstance(type, alpha));
  }
  //用指定的alpha值来绘制前景和背景图片
  private void combinImage(Graphics2D g2d) {
    Composite originalComposite = g2d.getComposite();
    //用默认透明度绘制前景图片
    g2d.drawImage(foreImg,0,0,this);
    //设置透明度，准备绘制水印图片
    g2d.setComposite(makeComposite(_alpha));
    g2d.drawImage(backImg,0,0,this);
    //将透明度设置回默认的模式
    g2d.setComposite(originalComposite);
  }
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      combinImage((Graphics2D)g);
  }
}