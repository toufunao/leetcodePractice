package array;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track=new ArrayList<>();
        traverse(nums,track);
        return ans;
    }

    private void traverse(int[] nums, List<Integer> track) {
        if (track.size()==nums.length){
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if(track.contains(nums[i]))
                continue;

            track.add(nums[i]);
            traverse(nums,track);
            track.remove(track.size()-1);
        }
    }
}
