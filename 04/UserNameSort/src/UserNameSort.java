import java.util.*;
class  userName implements Comparable
	{
	public String sName;
	public userName(String sName)
	 {
	  this.sName=sName;
	 }
	 public int compareTo(Object o)//��дcompareTo����
	 {
		 userName tempuser=(userName)o;
	  String temp=tempuser.sName;
	  return this.sName.compareTo(temp); //���ַ���sName��˳������Student
	 }
	 public String toString()
	 {
	  return this.sName;
	 }
	}
public class UserNameSort {
    public  static void main(String args[])
	  {
        System.out.println("�������û���˳��Ϊ��");
	   TreeSet ts=new TreeSet();//����Student����ʱ�����Զ�����compareTo����
	   ts.add(new userName("Lester"));
	   ts.add(new userName("Jimmy"));
	   ts.add(new userName("Bob"));
	   System.out.println(ts);
	  }
} 