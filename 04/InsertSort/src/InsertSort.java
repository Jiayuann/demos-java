import java.util.Scanner;

public class InsertSort
{

 public static void directSort(double n[])// �������±�Ϊ1�Ŀ�ʼ��Ԫ�ؽ���ֱ�Ӳ�������
 {
  int i, j;
  for (i = 2; i < n.length; i++)
  {
   n[0] = n[i];
   for (j = i - 1; j > 0 && n[j] > n[0]; j--)
    n[j + 1] = n[j];
   ;
   n[j + 1] = n[0];
  }
 }// ��10�����ֽ��в�������
 
 public static void showSort(double[] num)
 {
  System.out.println("������Ϊ��");
  for (int i = 1 ; i < num.length; i++)
  {
   System.out.print(num[i] + "    ");
  }
 }

 public static void main(String args[])
 {
  double[] num = {0}; 
  Scanner in = new Scanner(System.in);
  double newNumber;
  
  System.out.println("����0��������");
  
  while(true)
  {   
   
   System.out.println("\n������Ϸ������֣�");
   newNumber = in.nextDouble();
   
   if(newNumber == 0f)
   {
    System.out.println("�û�ȡ������");
    break;
   }
   
   //��ʱ����
   double[] tmp = new double[num.length + 1];
   //��������
   System.arraycopy(num, 0, tmp, 0, num.length);
   tmp[num.length] = newNumber;
   //ָ���µ�����
   num = tmp;
   //�������
   directSort(num);
   showSort(num);
   
  }

 }
}