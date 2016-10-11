import java.util.*;		//HashSet在util包中
import java.io.*;		//Scanner在io包中
public class demoHashSet{
  public static void main(String args[]){
    HashSet<String> stu = new HashSet<String>();//创建一个String类型的哈希表
    Scanner in = new Scanner(System.in);			 //准备从键盘输入
    String name;
    System.out.println("请依次输入学生姓名，空行表示结束");
    boolean goon = true;
    while(goon){					//循环输入学生姓名
       name = in.nextLine();
       if (name.length()>0)		//若读入了空行，则name的长度为0
          stu.add(name);			//插入到哈希表中
       else
          goon=false;
    }
    System.out.println("请输入要删除的学生姓名，空行表示结束");
    goon=true;
    while(goon){					//循环删除指定的学生
       name = in.nextLine();
       if (name.length()>0){
          if(stu.remove(name))	//删除指定元素
            System.out.println("删除成功: "+name);
          else
            System.out.println("没有找到此人: "+name);
       }
       else
          goon=false;
    }
    System.out.println("还剩下的学生有：");
    for(String stName : stu)//遍历哈希表
      System.out.println(stName);
    in.close();
  }
}