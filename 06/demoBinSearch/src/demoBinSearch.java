import java.util.*; 
public class demoBinSearch{
  public static void main(String args[]){ 
    ArrayList<Integer> ls =new ArrayList<Integer>();
    Integer key;
    Scanner in = new Scanner(System.in); 
    boolean  goon=true;
    int index;
    for (int i=0;i<10;i++)
      ls.add((int)(Math.random()*1000));
    Collections.sort(ls);
    System.out.print("已排序的数据是：");
    showList(ls); 
    System.out.println("请输入你要查找的关键字，小于等于0表示结束：");
    while(goon){
       System.out.print("请输入你要查找的关键字：");
       key = in.nextInt();
       if (key>0){
          index = Collections.binarySearch(ls,key);
          if(index>=0)	
            System.out.println("查找成功，在"+index+"号位置");
          else
            System.out.println("没有找到"+key);
       }
       else
          goon=false;
    }
    in.close();
  }
  public static  void showList(ArrayList<Integer> ls){
     for(Integer elem : ls)
       System.out.print(elem + " ");
     System.out.println();
  }
}
