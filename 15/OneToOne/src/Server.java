//���Ƿ���������
import java.io.*;
import java.net.*;
public class Server {
   public static void main(String[] args) {
     try{
        System.out.println("�ȴ�����");
        //����������׽���
        ServerSocket serverSocket=new ServerSocket(5500);
        //�������Կͻ��˵���������
        Socket connectToClient=serverSocket.accept();
        System.out.println("������������"+
                           connectToClient.getInetAddress().getHostAddress());
        DataInputStream inFromClient=new DataInputStream(
                           connectToClient.getInputStream());
        DataOutputStream outToClient=new DataOutputStream(
                           connectToClient.getOutputStream());
        String str;
        double radius,area;
        boolean goon=true;
        while(goon){
           //��socket�ж�ȡ����
           str=inFromClient.readUTF();
           if(!str.equals("bye")){
               radius=Double.parseDouble(str);
               System.out.println("���յ��İ뾶ֵΪ��"+radius);
               area=radius*radius*Math.PI;
               str=Double.toString(area);
               //��socket��д����
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
       serverSocket.close();
    }catch(IOException e){
       e.printStackTrace();
    }
  } 
}