package array;

import special.MultiplyExceptSelf;

import java.util.Arrays;

public class TestMES {
    public static void main(String[] args){
        char[] tns=new char[]{'1','2'};
        StringBuilder stringBuilder=new StringBuilder();
        System.out.println(stringBuilder.append(tns));
        MultiplyExceptSelf a=new MultiplyExceptSelf();
        int[] ans=a.productExceptSelf(new int[]{1,2,3,4});
        Arrays.stream(ans).iterator();
    }
}
