package onedayoneproblem;

import java.util.Arrays;

public class MiddleIndex {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            if (preSum * 2 + nums[i] == sum)
                return i;
            preSum += nums[i];
        }
        return -1;
    }
}
