	public class quickSort {   
	    public static void main(String args[]) {   
        int[] intArray = { 12, 11, 45, 6, 8, 43, 40, 57, 3, 20 };   
	        System.out.println("排序前的数组:");   
	        for (int i = 0; i < intArray.length; i++) {   
	            System.out.print(" " + intArray[i]);            // 输出数组元素   
	            if ((i + 1) % 5 == 0)                       // 每5个元素一行   
	                System.out.println();   
	        }   
	        System.out.println();   
	        int[] b = quickSort(intArray, 0, intArray.length - 1);  // 调用quickSort   
            System.out.println("使用快速排序法后的数组:");   
	        for (int i = 0; i < b.length; i++) {   
	            System.out.print(" " + b[i]);   
	            if ((i + 1) % 5 == 0)                       // 每5个元素一行   
	                System.out.println();   
	        }   
	    }   
	    public static int getMiddle(int[] array, int left, int right) {   
	        int temp;   
	        // 进行一趟快速排序,返回中心点位置   
	        int mid = array[left];                          // 把中心置于a[0]   
	        while (left < right) {   
	            while (left < right && array[right] >= mid)   
	                right--;   
	            temp = array[right];                        // 将比中心点小的数据移动到左边   
	            array[right] = array[left];   
	            array[left] = temp;   
	            while (left < right && array[left] <= mid)   
	                left++;   
	            temp = array[right];                        // 将比中心点大的数据移动到右边   
	            array[right] = array[left];   
	            array[left] = temp;   
	        }   
	        array[left] = mid;                          // 中心移到正确位置   
	        return left;                                // 返回中心点   
	    }   
	    public static int[] quickSort(int[] array, int left, int right) {// 快速排序法   
	        if (left < right - 1) {          // 如果开始点和结点没有重叠的时候，也就是指针没有执行到结尾   	       
	        	int mid = getMiddle(array, left, right);        // 重新获取中间点   
            quickSort(array, left, mid - 1);   
	            quickSort(array, mid + 1, right);   
	        }   
	        return array;   
	    }   
	}  
