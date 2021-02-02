package onedayoneproblem;

import java.util.ArrayList;
import java.util.List;

public class SummerizeRanges_21_01_10 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        int i=0;
        int n=nums.length;
        while (i<n){
            int low=i;
            i++;
            while (i<n && nums[i]==nums[i-1]+1)
                i++;

            int high=i-1;
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(nums[low]);
            if (low<high){
                stringBuilder.append("->");
                stringBuilder.append(nums[high]);
            }
            ans.add(stringBuilder.toString());
        }
        return ans;
    }
}
