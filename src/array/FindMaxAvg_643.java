package array;

public class FindMaxAvg_643 {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        for (int i=0;i<k;i++)
            sum+=nums[i];
        int maxSum=sum;
        for (int i=k;i<n;i++){
            sum=sum-nums[i-k]+nums[i];
            maxSum=Math.max(maxSum,sum);
        }

        return 1.0*maxSum/k;
    }
}
