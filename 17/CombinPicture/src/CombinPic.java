import javax.swing.*;
import java.awt.*;
public class CombinPic{
  JFrame mainFrame;
  CombinerCanvas palette;
  JScrollPane spane;
  public CombinPic(Image fore, Image back, float alpha){
    mainFrame=new JFrame("ˮӡͼƬʾ��");
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
       System.err.println("���ø�ʽ���ԣ�Ӧ���ǣ�java CombinPic ǰ��ͼƬ�� ����ͼƬ��");
       System.err.println("���ߣ�java CombinPic ǰ��ͼƬ�� ����ͼƬ�� ͸����");
       System.err.println("͸���ȵ�ֵ��0.0-1.0��ֵԽС��ˮӡԽ��");
       System.err.println("��Ϊˮӡ��ͼƬ����Ǳ���͸����gifͼƬ");
       System.err.println("���磺java CombinPic myPic.jpg back.gif 0.1");
       return ;
    }
    Image fore = Toolkit.getDefaultToolkit().createImage(args[0]);
    Image back = Toolkit.getDefaultToolkit().createImage(args[1]);
    if (fore == null){
       System.err.println("��һ���ļ����ǿ���ʶ���ͼƬ");
       return ;
    }
    if (back == null){
       System.err.println("�ڶ����ļ����ǿ���ʶ���ͼƬ");
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