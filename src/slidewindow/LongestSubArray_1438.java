package slidewindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSubArray_1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque=new ArrayDeque<>();
        Deque<Integer> minDeque=new ArrayDeque<>();

        int left=0;
        int right=0;
        int ans=0;

        while (right<nums.length){
            while (!maxDeque.isEmpty() && maxDeque.peekLast()<nums[right])
                maxDeque.removeLast();
            maxDeque.add(nums[right]);

            while (!minDeque.isEmpty() && minDeque.peekLast()>nums[right])
                minDeque.removeLast();
            minDeque.add(nums[right]);

            right++;

            while (maxDeque.peek()-minDeque.peek()>limit){
                if (maxDeque.peek()==nums[left])
                    maxDeque.remove();

                if (minDeque.peek()==nums[left])
                    minDeque.remove();

                left++;
            }

            ans=Math.max(ans,right-left);
        }
        return ans;
    }
}
