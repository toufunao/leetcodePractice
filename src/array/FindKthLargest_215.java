package array;

import java.util.Arrays;

public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int len=nums.length;
        int[] reverse=new int[len];
        for (int i=0;i<len;i++){
            reverse[i]=nums[len-1-i];
        }
        return reverse[k-1];


    }

}
