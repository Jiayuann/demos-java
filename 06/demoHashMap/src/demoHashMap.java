import java.util.*;
import java.io.*;
public class demoHashMap{
  public static void main(String args[]){
    //创建一个关键字为String类型、记录为Integer类型的哈希表
    HashMap<String,Integer> stu = new HashMap<String,Integer>();
    Scanner in = new Scanner(System.in); //准备从键盘输入
    String name;
    Integer score;
    System.out.println("请依次输入学生姓名和成绩，空行表示结束");
    boolean goon = true;
    
    while(goon){  //循环输入学生姓名和成绩
       System.out.print("请输入姓名：");
       name = in.nextLine();
       if (name.length()>0){
         System.out.print("请输入成绩：");
         score = new Integer(in.nextLine());     		
         stu.put(name,score);	//插入到哈希表中
       } 
       else
          goon=false;
    }
    System.out.println("请输入要查找的学生姓名，空行表示结束");
    goon=true;
    while(goon){
       name = in.nextLine();
       if (name.length()>0){
          score=stu.get(name);  //查找指定学生
          if(score!=null)	
            System.out.println(name+"的成绩为："+score);
          else
            System.out.println("没有找到此人: "+name);
       }
       else
          goon=false;
    }
    in.close();
  }
}