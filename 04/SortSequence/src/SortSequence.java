	import java.util.Arrays;   
	import java.util.Random;   
	  
	public class SortSequence {   
	    public static void main(String[] args) {   
	        Random rd = new Random();   
	        int[] array = new int[15];              // 声明数组   
	        System.out.println("没有使用sort方法前的数组：");   
	        for (int i = 0; i < array.length; i++) {     // 利用随机数随意产生15个0～20之间的随机数   
	            array[i] = rd.nextInt(20);          // 给array数组赋值   
	            System.out.print(" " + array[i]);   
	            if ((i + 1) % 5 == 0)   
	                System.out.println();   
	        }   
	        Arrays.sort(array);                 // 对array数组进行升序排序   
	        System.out.println("\n使用sort方法后的数组：");   
	        for (int i = 0; i < array.length; i++) {     // 将array数组中的数据输出   
	            System.out.print(" " + array[i]);   
	            if ((i + 1) % 5 == 0)   
	                System.out.println();   
	        }   
	    }   
	}  
