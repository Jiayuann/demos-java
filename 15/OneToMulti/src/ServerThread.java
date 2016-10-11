//���ñ��߳�����ɷ�������ͻ��˵�ͨ�Ź���
import java.io.*;
import java.net.*;
public class ServerThread extends Thread{
  private Socket connectToClient;
  private DataInputStream inFromClient;
  private DataOutputStream outToClient;
  //�ڹ��췽����Ϊÿ���׽�����������������
  public ServerThread(Socket socket) throws IOException{
     super();
     connectToClient=socket;
     inFromClient=new DataInputStream(
                              connectToClient.getInputStream());
     outToClient=new DataOutputStream(
                              connectToClient.getOutputStream());
     start(); //����run()����
  }
  //��run()��������ͻ���ͨ�� 
  public void run() {
     try{ 
         String str;
         double radius,area;
         boolean goon=true;
         while(goon){
            str=inFromClient.readUTF();
            if(!str.equals("bye")){
               radius=Double.parseDouble(str);
               System.out.println("���յ��İ뾶ֵΪ��"+radius);
               area=radius*radius*Math.PI;
               str=Double.toString(area);
               outToClient.writeUTF(str);
               outToClient.flush();
               System.out.println("Բ���"+str+"�Ѿ�����"); 
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