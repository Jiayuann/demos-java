import java.util.*;		//HashSet��util����
import java.io.*;		//Scanner��io����
public class demoHashSet{
  public static void main(String args[]){
    HashSet<String> stu = new HashSet<String>();//����һ��String���͵Ĺ�ϣ��
    Scanner in = new Scanner(System.in);			 //׼���Ӽ�������
    String name;
    System.out.println("����������ѧ�����������б�ʾ����");
    boolean goon = true;
    while(goon){					//ѭ������ѧ������
       name = in.nextLine();
       if (name.length()>0)		//�������˿��У���name�ĳ���Ϊ0
          stu.add(name);			//���뵽��ϣ����
       else
          goon=false;
    }
    System.out.println("������Ҫɾ����ѧ�����������б�ʾ����");
    goon=true;
    while(goon){					//ѭ��ɾ��ָ����ѧ��
       name = in.nextLine();
       if (name.length()>0){
          if(stu.remove(name))	//ɾ��ָ��Ԫ��
            System.out.println("ɾ���ɹ�: "+name);
          else
            System.out.println("û���ҵ�����: "+name);
       }
       else
          goon=false;
    }
    System.out.println("��ʣ�µ�ѧ���У�");
    for(String stName : stu)//������ϣ��
      System.out.println(stName);
    in.close();
  }
}