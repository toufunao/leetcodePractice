package onedayoneproblem;

public class Rotate_21_01_08 {
    public void rotate(int[] nums, int k) {
      int length=nums.length;
      k=k%10;

      reverse(nums,0,length-1);
      reverse(nums,0,k-1);
      reverse(nums,k-1,length-1);
    }

    public void reverse(int[] array,int start,int end){
        while (start<end){
            int t=array[start];
            array[start]=array[end];
            array[end]=t;
            start++;
            end--;
        }
    }
}
