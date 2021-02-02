package array;

import java.util.*;

public class PrefixDivideBy5 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        int n=A.length;
        Boolean[] ans=new Boolean[A.length];
        int sum=0;
        for (int i=0;i<n;i++){
            sum=(sum*2+A[i])%10;                   //此处模10可以解决数据溢出问题
            if (sum%5==0)
                ans[i]=true;
            else
                ans[i]=false;
        }

        return Arrays.asList(ans);
    }

    public static void main(String[] args){
        List<Boolean> list=prefixesDivBy5(new int[]{1,1,1,0,1});
        for (Boolean b :list){
            System.out.println(b);
        }
    }
}
