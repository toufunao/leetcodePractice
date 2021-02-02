package dp;

public class MaxContinousSum {
    public int maxSubArray(int[] nums) {
        int res=0;
        int max=nums[0];
        for (int x:nums){
            res=Math.max(res+x,x);
            max=Math.max(max,res);
        }
        return max;
    }
}
