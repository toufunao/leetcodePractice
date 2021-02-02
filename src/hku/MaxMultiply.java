package hku;

import java.util.Arrays;

public class MaxMultiply {
    public int max(int[] a){
        Arrays.sort(a);
        int len=a.length;
        int max=a[len-1]*a[len-2];
        max=Math.max(a[0]*a[1],max);
        
        return max;
    }
}
