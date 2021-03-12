package tree;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidSerialization_331 {
    public boolean isValidSerialization(String preorder) {
        int n=preorder.length();
        int i=0;
        Deque<Integer> stack=new LinkedList<>();
        stack.push(1);
        while (i<n){
            if (stack.isEmpty())
                return false;
            if (preorder.charAt(i)==',')
                i++;
            else if (preorder.charAt(i)=='#'){
                int top=stack.pop()-1;
                if (top>0){
                    stack.push(top);
                }
                i++;
            }else {
                while (i<n && preorder.charAt(i)!=','){
                    i++;
                }
                int top=stack.pop()-1;
                if (top>0)
                    stack.push(top);
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}
