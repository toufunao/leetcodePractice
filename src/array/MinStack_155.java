package array;

import java.util.Stack;

public class MinStack_155 {
    int min;
    Stack<Integer> stack;
    public MinStack_155() {
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            min=x;
            stack.push(x-min);
        }else {
            stack.push(x-min);
            if (x<min)
                min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;

        int pop=stack.pop();
        if (pop<0)
            min=min-pop;
    }

    public int top() {
        int top=stack.peek();
        if (top<0)
            return min;
        else
            return top+min;
    }

    public int getMin() {
        return min;
    }
}
