
public class ArrayMaxMin {
	public static void main(String arg[]){
		int i,min,max;
		int A[]={25,65,98,36,45};
		min=max=A[0];
		System.out.print("数组A的元素包括：");
		for(i=0;i<A.length;i++){
			System.out.print(A[i]+" ");
			if(A[i]>max)
				max=A[i];
			if(A[i]<min)
				min=A[i];			
		}
		System.out.println("\n数组的最大值是："+max);
		System.out.println("数组的最小值是："+min);
	}
}
