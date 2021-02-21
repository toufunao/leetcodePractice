package priority_queue;


import java.util.PriorityQueue;

//703题
public class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        priorityQueue=new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size()>k)
            priorityQueue.poll();

        return priorityQueue.peek();
    }
}
