import java.util.*;
import java.io.*;
public class demoHashMap{
  public static void main(String args[]){
    //����һ���ؼ���ΪString���͡���¼ΪInteger���͵Ĺ�ϣ��
    HashMap<String,Integer> stu = new HashMap<String,Integer>();
    Scanner in = new Scanner(System.in); //׼���Ӽ�������
    String name;
    Integer score;
    System.out.println("����������ѧ�������ͳɼ������б�ʾ����");
    boolean goon = true;
    
    while(goon){  //ѭ������ѧ�������ͳɼ�
       System.out.print("������������");
       name = in.nextLine();
       if (name.length()>0){
         System.out.print("������ɼ���");
         score = new Integer(in.nextLine());     		
         stu.put(name,score);	//���뵽��ϣ����
       } 
       else
          goon=false;
    }
    System.out.println("������Ҫ���ҵ�ѧ�����������б�ʾ����");
    goon=true;
    while(goon){
       name = in.nextLine();
       if (name.length()>0){
          score=stu.get(name);  //����ָ��ѧ��
          if(score!=null)	
            System.out.println(name+"�ĳɼ�Ϊ��"+score);
          else
            System.out.println("û���ҵ�����: "+name);
       }
       else
          goon=false;
    }
    in.close();
  }
}