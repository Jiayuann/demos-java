import java.util.*;
class  userName implements Comparable
	{
	public String sName;
	public userName(String sName)
	 {
	  this.sName=sName;
	 }
	 public int compareTo(Object o)//重写compareTo方法
	 {
		 userName tempuser=(userName)o;
	  String temp=tempuser.sName;
	  return this.sName.compareTo(temp); //按字符串sName的顺序排列Student
	 }
	 public String toString()
	 {
	  return this.sName;
	 }
	}
public class UserNameSort {
    public  static void main(String args[])
	  {
        System.out.println("排序后的用户名顺序为：");
	   TreeSet ts=new TreeSet();//插入Student对象时，会自动调用compareTo方法
	   ts.add(new userName("Lester"));
	   ts.add(new userName("Jimmy"));
	   ts.add(new userName("Bob"));
	   System.out.println(ts);
	  }
} 