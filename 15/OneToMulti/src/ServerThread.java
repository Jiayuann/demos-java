//利用本线程来完成服务器与客户端的通信工作
import java.io.*;
import java.net.*;
public class ServerThread extends Thread{
  private Socket connectToClient;
  private DataInputStream inFromClient;
  private DataOutputStream outToClient;
  //在构造方法中为每个套接字连接输入和输出流
  public ServerThread(Socket socket) throws IOException{
     super();
     connectToClient=socket;
     inFromClient=new DataInputStream(
                              connectToClient.getInputStream());
     outToClient=new DataOutputStream(
                              connectToClient.getOutputStream());
     start(); //启动run()方法
  }
  //在run()方法中与客户端通信 
  public void run() {
     try{ 
         String str;
         double radius,area;
         boolean goon=true;
         while(goon){
            str=inFromClient.readUTF();
            if(!str.equals("bye")){
               radius=Double.parseDouble(str);
               System.out.println("接收到的半径值为："+radius);
               area=radius*radius*Math.PI;
               str=Double.toString(area);
               outToClient.writeUTF(str);
               outToClient.flush();
               System.out.println("圆面积"+str+"已经发送"); 
            }else{
               goon=false;
               outToClient.writeUTF("bye");
               outToClient.flush();
            }
         }
         inFromClient.close();
         outToClient.close();
         connectToClient.close();
      }catch(IOException e){
          e.printStackTrace();
      }
   }
}