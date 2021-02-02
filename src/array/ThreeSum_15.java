package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        List<List<Integer>> group=new ArrayList<List<Integer>>();
        int n=nums.length;
        Arrays.sort(nums);
        for (int first=0;first<n;first++){
            if (first>0&&nums[first]==nums[first-1])
                continue;

            int third=n-1;
            int target=-nums[first];

            for (int second=first+1;second<n;second++){
                if (second>first+1 && nums[second]==nums[second-1])
                    continue;

                while (second<third&&nums[second]+nums[third]>target){
                    third--;
                }

                if (second==third)
                    break;
                if (nums[second]+nums[third]==target){
                    List<Integer> res=new ArrayList<>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[third]);
                    group.add(res);
                }
            }
        }

        return group;
        */
        List<List<Integer>> group=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length=nums.length;
        for (int i=0;i<length;i++){
            List<List<Integer>> midAnswer=twoSum(nums,i+1,-nums[i]);
            for (List<Integer> temp:midAnswer){
                temp.add(nums[i]);
                group.add(temp);
            }

            while (i<length-1&&nums[i]==nums[i+1]) i++;
        }
        return group;
    }

    public List<List<Integer>> twoSum(int[] nums,int start,int target){
        List<List<Integer>> ans=new ArrayList<>();
        int left=start;
        int right=nums.length-1;
        while (left<right){
            int sum=nums[left]+nums[right];
            int lt=nums[left];
            int rt=nums[right];
            if (sum==target){
                List<Integer> t=new ArrayList<>();
                t.add(nums[left]);
                t.add(nums[right]);
                ans.add(t);
                while (left<right&&nums[left]==lt) left++;
                while (left<right&&nums[right]==rt) right--;
            }else if (sum<target){
                while (left<right&&nums[left]==lt) left++;
            }else {
                while (left<right&&nums[right]==rt) right--;
            }
        }

        return ans;
    }
}
