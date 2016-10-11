public class BubbleSort {
 public void sortArry(){
  int arr[]={2,1,5,8,21,12};
  System.out.println("冒泡排序前的结果是：");
  for(int i=0;i<arr.length;i++){
   System.out.print("  "+arr[i]);
  }
  for(int i=0;i<arr.length-1;i++){
   for(int j=0;j<arr.length-1-i;j++){
    if(arr[j]>arr[j+1]){
     int temp=arr[j];
     arr[j]=arr[j+1];
     arr[j+1]=temp;
    }
   }
  }
  System.out.println("\n冒泡排序后的结果是：");
  for(int i=0;i<arr.length;i++){
   System.out.print("  "+arr[i]);
  }
 }
 public static void main(String args[]){
	 BubbleSort p=new BubbleSort();
  p.sortArry();
 }
}