import java.util.*;
import java.io.*;
public class demoTreeSet{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    CompareScore comp = new CompareScore();
    //��compΪ�Ƚ���������һ�ú����
    TreeSet<Student> stuTree = new TreeSet<Student>(comp);
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
         stuTree.add(new Student(name,score));	//���뵽����
       } 
       else
          goon=false;
    }
    in.close();
    System.out.println("ѧ���ɼ����������У�");
    Iterator it = stuTree.iterator();
    while(it.hasNext()){
       Student st = (Student)it.next();
       System.out.println("������"+st.getName()+" �ɼ�:"+st.getScore());
    }
  }
}