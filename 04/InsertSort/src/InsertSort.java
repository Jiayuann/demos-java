import java.util.Scanner;

public class InsertSort
{

 public static void directSort(double n[])// 对数组下标为1的开始的元素进行直接插入排序
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
 }// 对10个数字进行插入排序
 
 public static void showSort(double[] num)
 {
  System.out.println("排序结果为：");
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
  
  System.out.println("输入0结束输入");
  
  while(true)
  {   
   
   System.out.println("\n请输入合法的数字：");
   newNumber = in.nextDouble();
   
   if(newNumber == 0f)
   {
    System.out.println("用户取消排序");
    break;
   }
   
   //临时数组
   double[] tmp = new double[num.length + 1];
   //复制数据
   System.arraycopy(num, 0, tmp, 0, num.length);
   tmp[num.length] = newNumber;
   //指向新的数组
   num = tmp;
   //排序并输出
   directSort(num);
   showSort(num);
   
  }

 }
}