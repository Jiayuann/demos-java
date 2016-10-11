import java.util.*; 
public class demoFmtTime{ 
  public static void main(String[] args) { 
     //以标准输出设备为目标，创建对象
     Formatter fmt = new Formatter(System.out);
     //获取当前时间
     Date dt = new Date();
     //以各种格式输出日期和时间
     fmt.format("现在的日期和时间（以默认的完整格式）：%tc\n",dt);
     fmt.format("今天的日期（按中国习惯）：%1$tY-%1$tm-%1$td\n",dt);
     fmt.format("今天是：%tA\n",dt);
     fmt.format("现在的时间（24小时制）:%tT\n",dt);
     fmt.format("现在的时间（12小时制）:%tr\n",dt);
     fmt.format("现在是：%tH点%1$tM分%1$tS秒",dt);     
  }
}