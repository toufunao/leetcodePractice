package array;

import java.util.Arrays;

public class ContainDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for (int i=0;i<n-1;i++){
            if (nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
}
