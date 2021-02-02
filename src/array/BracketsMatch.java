package array;

import java.util.Stack;

public class BracketsMatch {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char temp;
        for (int i=0;i<s.length();i++){
            char t=s.charAt(i);
            switch (t){
                case '(': stack.push(t);break;
                case '{': stack.push(t);break;
                case '[': stack.push(t);break;
//                case ')':
//                    if (!stack.isEmpty()) {
//                        temp = stack.pop();
//                        if (temp != '(') {
//                            stack.push(temp);
//                            stack.push(t);
//                        }
//                    }else
//                        stack.push(t);
//                        break;
//                case '}':
//                    if (!stack.isEmpty()){
//                        temp=stack.pop();
//                        if (temp!='{'){
//                            stack.push(temp);
//                            stack.push(t);
//                        }
//                    }else
//                        stack.push(t);
//                    break;
//                case ']':
//                    if (!stack.isEmpty()){
//                        temp=stack.pop();
//                        if (temp!='['){
//                            stack.push(temp);
//                            stack.push(t);
//                        }
//                    }else
//                        stack.push(t);
//                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        temp = stack.pop();
                        if (temp != '(') {
                            stack.push(temp);
                            stack.push(t);
                        }
                    }else
                        return false;
                    break;
                case '}':
                    if (!stack.isEmpty()){
                        temp=stack.pop();
                        if (temp!='{'){
                            stack.push(temp);
                            stack.push(t);
                        }
                    }else
                        return false;
                    break;
                case ']':
                    if (!stack.isEmpty()){
                        temp=stack.pop();
                        if (temp!='['){
                            stack.push(temp);
                            stack.push(t);
                        }
                    }else
                       return false;
                    break;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
