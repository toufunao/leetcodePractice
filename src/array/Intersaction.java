package array;

import java.time.chrono.MinguoChronology;
import java.util.HashSet;
import java.util.Set;

public class Intersaction {
    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> t = new HashSet<>();
        Set<Integer> p = new HashSet<>();
        for (int i : nums1)
            t.add(i);

        for (int j : nums2) {
            if (t.contains(j)) {
                p.add(j);
            }
        }

        int[] ans = new int[p.size()];
        int count=0;
        for (Integer item:p){
            ans[count++]=item;
        }
        return ans;
    }

    public static void main(String[] args) {
        intersection(new int[]{1, 2, 3}, new int[]{2});
    }
}
