import java.util.*; 
public class showCalendar{ 
  //用来显示日历头
  static final String head[] ={"星期日  ","星期一  ","星期二  ","星期三  ","星期四  ","星期五  ","星期六  "};
  public static void main(String[] args) { 
    Scanner in = new Scanner(System.in);
    int i;
    System.out.print("请输入年份：");
    int year = in.nextInt();
    System.out.print("请输入月份：");
    int month = in.nextInt() - 1; //GregorianCalendar的第一个月是0，和人的理解不同
    in.close();
    //以指定的年、月、该月的第一天来创建对象
    GregorianCalendar cal = new GregorianCalendar(year,month,1);
    //获取这个月的天数
    int totalDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    //获取这个月的第一天是星期几
    int startDay = cal.get(Calendar.DAY_OF_WEEK)-1;
    //输出日历头部，每一个输出项占8个字符宽度
    for(i=0; i<head.length; i++)
      System.out.print(head[i]+"  ");
    System.out.println();
    //输出第一天之前的空格
    for(i=0;i<startDay;i++)
      System.out.print("        ");
    //依次输出每一天，每一个输出项占8个字符宽度
    for(int day=1; day<=totalDays;day++){
      System.out.printf("   %2d   ",day);
      i++;
      if (i==7){ //每个星期输出完，换行
        System.out.println();
        i=0;
      }  
    }   
  }
}