//���ǿͻ��˳���
import java.io.*;
import java.net.*;

public class Client {
 public static void main(String[] args) {
  try{
    //���ӵ��������˿ں�5500 
     Socket connectToServer=new Socket("localhost",5500);
     //���������������ӵ�socket��
     DataInputStream inFromServer=new DataInputStream(connectToServer.getInputStream());
     //��������������ӵ�socket��
     DataOutputStream outToServer=new DataOutputStream(connectToServer.getOutputStream());
     System.out.println("����뾶��ֵ���͵�������������bye������");
     String outStr,inStr;
     boolean goon=true;
     BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
     //�������û������ݲ�����
     while(goon){ 
        outStr=buf.readLine();        //�����û�������
        outToServer.writeUTF(outStr); //д��socket��
        outToServer.flush();          //��ջ���������������
        inStr=inFromServer.readUTF(); //��socket�ж�����
        if(!inStr.equals("bye"))
           System.out.println("�ӷ��������صĽ����"+inStr);
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