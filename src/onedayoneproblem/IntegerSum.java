package onedayoneproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class IntegerSum {
    public List<Integer> addToArrayForm(int[] A, int K) {

        int n=A.length;
        List<Integer> ans=new ArrayList<>();

        int sum=0;
        int carry=0;
        int i=n-1;
        while (i>=0||K!=0){
            int x;
            if (i>=0)
                x=A[i];
            else
                x=0;

            int y;
            if (K!=0)
                y=K%10;
            else
                y=0;

            sum=x+y+carry;
            carry=sum/10;

            i--;
            K/=10;
            ans.add(sum%10);
        }
        if (carry!=0)
            ans.add(carry);

        Collections.reverse(ans);
        return ans;

//        int len=A.length;
//        for (int i=0;i<len;i++){
//            sum=sum*10+A[i];
//        }
//        sum+=K;
//        List<Integer> ans=new ArrayList<>();
//        Stack<Integer> stack=new Stack<>();
//        while (sum!=0){
//            int rest=sum%10;
//            sum/=10;
//            stack.add(rest);
//        }
//
//        while (!stack.isEmpty()){
//            ans.add(stack.pop());
//        }
//        return ans;
    }
}
