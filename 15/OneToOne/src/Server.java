//这是服务器程序
import java.io.*;
import java.net.*;
public class Server {
   public static void main(String[] args) {
     try{
        System.out.println("等待连接");
        //创建服务端套接字
        ServerSocket serverSocket=new ServerSocket(5500);
        //侦听来自客户端的连接请求
        Socket connectToClient=serverSocket.accept();
        System.out.println("连接请求来自"+
                           connectToClient.getInetAddress().getHostAddress());
        DataInputStream inFromClient=new DataInputStream(
                           connectToClient.getInputStream());
        DataOutputStream outToClient=new DataOutputStream(
                           connectToClient.getOutputStream());
        String str;
        double radius,area;
        boolean goon=true;
        while(goon){
           //从socket中读取数据
           str=inFromClient.readUTF();
           if(!str.equals("bye")){
               radius=Double.parseDouble(str);
               System.out.println("接收到的半径值为："+radius);
               area=radius*radius*Math.PI;
               str=Double.toString(area);
               //向socket中写数据
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
       serverSocket.close();
    }catch(IOException e){
       e.printStackTrace();
    }
  } 
}