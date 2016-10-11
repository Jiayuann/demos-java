import java.io.*;
import java.net.*;
public class InterNameAndAddr{
   public static void main(String[] args){
try{//  调用 InetAddress类中的方法会抛出异常，故进行捕获处理
	InetAddress ind = InetAddress.getLocalHost();//  通过计算机名获得IP地址，并将其转换成字符串输出
     System.out.println("主机的名称和IP地址为："+ind.toString());
     String strName=ind.getHostName();//  通过IP地址获得计算机名称
     System.out.println("主机名称："+strName);
    } catch(Exception e){
     System.out.println("发生异常！");
    }
  }
}
