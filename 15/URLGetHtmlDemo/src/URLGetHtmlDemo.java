import java.net.*;
import java.io.*;
public class URLGetHtmlDemo {
        public static void main(String args[]) {
                  URL url = null;
                  try {
                           url = new URL("http://www.baidu.com");                                            //初始化url对象
                  } catch (MalformedURLException e) {
                           e.printStackTrace();
                  }
                  try {
                           InputStream input = url.openStream();                                           //得到数据输入流
                           BufferedReader reader = new BufferedReader(new InputStreamReader(
                                              input));

                           String info = reader.readLine();                                                                 //读入数据
                           while (info != null) {
                                    System.out.println(info);                                                           //输出结果至屏幕
                                    info = reader.readLine();                                                          //读取一行
                           }
                  } catch (IOException e) {

                           e.printStackTrace();
                  }
        }
}

