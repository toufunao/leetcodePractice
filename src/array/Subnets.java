package array;

import java.util.ArrayList;
import java.util.List;

public class Subnets {
    List<List<Integer>> ans=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track=new ArrayList<>();
        backTrack(nums,0,track);
        return ans;
    }

    private void backTrack(int[] nums, int start, List<Integer> track) {
        ans.add(new ArrayList<>(track));
        for (int i=start;i<nums.length;i++){
            track.add(nums[i]);
            backTrack(nums,i+1,track);

            track.remove(track.size()-1);
        }
    }
}
