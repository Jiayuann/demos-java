import java.util.*; 
public class showCalendar{ 
  //������ʾ����ͷ
  static final String head[] ={"������  ","����һ  ","���ڶ�  ","������  ","������  ","������  ","������  "};
  public static void main(String[] args) { 
    Scanner in = new Scanner(System.in);
    int i;
    System.out.print("��������ݣ�");
    int year = in.nextInt();
    System.out.print("�������·ݣ�");
    int month = in.nextInt() - 1; //GregorianCalendar�ĵ�һ������0�����˵���ⲻͬ
    in.close();
    //��ָ�����ꡢ�¡����µĵ�һ������������
    GregorianCalendar cal = new GregorianCalendar(year,month,1);
    //��ȡ����µ�����
    int totalDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    //��ȡ����µĵ�һ�������ڼ�
    int startDay = cal.get(Calendar.DAY_OF_WEEK)-1;
    //�������ͷ����ÿһ�������ռ8���ַ����
    for(i=0; i<head.length; i++)
      System.out.print(head[i]+"  ");
    System.out.println();
    //�����һ��֮ǰ�Ŀո�
    for(i=0;i<startDay;i++)
      System.out.print("        ");
    //�������ÿһ�죬ÿһ�������ռ8���ַ����
    for(int day=1; day<=totalDays;day++){
      System.out.printf("   %2d   ",day);
      i++;
      if (i==7){ //ÿ����������꣬����
        System.out.println();
        i=0;
      }  
    }   
  }
}