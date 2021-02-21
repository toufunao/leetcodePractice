package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map=new HashMap<>();
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2]=i;
            }else {
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxNum=0,minLen=0;

        for (Map.Entry<Integer,int[]> mapEntity:map.entrySet()){
            int[] temp=mapEntity.getValue();
            if (maxNum<temp[0]){
                maxNum=temp[0];
                minLen=temp[2]-temp[1]+1;
            }else if (maxNum==temp[0]){
                if (minLen>temp[2]-temp[1]+1){
                    minLen=temp[2]-temp[1]+1;
                }
            }
        }

        return minLen;
    }
}
