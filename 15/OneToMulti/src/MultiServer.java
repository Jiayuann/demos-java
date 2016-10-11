//这是主程序，它只要简单地启动线程就可以了
import java.io.*;
import java.net.*;
public class MultiServer {
   public static void main(String[] args) {
      try{ 
         System.out.println("等待连接");
         ServerSocket serverSocket=new ServerSocket(5500);
         Socket connectToClient=null;
         while (true){  //这是一个无限循环
            //等待客户端的请求
            connectToClient=serverSocket.accept();
            //每次请求都启动一个线程来处理
            new ServerThread(connectToClient);
         }
      }catch(IOException e){
         e.printStackTrace();
      }
   }
}