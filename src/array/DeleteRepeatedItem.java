package array;

public class DeleteRepeatedItem {
    public int removeDuplicates(int[] nums) {
        //快慢指针，慢支针计数，快指针进行遍历。如果重复快指针自增，否则慢支针计数增1，将快指针处数值复制到慢指针处。因为慢指针计数为下标值，因此在最终返回时需要再进行自增。
        int count=0;
        int len=nums.length;

        if (len==0)
            return 0;

        for (int i=1;i<len;i++){
            if (nums[count]!=nums[i]){
                count++;
                nums[count]=nums[i];
            }
        }
        count+=1;
        return count;
    }
}
