//������������ֻҪ�򵥵������߳̾Ϳ�����
import java.io.*;
import java.net.*;
public class MultiServer {
   public static void main(String[] args) {
      try{ 
         System.out.println("�ȴ�����");
         ServerSocket serverSocket=new ServerSocket(5500);
         Socket connectToClient=null;
         while (true){  //����һ������ѭ��
            //�ȴ��ͻ��˵�����
            connectToClient=serverSocket.accept();
            //ÿ����������һ���߳�������
            new ServerThread(connectToClient);
         }
      }catch(IOException e){
         e.printStackTrace();
      }
   }
}