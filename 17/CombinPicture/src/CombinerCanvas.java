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
  //����һ��ָ��alphaֵ��AlphaComposite����
  private AlphaComposite makeComposite(float alpha) {
    int type = AlphaComposite.SRC_OVER;
    return(AlphaComposite.getInstance(type, alpha));
  }
  //��ָ����alphaֵ������ǰ���ͱ���ͼƬ
  private void combinImage(Graphics2D g2d) {
    Composite originalComposite = g2d.getComposite();
    //��Ĭ��͸���Ȼ���ǰ��ͼƬ
    g2d.drawImage(foreImg,0,0,this);
    //����͸���ȣ�׼������ˮӡͼƬ
    g2d.setComposite(makeComposite(_alpha));
    g2d.drawImage(backImg,0,0,this);
    //��͸�������û�Ĭ�ϵ�ģʽ
    g2d.setComposite(originalComposite);
  }
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      combinImage((Graphics2D)g);
  }
}