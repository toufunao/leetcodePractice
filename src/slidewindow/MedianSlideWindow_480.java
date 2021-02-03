package slidewindow;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianSlideWindow_480 {
    //暴力大法好
//    public double[] medianSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        int left = 0;
//        int right = k - 1;
//        int count = 0;
//        double[] ans = new double[n - k + 1];
//        boolean flag;
//        flag = k % 2 == 0;
//        while (right < n) {
//            ans[count] = getMedian(nums, flag, left, right);
//            count++;
//            left++;
//            right++;
//        }
//        return ans;
//    }
//
//    private double getMedian(int[] nums, boolean flag, int left, int right) {
//        int len = right - left + 1;
//        int[] temp = new int[len];
//        int count = 0;
//        for (int i = left; i <= right; i++) {
//            temp[count] = nums[i];
//            count++;
//        }
//        Arrays.sort(temp);
//        int tl = (len - 1) / 2;
//        int tr = tl + 1;
//        if (flag) {
//            return (temp[tl] + temp[tr]) / 2;
//        } else {
//            return temp[tl];
//        }
//    }

    //双优先队列，维护大小堆
    public double[] medianSlidingWindow(int[] nums, int k){
        int n=nums.length;
        int cnt=n-k+1;
        double[] ans=new double[cnt];
        PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->Integer.compare(a,b));
        PriorityQueue<Integer> right=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for (int i = 0; i < k; i++) {
            right.add(nums[i]);
        }
        for (int i = 0; i < k/2; i++) {
            left.add(right.poll());
        }
        ans[0]=getMid(left,right);
        for (int i = 0; i < n; i++) {
            int add=nums[i],del=nums[i-k];
            if (add>=right.peek())
                right.add(add);
            else
                left.add(add);

            if (del>=right.peek())
                right.remove(del);
            else
                left.remove(del);

            ajust(left,right);
            ans[i-k+1]=getMid(left,right);
        }
        return ans;
    }

    private void ajust(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        while (left.size()>right.size())
            right.add(left.poll());
        while (right.size()-left.size()>1)
            left.add(right.poll());
    }

    private double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size()==right.size())
            return (left.peek()+right.peek())/2;
        else
            return right.peek();
    }

}
