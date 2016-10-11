//这是客户端程序
import java.io.*;
import java.net.*;

public class Client {
 public static void main(String[] args) {
  try{
    //连接到本机，端口号5500 
     Socket connectToServer=new Socket("localhost",5500);
     //将数据输入流连接到socket上
     DataInputStream inFromServer=new DataInputStream(connectToServer.getInputStream());
     //将数据输出流连接到socket上
     DataOutputStream outToServer=new DataOutputStream(connectToServer.getOutputStream());
     System.out.println("输入半径数值发送到服务器，输入bye结束。");
     String outStr,inStr;
     boolean goon=true;
     BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
     //反复读用户的数据并计算
     while(goon){ 
        outStr=buf.readLine();        //读入用户的输入
        outToServer.writeUTF(outStr); //写到socket中
        outToServer.flush();          //清空缓冲区，立即发送
        inStr=inFromServer.readUTF(); //从socket中读数据
        if(!inStr.equals("bye"))
           System.out.println("从服务器返回的结果是"+inStr);
        else 
           goon=false;
     }
     inFromServer.close();
     outToServer.close();
     connectToServer.close();
  }catch(IOException e){
      e.printStackTrace();
  }
 }
}