	import java.util.Arrays;   
	import java.util.Random;   
	  
	public class SortSequence {   
	    public static void main(String[] args) {   
	        Random rd = new Random();   
	        int[] array = new int[15];              // ��������   
	        System.out.println("û��ʹ��sort����ǰ�����飺");   
	        for (int i = 0; i < array.length; i++) {     // ����������������15��0��20֮��������   
	            array[i] = rd.nextInt(20);          // ��array���鸳ֵ   
	            System.out.print(" " + array[i]);   
	            if ((i + 1) % 5 == 0)   
	                System.out.println();   
	        }   
	        Arrays.sort(array);                 // ��array���������������   
	        System.out.println("\nʹ��sort����������飺");   
	        for (int i = 0; i < array.length; i++) {     // ��array�����е��������   
	            System.out.print(" " + array[i]);   
	            if ((i + 1) % 5 == 0)   
	                System.out.println();   
	        }   
	    }   
	}  
