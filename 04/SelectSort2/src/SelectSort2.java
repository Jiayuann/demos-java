public class SelectSort2{
 // 排序
   public static int[] orderby(int[] nums, String str){
       // 从大到小排
       if(str.equalsIgnoreCase("desc")){
           for(int i=0;i<nums.length;i++){
               for(int j = i+1;j<nums.length;j++){
                  if(nums[i] < nums[j]){
                     int tem = nums[i];
                     nums[i] = nums[j];
                     nums[j] = tem;
                  }  
               }
            } 
       }
       // 从小到大排
       else if(str.equalsIgnoreCase("esc")){
            for(int i=0; i<nums.length; i++){
               for(int j = i+1; j<nums.length; j++){
                  if(nums[i]>nums[j]){
                     int tem = nums[i];
                     nums[i] = nums[j];
                     nums[j] = tem;
                  }  
               }
            }       
       }
       return nums;
   }
   public static void main(String[] args){
       int[] nums = orderby(new int[]{1,5,2,4,9,36,5,7,8,3}, "desc");
       for(int n =0 ; n<nums.length; n++){
          System.out.print(nums[n] + " ");
       }
   }
}
