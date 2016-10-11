	public class quickSort {   
	    public static void main(String args[]) {   
        int[] intArray = { 12, 11, 45, 6, 8, 43, 40, 57, 3, 20 };   
	        System.out.println("����ǰ������:");   
	        for (int i = 0; i < intArray.length; i++) {   
	            System.out.print(" " + intArray[i]);            // �������Ԫ��   
	            if ((i + 1) % 5 == 0)                       // ÿ5��Ԫ��һ��   
	                System.out.println();   
	        }   
	        System.out.println();   
	        int[] b = quickSort(intArray, 0, intArray.length - 1);  // ����quickSort   
            System.out.println("ʹ�ÿ������򷨺������:");   
	        for (int i = 0; i < b.length; i++) {   
	            System.out.print(" " + b[i]);   
	            if ((i + 1) % 5 == 0)                       // ÿ5��Ԫ��һ��   
	                System.out.println();   
	        }   
	    }   
	    public static int getMiddle(int[] array, int left, int right) {   
	        int temp;   
	        // ����һ�˿�������,�������ĵ�λ��   
	        int mid = array[left];                          // ����������a[0]   
	        while (left < right) {   
	            while (left < right && array[right] >= mid)   
	                right--;   
	            temp = array[right];                        // �������ĵ�С�������ƶ������   
	            array[right] = array[left];   
	            array[left] = temp;   
	            while (left < right && array[left] <= mid)   
	                left++;   
	            temp = array[right];                        // �������ĵ��������ƶ����ұ�   
	            array[right] = array[left];   
	            array[left] = temp;   
	        }   
	        array[left] = mid;                          // �����Ƶ���ȷλ��   
	        return left;                                // �������ĵ�   
	    }   
	    public static int[] quickSort(int[] array, int left, int right) {// ��������   
	        if (left < right - 1) {          // �����ʼ��ͽ��û���ص���ʱ��Ҳ����ָ��û��ִ�е���β   	       
	        	int mid = getMiddle(array, left, right);        // ���»�ȡ�м��   
            quickSort(array, left, mid - 1);   
	            quickSort(array, mid + 1, right);   
	        }   
	        return array;   
	    }   
	}  
