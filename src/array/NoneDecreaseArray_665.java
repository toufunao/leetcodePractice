package array;

public class NoneDecreaseArray_665 {
    public boolean checkPossibility(int[] nums) {
        int n=nums.length;
        int count=0;
        for (int i=1;i<n;i++){
           if (nums[i]<nums[i-1]){
               if (i==1||nums[i]>=nums[i-2])
                   nums[i-1]=nums[i];
               else
                   nums[i]=nums[i-1];

               count++;
           }
        }
        return count>1?false:true;
    }
}
