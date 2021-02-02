package array;

public class MajorityNumber_169 {
    public int majorityElement(int[] nums) {
        int count=0;
        int max=Integer.MAX_VALUE;
        for (int num:nums) {
            if (count==0)
                max=num;

            if (max==num){
                count++;
            }else {
                count--;
            }
        }

        return max;
    }
}
