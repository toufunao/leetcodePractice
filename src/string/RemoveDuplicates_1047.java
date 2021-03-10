package string;

import java.util.Stack;

public class RemoveDuplicates_1047 {
    public String removeDuplicates(String S) {
        StringBuilder stringBuilder=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        char[] chars=S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.empty()&&stack.peek()==chars[i]){
                stack.pop();
            }else
                stack.push(chars[i]);
        }
        while (!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
