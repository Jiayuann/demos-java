import java.util.*;
import java.io.*;
public class demoTreeSet{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    CompareScore comp = new CompareScore();
    //以comp为比较器，创建一棵红黑树
    TreeSet<Student> stuTree = new TreeSet<Student>(comp);
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
         stuTree.add(new Student(name,score));	//插入到树中
       } 
       else
          goon=false;
    }
    in.close();
    System.out.println("学生成绩按降序排列：");
    Iterator it = stuTree.iterator();
    while(it.hasNext()){
       Student st = (Student)it.next();
       System.out.println("姓名："+st.getName()+" 成绩:"+st.getScore());
    }
  }
}