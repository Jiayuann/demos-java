import java.io.*;
import java.net.*;
public class InterNameAndAddr{
   public static void main(String[] args){
try{//  ���� InetAddress���еķ������׳��쳣���ʽ��в�����
	InetAddress ind = InetAddress.getLocalHost();//  ͨ������������IP��ַ��������ת�����ַ������
     System.out.println("���������ƺ�IP��ַΪ��"+ind.toString());
     String strName=ind.getHostName();//  ͨ��IP��ַ��ü��������
     System.out.println("�������ƣ�"+strName);
    } catch(Exception e){
     System.out.println("�����쳣��");
    }
  }
}
