package onedayoneproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LargeGroupPositions_21_01_05 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> group=new ArrayList<List<Integer>>();
        char[] chars=s.toCharArray();
        int num=1;
        int n=chars.length;
        for (int i=0;i<n;i++){
            if(i==n-1||chars[i]!=chars[i+1]){
                if (num>=3){
                    group.add(Arrays.asList(i-num+1,i));
                }
                num=1;
            }else {
                num++;
            }
        }
        return group;
    }
}
