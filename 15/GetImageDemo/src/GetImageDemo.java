import java.applet.*;
import java.awt.*;
import java.net.*;
public class GetImageDemo extends Applet {
        Button button;
        Image img;
        URL url;
        public void init() {
                  try {
                	  url = new URL("http://image.baidu.com/i?ct=503316480&z=&tn=baiduimagedetail&word=%E9%BE%99%E7%8C%AB&ie=utf-8&in=6311&cl=2&lm=-1&st=&pn=120&rn=1&di=306275795300&ln=1989&fr=&fm=&fmq=1354165516161_R&ic=&s=&se=&sme=0&tab=&width=&height=&face=&is=&istype=#pn148&-1&di116019521150&objURLhttp%3A%2F%2Fwww.ctvcc.com%2Fupload_files%2Fvedio%2Fstill%2F04longmao.jpg&fromURLhttp%3A%2F%2Fwww.ctvcc.com%2Fvedio%2Fsm%2Fshow%2Fid%2F96&W420&H325&T8464&S44&TPjpg");               //建立URL对象，需要异常处理
                           img = getImage(url);                                                                                    //获取远程图像
                  } catch (MalformedURLException e) {
                           e.printStackTrace();
                  }
        }
        public void paint(Graphics g) {
                  g.drawString("下面的图片地址为：", 0, 20);                                             //输出字符串
                  g.drawString(url.toExternalForm(), 0, 40);
                  g.drawImage(img, 0, 50, this);                                                                   //输出远程图像
        }
}
