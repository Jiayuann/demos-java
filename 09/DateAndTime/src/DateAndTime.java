import java.util.*; 
public class DateAndTime{ 
  //����Ҫת���ɺ�����ʽ��ʾ������1��ʾ������
  static final char days[] ={' ','��','һ','��','��','��','��','��'};
  public static void main(String[] args) { 
    //��ȡ��ǰʱ�䣬��������
    Calendar cal = Calendar.getInstance();
    //��ȡ���
    int year = cal.get(Calendar.YEAR);
    //��ȡ�·ݣ�������0Ϊ��һ���£�����Ҫ��1
    int month = cal.get(Calendar.MONTH) + 1;
    //��ȡ����
    int date = cal.get(Calendar.DATE);
    //��ȡ���ڼ���������1Ϊ��1�죬Ҫ������days[]������
    int day = cal.get(Calendar.DAY_OF_WEEK);
    //��ȡСʱ������24Сʱ��
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    //��ȡ����
    int min = cal.get(Calendar.MINUTE);
    //��ȡ��
    int sec = cal.get(Calendar.SECOND);
    //�����й��˵�ϰ������ʾ���ں�ʱ��
    System.out.println("�����ǣ�"+year+"��"+month+"��"+date+"��"+"  ����"+days[day]); 
    System.out.println("���ڵ�ʱ���ǣ� "+hour+":"+min+":"+sec);
  }
}
