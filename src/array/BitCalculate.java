package array;

public class BitCalculate {
    //要求时间复杂度为线性，不使用额外空间。 使用异或运算
    public int singleNumber(int[] nums) {
        int single=0;
        for(int num:nums){
            single^=num;
        }

        return single;
    }
}
