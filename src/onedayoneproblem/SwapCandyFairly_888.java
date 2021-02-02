package onedayoneproblem;

import java.util.*;

public class SwapCandyFairly_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans=new int[2];
        int sumA= Arrays.stream(A).sum();
        int sumB=Arrays.stream(B).sum();
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<A.length;i++)
            set.add(A[i]);

        for (int i=0;i<B.length;i++){
            int temp=B[i]+(sumA-sumB)/2;
            if (set.contains(temp)){
                ans[0]=temp;
                ans[1]=B[i];
                return ans;
            }
        }
        return ans;
    }
}
