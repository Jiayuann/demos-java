import java.util.*;
public class showClothValue{
  public static void main(String args[]){ 
    Scanner in = new Scanner(System.in); //׼���Ӽ�������
    String type;
    Size  size;
    boolean goon = true;
    System.out.print("�������·��ͺţ�������SMALL,MEDIUM,LARGE,EXTRA_LARGE��");
    System.out.println("���б�ʾ����");
    while(goon){
      System.out.print("�������ͺţ�");
      type = in.nextLine().toUpperCase();
      if (type.length()>0){
        size = (Size)Enum.valueOf(Size.class,type);
        System.out.println(type+"�ļ۸�Ϊ��"+size.getValue());
      } 
      else
         goon=false;
    }
    in.close();
  }  
}