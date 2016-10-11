import java.util.*;
public class showClothValue{
  public static void main(String args[]){ 
    Scanner in = new Scanner(System.in); //准备从键盘输入
    String type;
    Size  size;
    boolean goon = true;
    System.out.print("请输入衣服型号，包括：SMALL,MEDIUM,LARGE,EXTRA_LARGE。");
    System.out.println("空行表示结束");
    while(goon){
      System.out.print("请输入型号：");
      type = in.nextLine().toUpperCase();
      if (type.length()>0){
        size = (Size)Enum.valueOf(Size.class,type);
        System.out.println(type+"的价格为："+size.getValue());
      } 
      else
         goon=false;
    }
    in.close();
  }  
}