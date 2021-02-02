package array;

import java.util.Arrays;

public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int gap=10000;

        for (int first=0;first<n;first++){
            if (first>0 && nums[first]==nums[first-1])
                continue;

            int second=first+1;
            int third=n-1;

            while (second<third){
                int sum=nums[first]+nums[second]+nums[third];

                if (sum==target)
                    return target;

                if (Math.abs(sum-target)<Math.abs(gap-target))
                    gap=sum;

                if (sum>target){
                   third--;

                }else {
                   second++;
                }
            }
        }
        return gap;

    }
}
