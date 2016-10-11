import java.util.*;
import java.io.*;
public class demoTreeMap{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    //以姓名为关键字，以学生记录为元素，创建一棵映射树
    TreeMap<String,Student> stuTreeMap = new TreeMap<String,Student>();
    String name;
    Integer score;
    Student st;
    System.out.println("请依次输入学生姓名和成绩，空行表示结束");
    boolean goon = true;
    while(goon){  //循环输入学生姓名和成绩
       System.out.print("请输入姓名：");
       name = in.nextLine();
       if (name.length()>0){
         System.out.print("请输入成绩：");
         score = new Integer(in.nextLine()); 
         st = new Student(name,score);
         stuTreeMap.put(name, st);	//插入到映射树中
       } 
       else
          goon=false;
    }
    System.out.println("请输入要查询的学生姓名，空行表示结束");
    goon = true;
    while(goon){  //循环输入学生姓名
       System.out.print("请输入姓名：");
       name = in.nextLine();
       if (name.length()>0){
         st = (Student)stuTreeMap.get(name);
         if(st!=null)
           System.out.println(st.getName()+"的成绩为："+st.getScore());
         else
           System.out.println("没有找到与"+name+"相应的记录");
       } 
       else
          goon=false;
    }    
    in.close();
  }
}