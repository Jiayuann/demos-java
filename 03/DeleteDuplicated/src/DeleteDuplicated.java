import java.util.Arrays;
public class DeleteDuplicated {
   public static void main(String[] args) {
   int[] a = new int[] {1,1,2,2,3,3,3,3,4};
   int[] b = new int[a.length];
   int i = 0;
   int j = 0;
   while(true) {
         b[j++] = a[i];   
   if(i == a.length-1)
      break;
   while(i<a.length-1&&a[i]==a[i+1])//��Ϊ�Ѿ��ź����ˣ�ֻ��Ҫ�Ƚ��������������С�������ڵ�������ȣ���ô�ͱȽ���һ��
      i++;
      i++;
   }
   System.out.println(Arrays.toString(b));
  }
}