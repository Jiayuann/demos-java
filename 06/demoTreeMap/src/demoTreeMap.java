import java.util.*;
import java.io.*;
public class demoTreeMap{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    //������Ϊ�ؼ��֣���ѧ����¼ΪԪ�أ�����һ��ӳ����
    TreeMap<String,Student> stuTreeMap = new TreeMap<String,Student>();
    String name;
    Integer score;
    Student st;
    System.out.println("����������ѧ�������ͳɼ������б�ʾ����");
    boolean goon = true;
    while(goon){  //ѭ������ѧ�������ͳɼ�
       System.out.print("������������");
       name = in.nextLine();
       if (name.length()>0){
         System.out.print("������ɼ���");
         score = new Integer(in.nextLine()); 
         st = new Student(name,score);
         stuTreeMap.put(name, st);	//���뵽ӳ������
       } 
       else
          goon=false;
    }
    System.out.println("������Ҫ��ѯ��ѧ�����������б�ʾ����");
    goon = true;
    while(goon){  //ѭ������ѧ������
       System.out.print("������������");
       name = in.nextLine();
       if (name.length()>0){
         st = (Student)stuTreeMap.get(name);
         if(st!=null)
           System.out.println(st.getName()+"�ĳɼ�Ϊ��"+st.getScore());
         else
           System.out.println("û���ҵ���"+name+"��Ӧ�ļ�¼");
       } 
       else
          goon=false;
    }    
    in.close();
  }
}